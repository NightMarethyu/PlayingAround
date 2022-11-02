package edu.byuh.cis.cis203.ammon.battleshipwar.sprite;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;

import edu.byuh.cis.cis203.ammon.battleshipwar.constants.Constants;

/**
 * Enemy is an extension of Sprite and adds functionality necessary for the enemies in the game.
 */
public abstract class Enemy extends Sprite {
    protected Size bigness;
    protected Direction direction;
    protected float screenWidth;
    protected float screenHeight;
    protected Resources res;
    protected int scaleSize;
    protected Bitmap explosion;
    private boolean isExploded;

    /**
     * The constructor of the Enemy class calls the default constructor and uses the Size.getRandomSize()
     * to randomize the size of the enemy.
     */
    public Enemy(Resources res, float screenWidth, float screenHeight, Timer timer) {
        super();
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
        this.res = res;
        isExploded = false;
        reset();
        timer.addListener(this);
    }

    /**
     * Reset will reset the sprite, easier then creating a new instance of the sprite.
     */
    private void reset() {
        changeDir();
        changeBig();
        bounds.offsetTo(setX(),setY());
        setVelocity();
    }

    /**
     * The Move method calls the move method in the Sprite class and will then check if the sprite
     * is off the screen. There is an if statement that will give the method a new random speed 5% of
     * the time. If the sprite is off screen, it will be assigned a new size.
     */
    @Override
    public void move() {
        super.move();
        if (Math.random() < Constants.MOVE_SPEED_CHANGE_CHANCE) {
            setVelocity();
        }
        if (isOutside()) {
            reset();
        }
    }

    /**
     * The override adds a check to let the explosion show on screen for one tick, then resets the
     * sprite to a new random setting.
     *
     * @param c the Canvas to draw the sprite on
     */
    @Override
    public void draw(Canvas c) {
        super.draw(c);
        if (isExploded) {
            isExploded = false;
            reset();
        }
    }

    /**
     * sets the sprite's image to the explosion, stops it on screen, and preps it for drawing the
     * explosion.
     */
    public void explode() {
        img = explosion;
        velocity.set(0, 0);
        isExploded = true;
    }

    /**
     * Allows read access to whether the sprite has exploded this tick or not. Used for incrementing
     * the player's score.
     *
     * @return      Whether the enemy has exploded this tick or not
     */
    public boolean getIsExploding() {
        return isExploded;
    }

    /**
     * This will check if the sprite is outside the visible area.
     *
     * @return  true if outside the visible area, otherwise false
     */
    protected boolean isOutside() {
        switch (direction) {
            case LEFT_FACING:
                return (bounds.left + scaleSize) < 0;
            case RIGHT_FACING:
                return bounds.left > screenWidth;
            default:
                return false;
        }
    }

    /**
     * get a random direction from the Direction enum.
     */
    protected void changeDir() {
        this.direction = Direction.getRandomDirection();
    }

    /**
     * Sets the x value for the sprite. The size of the screen if it is left facing or the size of
     * sprite set to a negative value if right facing
     *
     * @return  The appropriate x value to start drawing the sprite just off the screen
     */
    protected float setX() {
        if (direction == Direction.LEFT_FACING) {
            return screenWidth;
        }
        return -scaleSize;
    }

    /**
     * Sets the velocity to a random value between 10 and 20, can be either positive or negative.
     */
    protected void setVelocity() {
        switch (direction) {
            case RIGHT_FACING:
                super.setVelocity((int)(Math.random()*Constants.BASE_VELOCITY)+Constants.BASE_VELOCITY, 0);
                break;
            case LEFT_FACING:
                super.setVelocity((int)-(Math.random()*Constants.BASE_VELOCITY)-Constants.BASE_VELOCITY, 0);
                break;
        }
    }

    protected abstract void changeBig();
    protected abstract float setY();
    public abstract int getPointValue();
}
