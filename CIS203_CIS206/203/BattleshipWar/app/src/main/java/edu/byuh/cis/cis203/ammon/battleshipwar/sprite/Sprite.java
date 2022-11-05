package edu.byuh.cis.cis203.ammon.battleshipwar.sprite;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.RectF;

/**
 * Sprite sets up the basic necessary fields and methods to render and work with the images in the game.
 */
public abstract class Sprite implements TickListener {
  protected Bitmap img;
  protected RectF bounds;
  protected PointF velocity;

  /**
   * The constructor creates a new rectangle using RectF and initializes the img field to null.
   */
  public Sprite() {
    bounds = new RectF();
    img = null;
    velocity = new PointF();
  }

  /**
   * Set position changes the location on the screen using the bounds field's offsetTo method.
   * @param x the newLeft variable to be passed to offsetTo
   * @param y the newTop variable to be passed to offsetTo
   */
  public void setPosition(int x, int y) {
    bounds.offsetTo(x, y);
  }

  /**
   * Set velocity passes the new velocity value to the PointF.set method.
   * @param x new x velocity value
   * @param y new y velocity value
   */
  public void setVelocity(int x, int y) { velocity.set(x, y); }

  /**
   * Move the sprite by the speed set within the velocity field.
   */
  public void move() {
    bounds.offset(velocity.x, velocity.y);
  }

  /**
   * Draw will use the Canvas.drawBitmap method to draw the sprite to the screen.
   * @param c the Canvas to draw the sprite on
   */
  public void draw(Canvas c) {
    c.drawBitmap(img, bounds.left, bounds.top, null);
  }

  /**
   * Called each tick, moves the sprite.
   */
  @Override
  public void tick() {
    this.move();
  }

  /**
   * Checks if the sprite overlaps with another sprite. Uses the RectF.intersects function to check
   * for overlap between this sprite and the sprite passed through the parameter.
   *
   * @param s     Another sprite to check for the overlap between their bounding box
   * @return      A boolean answering the question of "Do these sprites overlap?"
   */
  public boolean overlaps(Sprite s) {
    return RectF.intersects(s.bounds, this.bounds);
  }
}
