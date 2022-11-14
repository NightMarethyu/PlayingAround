package edu.byuh.cis.cis203.ammon.battleshipwar.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import edu.byuh.cis.cis203.ammon.battleshipwar.R;

public class PrefsActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle b) {
    super.onCreate(b);
    setContentView(R.layout.settings_activity);
    FragmentManager fm = getSupportFragmentManager();
    FragmentTransaction ft = fm.beginTransaction();
    ft.replace(R.id.settings, new Prefs());
    ft.commit();
  }

}
