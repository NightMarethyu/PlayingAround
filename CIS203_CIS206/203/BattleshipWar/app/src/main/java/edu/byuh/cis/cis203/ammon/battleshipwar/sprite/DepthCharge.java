package edu.byuh.cis.cis203.ammon.battleshipwar.sprite;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;

import edu.byuh.cis.cis203.ammon.battleshipwar.R;

public class DepthCharge extends Sprite {
    protected float height;
    protected Timer timer;

    /**
     * The DepthCharge class is used to draw the depth charges attacks in the game. The constructor
     * will scale the image based on the size of the screen
     *
     * @param res   The resources folder of the app
     * @param w     The width of the screen
     * @param h     The height of the screen
     */
    public DepthCharge(Resources res, float w, float h, Timer t) {
        super();
        int scale = (int)(w*.04);
        height = h;
        velocity.set(0, 10);
        img = BitmapFactory.decodeResource(res, R.drawable.depth_charge);
        img = Bitmap.createScaledBitmap(img, scale, scale, true);
        bounds = new RectF(0, 0, scale, scale);
        bounds.offsetTo((w/2)-(scale/2f), (h/2)-(scale/2f)+img.getHeight());
        timer = t;
        timer.addListener(this);
    }

    /**
     * isOutside checks if the depth charge is being rendered below the bottom of the screen.
     *
     * @return  true if the top of the bounding box is below the screen
     */
    public boolean isOutside() {
        return bounds.top > height;
    }

    @Override
    public void move() {
        super.move();
        if (bounds.top > height) {
            timer.removeListener(this);
        }
    }
}
