package edu.byuh.cis.cis203.ammon.battleshipwar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * GameView extends the Android View class to render the elements of the Battleship War clone made
 * as part of the BYUH Fall 2022 CIS 203 class.
 *
 * @author Ammon Turner
 * @version %I%, %G%
 * @since 0.1
 */
public class GameView extends View {

    private Paint paint;
    private Bitmap ship;
    private Bitmap big_plane;
    private Bitmap med_plane;
    private Bitmap lit_plane;
    private Bitmap big_sub;
    private Bitmap med_sub;
    private Bitmap lit_sub;
    private Bitmap water;

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
        ship = BitmapFactory.decodeResource(getResources(), R.drawable.battleship);
        big_plane = BitmapFactory.decodeResource(getResources(), R.drawable.big_airplane);
        med_plane = BitmapFactory.decodeResource(getResources(), R.drawable.medium_airplane);
        lit_plane = BitmapFactory.decodeResource(getResources(), R.drawable.little_airplane);
        big_sub = BitmapFactory.decodeResource(getResources(), R.drawable.big_submarine);
        med_sub = BitmapFactory.decodeResource(getResources(), R.drawable.medium_submarine);
        lit_sub = BitmapFactory.decodeResource(getResources(), R.drawable.little_submarine);
        water = BitmapFactory.decodeResource(getResources(), R.drawable.water);
        paint.setColor(Color.WHITE);
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
        var shipHeight = ship.getHeight();
        var shipWidth = ship.getWidth();
        var shipPosL = (screenWidth/2) - (shipWidth/2);
        var shipPosT = (screenHeight/2) - (shipHeight/2);
        drawWater(c, screenWidth, screenHeight);
        c.drawBitmap(ship, shipPosL, shipPosT, paint);
        c.drawBitmap(big_plane, screenWidth/6, screenHeight/4, paint);
        c.drawBitmap(med_plane, (screenWidth*2/3), (screenHeight*3/20), paint);
        c.drawBitmap(lit_plane, (screenWidth/2), 150, paint);
        c.drawBitmap(big_sub, (int)(screenWidth*.75), (int)(screenHeight*.8), paint);
        c.drawBitmap(med_sub, med_sub.getWidth(), (int)(screenHeight*.6), paint);
        c.drawBitmap(lit_sub, (screenWidth*2/5), (screenHeight*4/5), paint);
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
        var drawHeight = height/2 + water.getHeight();
        var waterWidth = water.getWidth();
        var waterToDraw = width/waterWidth;
        for(int i=0; i<waterToDraw; i++) {
            var curWater = waterWidth*i;
            c.drawBitmap(water, curWater, drawHeight, paint);
        }
    }
}
