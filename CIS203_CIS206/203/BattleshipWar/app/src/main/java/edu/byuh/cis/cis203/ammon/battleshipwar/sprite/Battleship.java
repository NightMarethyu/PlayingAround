package edu.byuh.cis.cis203.ammon.battleshipwar.sprite;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;

import edu.byuh.cis.cis203.ammon.battleshipwar.R;

/**
 * Battleship adds some amount of use to the Sprite class. It assigns the img field to a bitmap in
 * the res/drawable folder, then scales the image to the proper size. It will then place the image
 * in the center of the screen.
 */
public class Battleship extends Sprite {

  public Battleship(Resources res, float screenWidth, float screenHeight) {
    super();
    velocity.set(0, 0);
    var shipSize = (int)(screenWidth * .4);
    img = BitmapFactory.decodeResource(res, R.drawable.battleship);
    img = Bitmap.createScaledBitmap(img, shipSize, shipSize, true);
    bounds = new RectF(0, 0, shipSize, shipSize);
    bounds.offsetTo((screenWidth/2)-(shipSize/2), (screenHeight/2)-(shipSize/2));
  }
}
