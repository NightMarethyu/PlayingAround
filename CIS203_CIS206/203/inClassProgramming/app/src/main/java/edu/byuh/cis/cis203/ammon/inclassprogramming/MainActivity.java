package edu.byuh.cis.cis203.ammon.inclassprogramming;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        var fv = new FunView(this);
        setContentView(fv);
    }
}