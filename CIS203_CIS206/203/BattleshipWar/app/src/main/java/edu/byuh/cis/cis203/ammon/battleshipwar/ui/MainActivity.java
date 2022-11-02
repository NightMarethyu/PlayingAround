package edu.byuh.cis.cis203.ammon.battleshipwar.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        var gameDraw = new GameView(this);
        setContentView(gameDraw);
    }
}