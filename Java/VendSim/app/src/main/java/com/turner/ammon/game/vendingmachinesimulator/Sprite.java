package com.turner.ammon.game.vendingmachinesimulator;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;

public abstract class Sprite {

  protected Bitmap img;
  protected RectF bounds;

  public Sprite() {
    bounds = new RectF();
    img = null;
  }

  public void setPosition(int x, int y) {
    bounds.offsetTo(x, y);
  }

  public void draw(Canvas c) {
    c.drawBitmap(img, bounds.left, bounds.top, null);
  }
}
