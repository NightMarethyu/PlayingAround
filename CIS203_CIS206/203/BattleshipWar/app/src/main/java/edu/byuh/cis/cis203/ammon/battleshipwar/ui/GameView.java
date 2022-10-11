package edu.byuh.cis.cis203.ammon.battleshipwar.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

import edu.byuh.cis.cis203.ammon.battleshipwar.R;
import edu.byuh.cis.cis203.ammon.battleshipwar.sprite.Airplane;
import edu.byuh.cis.cis203.ammon.battleshipwar.sprite.Battleship;
import edu.byuh.cis.cis203.ammon.battleshipwar.sprite.DepthCharge;
import edu.byuh.cis.cis203.ammon.battleshipwar.sprite.Direction;
import edu.byuh.cis.cis203.ammon.battleshipwar.sprite.Enemy;
import edu.byuh.cis.cis203.ammon.battleshipwar.sprite.Missile;
import edu.byuh.cis.cis203.ammon.battleshipwar.sprite.Sprite;
import edu.byuh.cis.cis203.ammon.battleshipwar.sprite.Submarine;

/**
 * GameView extends the Android View class to render the elements of the Battleship War clone made
 * as part of the BYUH Fall 2022 CIS 203 class.
 *
 * @author Ammon Turner
 * @version %I%, %G%
 * @since 0.1
 */
public class GameView extends View {

    private final Paint paint;
    private Battleship ship;
    private ArrayList<Enemy> enemies;
    private ArrayList<DepthCharge> charges;
    private ArrayList<Missile> missiles;
    private Bitmap water;
    private Bitmap fireMissile;
    private boolean initialized;
    private Timer timer;

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
        enemies = new ArrayList<>();
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
        c.drawPaint(paint);
        var screenWidth = getWidth();
        var screenHeight = getHeight();
        if (!initialized) {
            water = Bitmap.createScaledBitmap(water, (screenWidth/20), (screenWidth/20), true);
            fireMissile = Bitmap.createScaledBitmap(fireMissile, (screenWidth/20), (screenWidth/20), true);
            var res = getResources();
            ship = new Battleship(res, screenWidth, screenHeight);
            for (int i = 0; i < 3; i++) {
                enemies.add(new Airplane(res, screenWidth, screenHeight));
                enemies.add(new Submarine(res, screenWidth, screenHeight));
            }
            timer = new Timer();
            initialized = true;
        }
        drawWater(c, screenWidth, screenHeight);
        for (Enemy e : enemies) {
            e.draw(c);
        }
        for (DepthCharge d : charges) {
            d.draw(c);
        }
        ship.draw(c);
        for (Missile m : missiles) {
            m.draw(c);
        }
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
                charges.add(new DepthCharge(getResources(), width, height));
            } else if (x > width/2) {
                missiles.add(new Missile(Direction.RIGHT_FACING, width, height, paint, fireMissile));
            } else {
                missiles.add(new Missile(Direction.LEFT_FACING, width, height, paint, fireMissile));
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
     * The Timer class uses the Android System's Handler class to call a function every 50 milliseconds.
     * This is used for the drawing of the game.
     */
    class Timer extends Handler {
        public Timer() {
            sendMessageDelayed(obtainMessage(), 50);
        }

        @Override
        public void handleMessage(Message m) {
            ArrayList<DepthCharge> remove = new ArrayList<DepthCharge>();
            ArrayList<Missile> noMissiles = new ArrayList<>();
            for (Enemy e : enemies) {
                e.move();
            }
            for (DepthCharge d : charges) {
                d.move();
                if (d.isOutside()) {
                    remove.add(d);
                }
            }
            for (Missile miss : missiles) {
                miss.move();
                if (miss.isOutside()) {
                    noMissiles.add(miss);
                }
            }
            for (Missile miss : noMissiles) {
                missiles.remove(miss);
            }
            for (DepthCharge d : remove) {
                charges.remove(d);
            }
            invalidate();
            sendMessageDelayed(obtainMessage(), 50);
        }
    }
}
