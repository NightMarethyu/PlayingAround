package edu.byuh.cis.cis203.ammon.inclassprogramming;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class FunView extends View {

    private Paint coolors;
    private Bitmap gimp;

    public FunView(Context c) {
        super(c);
        coolors = new Paint();
        coolors.setColor(Color.GREEN);
        coolors.setTextSize(100);
        gimp = BitmapFactory.decodeResource(getResources(), R.drawable.duck);
    }

    @Override
    public void onDraw(Canvas c) {
        c.drawText("Don't Stop Believing", 100, 100, coolors);
        //c.drawBitmap(gimp, 100, 150, coolors);
        float w = getWidth();
        int duckWidth = (int) (w/3);
        gimp = Bitmap.createScaledBitmap(gimp, duckWidth, duckWidth, true);
        c.drawBitmap(gimp, 100, 150, coolors);
    }
}
