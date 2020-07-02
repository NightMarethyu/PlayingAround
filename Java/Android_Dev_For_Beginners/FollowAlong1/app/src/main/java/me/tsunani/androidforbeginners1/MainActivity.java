package me.tsunani.androidforbeginners1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onBtnClick(View view) {
        EditText txtFirstName = findViewById(R.id.firstNameInput);
        TextView outFirstName = findViewById(R.id.firstNameTxt);
        outFirstName.setText("First Name: " + txtFirstName.getText().toString());
        EditText txtLastName = findViewById(R.id.lastNameInput);
        TextView outLastName = findViewById(R.id.lastNameTxt);
        outLastName.setText("Last Name: " + txtLastName.getText().toString());
        EditText txtEmail = findViewById(R.id.emailInput);
        TextView outEmail = findViewById(R.id.emailTxt);
        outEmail.setText("Email: " + txtEmail.getText().toString());
    }
}