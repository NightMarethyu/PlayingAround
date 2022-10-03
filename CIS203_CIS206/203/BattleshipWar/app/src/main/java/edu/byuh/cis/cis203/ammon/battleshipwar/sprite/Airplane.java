package edu.byuh.cis.cis203.ammon.battleshipwar.sprite;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;

import edu.byuh.cis.cis203.ammon.battleshipwar.R;

/**
 * Airplane uses the Enemy class to add functionality for the game purposes. The constructor will
 * use the randomly assigned bigness field to assign a specific image to the object. It will then
 * scale the image to the proper size for the screen it will be on.
 */
public class Airplane extends Enemy {
    private int planeSize;
    private final float screenHeight;
    private final float screenWidth;
    private final Resources res;

    public Airplane(Resources res, float screenWidth, float screenHeight) {
        super();
        planeSize = 0;
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
        this.res = res;
        changeBig();
        setVelocity((int)-(Math.random()*10)+1, 0);
        float y = setY();
        bounds = new RectF(screenWidth, y, planeSize, planeSize);
    }

    /**
     * The Move method calls the move method in the Sprite class and will then check if the sprite
     * is off the screen. There is an if statement that will give the method a new random speed 5% of
     * the time. If the sprite is off screen, it will be assigned a new size.
     */
    @Override
    public void move() {
        super.move();
        if (Math.random() < .05) {
            setVelocity((int)-(Math.random()*10)-1, 0);
        }
        if (bounds.left + planeSize < 0) {
            bigness = Size.getRandomSize();
            changeBig();
            bounds.offsetTo(screenWidth, setY());
        }
    }

    /**
     * setY will get a y value that is appropriate for the airplane class. It will keep the value
     * above the ship and below the top of the screen.
     *
     * @return a y value above the ship and below the top of the screen
     */
    private float setY() {
        float y = (float) (Math.random() * (screenHeight / 2)) - planeSize;
        if (y < 0) {
            y = 0;
        } else if (y + planeSize > (screenHeight / 2) + (screenHeight / 20)) {
            y += planeSize;
        }
        return y;
    }

    /**
     * This method is called with the constructor and whenever the size changes. The logic uses the
     * Size enum to determine the scale of the sprite to be drawn.
     */
    private void changeBig() {
        int imgFile = 0;
        switch (bigness) {
            case BIG:
                imgFile = R.drawable.big_airplane;
                planeSize = (int)(screenWidth * .12);
                break;
            case MED:
                imgFile = R.drawable.medium_airplane;
                planeSize = (int)(screenWidth * .08);
                break;
            case SML:
                imgFile = R.drawable.little_airplane;
                planeSize = (int)(screenWidth * .04);
                break;
        }
        img = BitmapFactory.decodeResource(res, imgFile);
        img = Bitmap.createScaledBitmap(img, planeSize, planeSize, true);
    }
}
