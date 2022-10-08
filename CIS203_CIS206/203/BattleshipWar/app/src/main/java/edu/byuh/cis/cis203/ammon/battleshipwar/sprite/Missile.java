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
public class Missile extends Sprite{
    protected Direction direction;
    protected boolean fired;
    protected RectF fireBallBounds;
    protected Bitmap fireMissile;
    protected Paint paint;

    /**
     * Missile creates a new missile object.
     *
     * @param d             The direction the missile is facing and traveling
     * @param width         The width of the screen
     * @param height        The height of the screen
     * @param p             The paint object it will be drawn with
     * @param fireMissile   The image of the missile firing
     */
    public Missile(Direction d, float width, float height, Paint p, Bitmap fireMissile) {
        direction = d;
        paint = new Paint(p);
        paint.setColor(Color.BLACK);
        bounds = new RectF(0, 0, 10, 50);
        this.fireMissile = fireMissile;
        fired = true;
        switch (d) {
            case LEFT_FACING:
                setVelocity(-10, -50);
                setPosition((int)width*3/8, (int)height/2);
                break;
            case RIGHT_FACING:
                setVelocity(10, -50);
                setPosition((int)width*5/8, (int)height/2);
                break;
        }
        fireBallBounds = new RectF(bounds);
        fireBallBounds.offset(-fireMissile.getWidth()/2f, -fireMissile.getWidth()/2f);
    }

    /**
     * isOutside checks the missiles location, if it is outside the screen bounds.
     *
     * @return  true if outside the screen bounds, false if still inside
     */
    public boolean isOutside() {
        return bounds.bottom < 0;
    }

    /**
     * Draws a line representing the missile. On the first frame of animation it will draw the
     * fireball of the missile being fired.
     *
     * @param c the Canvas to draw the sprite on
     */
    @Override
    public void draw(Canvas c) {
        if (direction == Direction.LEFT_FACING) {
            c.drawLine(bounds.left, bounds.top, bounds.right, bounds.bottom, paint);
        } else {
            c.drawLine(bounds.right, bounds.top, bounds.left, bounds.bottom, paint);
        }
        if (fired) {
            c.drawBitmap(fireMissile, fireBallBounds.left, fireBallBounds.top, paint);
            fired = false;
        }
    }
}
