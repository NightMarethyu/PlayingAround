package edu.byuh.cis.cis203.ammon.battleshipwar.sprite;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * The Missile class creates a drawing on the screen representing a missile. The class will draw
 * a small explosion for one frame of animation where the missile starts.
 */
public class Missile extends Sprite {
    protected Direction direction;
    protected boolean fired;
    protected RectF fireBallBounds;
    protected Bitmap fireMissile;
    protected Paint paint;
    protected Timer timer;

    /**
     * Missile creates a new missile object.
     *
     * @param d             The direction the missile is facing and traveling
     * @param width         The width of the screen
     * @param height        The height of the screen
     * @param p             The paint object it will be drawn with
     * @param fireMissile   The image of the missile firing
     */
    public Missile(Direction d, float width, float height, Paint p, Bitmap fireMissile, Timer t) {
        direction = d;
        paint = new Paint(p);
        paint.setColor(Color.BLACK);
        int scaleW = (int)width/45;
        int scaleH = (int)height/20;
        bounds = new RectF(0, 0, scaleW, scaleH);
        this.fireMissile = fireMissile;
        fired = true;
        switch (d) {
            case LEFT_FACING:
                setVelocity(-scaleW, -scaleH);
                setPosition((int)width*3/8, (int)height/2);
                break;
            case RIGHT_FACING:
                setVelocity(scaleW, -scaleH);
                setPosition((int)width*5/8, (int)height/2);
                break;
        }
        fireBallBounds = new RectF(bounds);
        fireBallBounds.offset(-fireMissile.getWidth()/2f, -fireMissile.getWidth()/2f);
        timer = t;
        timer.addListener(this);
    }

    /**
     * Calls the superclass move method. If it is outside the screen it will remove itself from the
     * Timer's listener list.
     */
    @Override
    public void move() {
        super.move();
        if (bounds.bottom < 0) {
            timer.removeListener(this);
        }
    }

    /**
     * Draws a line representing the missile. On the first frame of animation it will draw the
     * fireball of the missile being fired.
     *
     * @param c the Canvas to draw the sprite on
     */
    @Override
    public void draw(Canvas c) {
        switch (direction) {
            case LEFT_FACING:
                c.drawLine(bounds.left, bounds.top, bounds.right, bounds.bottom, paint);
                break;
            case RIGHT_FACING:
                c.drawLine(bounds.right, bounds.top, bounds.left, bounds.bottom, paint);
                break;
        }
        if (fired) {
            c.drawBitmap(fireMissile, fireBallBounds.left, fireBallBounds.top, paint);
            fired = false;
        }
    }
}
