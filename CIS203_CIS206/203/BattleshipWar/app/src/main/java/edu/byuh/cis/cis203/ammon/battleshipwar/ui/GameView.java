package edu.byuh.cis.cis203.ammon.battleshipwar.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

import edu.byuh.cis.cis203.ammon.battleshipwar.R;
import edu.byuh.cis.cis203.ammon.battleshipwar.sprite.Airplane;
import edu.byuh.cis.cis203.ammon.battleshipwar.sprite.Battleship;
import edu.byuh.cis.cis203.ammon.battleshipwar.sprite.DepthCharge;
import edu.byuh.cis.cis203.ammon.battleshipwar.sprite.Direction;
import edu.byuh.cis.cis203.ammon.battleshipwar.sprite.Missile;
import edu.byuh.cis.cis203.ammon.battleshipwar.sprite.Submarine;
import edu.byuh.cis.cis203.ammon.battleshipwar.sprite.TickListener;
import edu.byuh.cis.cis203.ammon.battleshipwar.sprite.Timer;

/**
 * GameView extends the Android View class to render the elements of the Battleship War clone made
 * as part of the BYUH Fall 2022 CIS 203 class.
 *
 * @author Ammon Turner
 * @version %I%, %G%
 * @since 0.1
 */
public class GameView extends View implements TickListener {

    private final Paint paint;
    private Battleship ship;
    private final ArrayList<Airplane>  planes;
    private final ArrayList<Submarine> subs;
    private final ArrayList<DepthCharge> charges;
    private final ArrayList<Missile> missiles;
    private Bitmap water;
    private Bitmap fireMissile;
    private boolean initialized;
    private Timer timer;
    private int score = 0;

    /**
     * The Constructor of the GameView class.
     * This method calls the constructor of the <code>View</code> class, passing the <code>Context
     * </code> c parameter. Following the call to super, this will initialize the fields, putting
     * in the images used as sprites.
     *
     * @param c The Context the view is running in.
     * @see     Context
     * @since   0.1
     */
    public GameView(Context c) {
        super(c);
        paint = new Paint();
        paint.setStrokeWidth(10);
        water = BitmapFactory.decodeResource(getResources(), R.drawable.water);
        fireMissile = BitmapFactory.decodeResource(getResources(), R.drawable.star);
        paint.setColor(Color.WHITE);
        planes = new ArrayList<>();
        subs = new ArrayList<>();
        charges = new ArrayList<>();
        missiles = new ArrayList<>();
        initialized = false;
    }

    /**
     * This draws the sprites in the provided <code>Canvas</code>, implemented from
     * <code>android.view.View</code>.
     *
     * @param c The <code>Canvas</code> where the background is drawn
     * @see     Canvas
     * @since   0.1
     */
    @Override
    public void onDraw(Canvas c) {
        paint.setColor(Color.WHITE);
        c.drawPaint(paint);
        var screenWidth = getWidth();
        var screenHeight = getHeight();
        if (!initialized) {
            timer = new Timer();
            timer.addListener(this);
            water = Bitmap.createScaledBitmap(water, (screenWidth/20), (screenWidth/20), true);
            fireMissile = Bitmap.createScaledBitmap(fireMissile, (screenWidth/20), (screenWidth/20), true);
            var res = getResources();
            ship = new Battleship(res, screenWidth, screenHeight);
            for (int i=0; i<3; i++) {
                planes.add(new Airplane(res, screenWidth, screenHeight, timer));
                subs.add(new Submarine(res, screenWidth, screenHeight, timer));
            }
            initialized = true;
        }
        drawWater(c, screenWidth, screenHeight);
        for (Submarine s : subs) {
            s.draw(c);
        }
        for (Airplane a : planes) {
            a.draw(c);
        }
        for (DepthCharge d : charges) {
            d.draw(c);
        }
        ship.draw(c);
        for (Missile m : missiles) {
            m.draw(c);
        }
        paint.setTextSize(screenHeight/20f);
        paint.setColor(Color.BLACK);
        String printScore = "Score " + score;
        c.drawText(printScore, 10, (screenHeight/20f) + 5, paint);
    }

    /**
     * onTouchEvent is called when the screen is touched, my implementation will check where the
     * screen was touched and fire a missile or depth charge depending on where on the screen the
     * touch was. The bottom half of the screen will fire a depth charge, the top half will do
     * missiles.
     *
     * @param m The MotionEvent that is passed to the default version of onTouchEvent
     * @return true if the event was handled, false otherwise
     */
    @Override
    public boolean onTouchEvent(MotionEvent m) {
        float x = m.getX();
        float y = m.getY();
        float height = getHeight();
        float width = getWidth();

        if (m.getAction() == MotionEvent.ACTION_DOWN) {
            if (y > (height/2)) {
                charges.add(new DepthCharge(getResources(), width, height, timer));
            } else if (x > width/2) {
                missiles.add(new Missile(Direction.RIGHT_FACING, width, height, paint, fireMissile, timer));
            } else {
                missiles.add(new Missile(Direction.LEFT_FACING, width, height, paint, fireMissile, timer));
            }
        }
        return true;
    }

    /**
     * This draws the water for the game.
     * drawWater performs the necessary calculations to draw the water in the correct location. It
     * will then do the drawing in a simple for loop to cover the screen in a straight line.
     *
     * @param c         The <code>Canvas</code> where the water will be drawn
     * @param width     The width of the screen, used for calculating the number of water sprites to draw
     * @param height    The height of the screen, used to calculate the position of the sprites
     * @see             Canvas
     * @since           0.1
     */
    private void drawWater(Canvas c, int width, int height) {
        var drawHeight = height/2;
        var waterWidth = water.getWidth();
        var waterToDraw = width/waterWidth;
        for(int i=0; i<waterToDraw; i++) {
            var curWater = waterWidth*i;
            c.drawBitmap(water, curWater, drawHeight, paint);
        }
    }

    /**
     * Called each game tick by the Timer, checks for collisions between player attacks and enemies,
     * then redraws the screen.
     */
    @Override
    public void tick() {
        detectCollisions();
        invalidate();
    }

    /**
     * Loops through the planes and subs and checks if there are any collisions between the attacks
     * the player triggered. Will remove missiles and depth charges on collision, sets the enemy's
     * explosion, and increments the player's score.
     */
    @SuppressLint("NewApi")
    private void detectCollisions() {
        for (Airplane a : planes) {
            missiles.removeIf((m) -> {
                if (m.overlaps(a)) {
                    a.explode();
                    return true;
                }
                return false;
            });
            if (a.getIsExploding()) {
                score += a.getPointValue();
            }
        }
        for (Submarine s : subs) {
            charges.removeIf((c) -> {
                if (c.overlaps(s)) {
                    s.explode();
                    return true;
                }
                return false;
            });
            if (s.getIsExploding()) {
                score += s.getPointValue();
            }
        }
    }
}
