package edu.byuh.cis.cis203.ammon.battleshipwar.sprite;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import edu.byuh.cis.cis203.ammon.battleshipwar.R;

/**
 * Submarine uses the Enemy class to add functionality for the game purposes. The constructor will
 * use the randomly assigned bigness field to assign a specific image to the object. It will then
 * scale the image to the proper size for the screen it will be on.
 */
public class Submarine extends Enemy {

    public Submarine(Resources res, float screenWidth, float screenHeight, Timer timer) {
        super(res, screenWidth, screenHeight, timer);
    }

    /**
     * setY will get a y value that is appropriate for the submarine class. It will keep the value
     * under the water and not colliding with the battleship sprite.
     *
     * @return a y value below the water and above the bottom of the screen
     */
    @Override
    protected float setY() {
        float y = (float) (Math.random() * screenHeight/2) + (screenHeight/2) + (screenHeight/15);
        if (y+ scaleSize >screenHeight) {
            y = screenHeight - scaleSize;
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
        scaleSize = 0;
        switch (bigness) {
            case BIG:
                imgFile = (direction == Direction.RIGHT_FACING) ? R.drawable.big_submarine : R.drawable.big_submarine_flip;
                scaleSize = (int)(screenWidth * .12);
                break;
            case MED:
                imgFile = (direction == Direction.RIGHT_FACING) ? R.drawable.medium_submarine : R.drawable.medium_submarine_flip;
                scaleSize = (int)(screenWidth * .07);
                break;
            case SML:
                imgFile = (direction == Direction.RIGHT_FACING) ? R.drawable.little_submarine : R.drawable.little_submarine_flip;
                scaleSize = (int)(screenWidth * .05);
                break;
            default:
                imgFile = 0;
        }
        img = BitmapFactory.decodeResource(res, imgFile);
        img = Bitmap.createScaledBitmap(img, scaleSize, scaleSize, true);
    }
}
