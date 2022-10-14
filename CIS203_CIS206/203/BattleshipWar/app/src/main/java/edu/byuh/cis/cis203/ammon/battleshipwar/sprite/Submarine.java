package edu.byuh.cis.cis203.ammon.battleshipwar.sprite;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;

import edu.byuh.cis.cis203.ammon.battleshipwar.R;

/**
 * Submarine uses the Enemy class to add functionality for the game purposes. The constructor will
 * use the randomly assigned bigness field to assign a specific image to the object. It will then
 * scale the image to the proper size for the screen it will be on.
 */
public class Submarine extends Enemy {
    private int subSize;
    private final float screenHeight;
    private final float screenWidth;
    private final Resources res;

    public Submarine(Resources res, float screenWidth, float screenHeight, Timer timer) {
        super();
        this.res = res;
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
        changeBig();
        setVelocity((int)(Math.random()*15)+10, 0);
        var x = -subSize;
        float y = setY();
        bounds = new RectF(x, y, subSize, subSize);
        timer.addListener(this);
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
            setVelocity((int)(Math.random()*15)+10, 0);
        }
        if (bounds.left > screenWidth) {
            bigness = Size.getRandomSize();
            changeBig();
            bounds.offsetTo(-subSize, setY());
        }
    }

    /**
     * setY will get a y value that is appropriate for the submarine class. It will keep the value
     * under the water and not colliding with the battleship sprite.
     *
     * @return a y value below the water and above the bottom of the screen
     */
    private float setY() {
        float y = (float) (Math.random() * screenHeight/2) + (screenHeight/2) + (screenHeight/15);
        if (y+subSize>screenHeight) {
            y = screenHeight - subSize;
        }
        return y;
    }

    /**
     * This method is called with the constructor and whenever the size changes. The logic uses the
     * Size enum to determine the scale of the sprite to be drawn.
     */
    private void changeBig() {
        int imgFile = 0;
        subSize = 0;
        switch (bigness) {
            case BIG:
                imgFile = R.drawable.big_submarine;
                subSize = (int)(screenWidth * .12);
                break;
            case MED:
                imgFile = R.drawable.medium_submarine;
                subSize = (int)(screenWidth * .07);
                break;
            case SML:
                imgFile = R.drawable.little_submarine;
                subSize = (int)(screenWidth * .05);
        }
        img = BitmapFactory.decodeResource(res, imgFile);
        img = Bitmap.createScaledBitmap(img, subSize, subSize, true);
    }
}
