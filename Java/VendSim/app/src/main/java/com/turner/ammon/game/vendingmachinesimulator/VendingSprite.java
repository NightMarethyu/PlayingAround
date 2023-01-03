package com.turner.ammon.game.vendingmachinesimulator;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;

public class VendingSprite extends Sprite {
  public VendingSprite(Resources res, float screenWidth, float screenHeight) {
    super();
    img = BitmapFactory.decodeResource(res, R.drawable.vend1);
    img = Bitmap.createScaledBitmap(img, (int)screenWidth, (int)screenHeight, true);
    bounds = new RectF(0, 0, screenWidth, screenHeight);
  }
}
