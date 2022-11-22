package edu.byuh.cis.cis203.ammon.battleshipwar.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;

import edu.byuh.cis.cis203.ammon.battleshipwar.R;

public class MainActivity extends AppCompatActivity {

  private MediaPlayer soundtrack;
  private GameView gameDraw;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    soundtrack = MediaPlayer.create(this, R.raw.bw_soundtrack);
    soundtrack.setLooping(true);
    gameDraw = new GameView(this);
    setContentView(gameDraw);
  }

  @Override
  protected void onResume() {
    super.onResume();
    gameDraw.resume();
    if (Prefs.soundtrack(this)) {
      soundtrack.start();
    }
  }

  @Override
  protected void onPause() {
    super.onPause();
    gameDraw.pause();
    if (Prefs.soundtrack(this)) {
      soundtrack.pause();
    }
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    soundtrack.release();
  }
}