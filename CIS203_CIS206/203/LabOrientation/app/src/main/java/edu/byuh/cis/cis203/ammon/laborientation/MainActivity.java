package edu.byuh.cis.cis203.ammon.laborientation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView name = new TextView(this);
        name.setText("Ammon Turner");
        setContentView(name);
    }
}