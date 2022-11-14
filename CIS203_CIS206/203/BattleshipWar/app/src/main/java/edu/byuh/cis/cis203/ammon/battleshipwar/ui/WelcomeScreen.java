package edu.byuh.cis.cis203.ammon.battleshipwar.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;

import edu.byuh.cis.cis203.ammon.battleshipwar.R;
import edu.byuh.cis.cis203.ammon.battleshipwar.resources.Constants;

public class WelcomeScreen extends Activity {

  private ImageView iv;

  @Override
  protected void onCreate(Bundle b) {
    super.onCreate(b);
    iv = new ImageView(this);
    iv.setImageResource(R.drawable.splash);
    iv.setScaleType(ImageView.ScaleType.FIT_XY);
    setContentView(iv);
  }

  @Override
  public boolean onTouchEvent(MotionEvent m) {
    var w = iv.getWidth();
    var h = iv.getHeight();
    var third = w / 3;
    if (m.getAction() == MotionEvent.ACTION_DOWN) {
      var x = m.getX();
      var y = m.getY();
      if (x < third && y < third) {
        Intent intent = new Intent(this, PrefsActivity.class);
        startActivity(intent);
      } else if (x < third && y > (h - third)) {
        AlertDialog.Builder about = new AlertDialog.Builder(this);
        about.setTitle("About Battleship War")
            .setMessage(Constants.ABOUT_GAME)
            .setCancelable(false)
            .setNeutralButton("OK", null);//(d, i) -> Toast.makeText(this,"Enjoy", Toast.LENGTH_SHORT).show());
        AlertDialog displayAbout = about.create();
        displayAbout.show();
      } else {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
      }
    }
    return true;
  }

}
