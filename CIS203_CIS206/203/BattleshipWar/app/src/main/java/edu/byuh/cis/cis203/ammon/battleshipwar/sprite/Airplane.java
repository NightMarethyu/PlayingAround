package edu.byuh.cis.cis203.ammon.battleshipwar.sprite;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import edu.byuh.cis.cis203.ammon.battleshipwar.R;

/**
 * Airplane uses the Enemy class to add functionality for the game purposes. The constructor will
 * use the randomly assigned bigness field to assign a specific image to the object. It will then
 * scale the image to the proper size for the screen it will be on.
 */
public class Airplane extends Enemy {

    public Airplane(Resources res, float screenWidth, float screenHeight, Timer timer) {
        super(res, screenWidth, screenHeight, timer);
    }

    /**
     * setY will get a y value that is appropriate for the airplane class. It will keep the value
     * above the ship and below the top of the screen.
     *
     * @return a y value above the ship and below the top of the screen
     */
    @Override
    protected float setY() {
        float y = (float) (Math.random() * (screenHeight / 2)) - scaleSize;
        if (y < 0) {
            y = 0;
        } else if (y + scaleSize > (screenHeight / 2) + (screenHeight / 20)) {
            y += scaleSize;
        }
        return y;
    }

    /**
     * This method is called with the constructor and whenever the size changes. The logic uses the
     * Size enum to determine the scale of the sprite to be drawn.
     */
    @Override
    protected void changeBig() {
        bigness = Size.getRandomSize();
        int imgFile;
        switch (bigness) {
            case BIG:
                imgFile = R.drawable.big_airplane;
                scaleSize = (int)(screenWidth * .12);
                break;
            case MED:
                imgFile = (direction == Direction.LEFT_FACING) ? R.drawable.medium_airplane:R.drawable.medium_airplane_flip;
                scaleSize = (int)(screenWidth * .08);
                break;
            case SML:
                imgFile = (direction == Direction.LEFT_FACING) ? R.drawable.little_airplane:R.drawable.little_airplane_flip;
                scaleSize = (int)(screenWidth * .04);
                break;
            default:
                imgFile = 0;
        }
        img = BitmapFactory.decodeResource(res, imgFile);
        img = Bitmap.createScaledBitmap(img, scaleSize, scaleSize, true);
    }
}
