package edu.byuh.cis.cis203.ammon.battleshipwar.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.preference.ListPreference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;
import androidx.preference.PreferenceScreen;
import androidx.preference.SwitchPreference;

import edu.byuh.cis.cis203.ammon.battleshipwar.R;
import edu.byuh.cis.cis203.ammon.battleshipwar.resources.Constants;

public class Prefs extends PreferenceFragmentCompat {
  @Override
  public void onCreatePreferences(Bundle b, String s) {
    Context context = getPreferenceManager().getContext();
    PreferenceScreen screen = getPreferenceManager().createPreferenceScreen(context);

    String[] nums = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    String[] speedVals = { "5", "10", "15" };

    // switch preferences with booleans
    // Turn sound effects off and on
    var soundPref = new SwitchPreference(context);
    soundPref.setTitle(R.string.play_sound);
    soundPref.setSummaryOff(R.string.sound_will_not_play);
    soundPref.setSummaryOn(R.string.sound_will_play);
    soundPref.setKey(Constants.PLAY_SOUNDS);

    // Turn music on and off
    var soundtrack = new SwitchPreference(context);
    soundtrack.setKey(Constants.PLAY_MUSIC);
    soundtrack.setTitle(R.string.play_music);
    soundtrack.setSummaryOff(R.string.music_will_not_play);
    soundtrack.setSummaryOn(R.string.music_will_play);

    // allow rapid fire missiles
    var rapidMissiles = new SwitchPreference(context);
    rapidMissiles.setKey(Constants.RAPID_FIRE_MISSILES);
    rapidMissiles.setTitle(R.string.rapid_missiles);
    rapidMissiles.setSummaryOff(R.string.rapid_missiles_off);
    rapidMissiles.setSummaryOn(R.string.rapid_missiles_on);

    // allow rapid fire depth charges
    var rapidCharges = new SwitchPreference(context);
    rapidCharges.setKey(Constants.RAPID_FIRE_CHARGES);
    rapidCharges.setTitle(R.string.rapid_charges);
    rapidCharges.setSummaryOff(R.string.rapid_charges_off);
    rapidCharges.setSummaryOn(R.string.rapid_charges_on);

    // frugality mode
    var frugal = new SwitchPreference(context);
    frugal.setKey(Constants.FRUGALITY);
    frugal.setTitle(R.string.frugal_mode);
    frugal.setSummaryOn(R.string.frugal_mode_on);
    frugal.setSummaryOff(R.string.frugal_mode_off);

    // List Preferences with multiple values
    // Number of planes allowed
    var planeCount = new ListPreference(context);
    planeCount.setKey(Constants.PLANE_COUNT);
    planeCount.setTitle(R.string.plane_count);
    planeCount.setSummaryProvider(preference -> getResources().getString(R.string.plane_count_sum) + " " +
        PreferenceManager.getDefaultSharedPreferences(context).getString(Constants.PLANE_COUNT, "3"));
    planeCount.setEntries(nums);
    planeCount.setEntryValues(nums);

    // Number of subs allowed
    var subCount = new ListPreference(context);
    subCount.setKey(Constants.SUB_COUNT);
    subCount.setTitle(R.string.sub_count);
    subCount.setSummaryProvider(preference -> getResources().getString(R.string.sub_count_sum) + " " +
        PreferenceManager.getDefaultSharedPreferences(context).getString(Constants.SUB_COUNT, "3"));
    subCount.setEntries(nums);
    subCount.setEntryValues(nums);

    // Plane Speed settings
    var planeSpeed = new ListPreference(context);
    planeSpeed.setKey(Constants.PLANE_SPEED);
    planeSpeed.setTitle(R.string.plane_speed);
    planeSpeed.setSummaryProvider(preference -> {
      String val = getResources().getString(R.string.plane_speed_sum) + " ";
      String set = PreferenceManager.getDefaultSharedPreferences(context).getString(Constants.PLANE_SPEED, "medium");
      switch (set) {
        case "5":
          val = val + getResources().getString(R.string.slow);
          break;
        case "15":
          val = val + getResources().getString(R.string.fast);
          break;
        default:
          val = val + getResources().getString(R.string.medium);
      }
      return val;
    });
    planeSpeed.setEntries(R.array.speed_labels);
    planeSpeed.setEntryValues(speedVals);

    // Submarine Speed Settings
    var subSpeed = new ListPreference(context);
    subSpeed.setKey(Constants.SUB_SPEED);
    subSpeed.setTitle(R.string.sub_speed);
    subSpeed.setSummaryProvider(preference -> {
      String val = getResources().getString(R.string.sub_speed_sum)+" ";
      String set = PreferenceManager.getDefaultSharedPreferences(context).getString(Constants.SUB_SPEED, "medium");
      switch (set) {
        case "5":
          val = val + getResources().getString(R.string.slow);
          break;
        case "15":
          val = val + getResources().getString(R.string.fast);
          break;
        default:
          val = val + getResources().getString(R.string.medium);
      }
      return val;
    });
    subSpeed.setEntries(R.array.speed_labels);
    subSpeed.setEntryValues(speedVals);

    // Plane direction
    var planeDirection = new ListPreference(context);
    planeDirection.setKey(Constants.PLANE_DIRECTION);
    planeDirection.setTitle(R.string.plane_dir);
    planeDirection.setSummaryProvider(preference -> {
      String val = getResources().getString(R.string.plane_dir_sum) + " ";
      String set = PreferenceManager.getDefaultSharedPreferences(context).getString(Constants.PLANE_DIRECTION, "both");
      String setText;
      switch (set) {
        case "left-to-right" :
          setText = getResources().getString(R.string.l2r);
          break;
        case "right-to-left" :
          setText = getResources().getString(R.string.r2l);
          break;
        default:
          setText = getResources().getString(R.string.r_and_l);
      }
      return val + setText;
    });
    planeDirection.setEntries(R.array.dir_labels);
    planeDirection.setEntryValues(Constants.DIRECTIONS);

    // Sub direction
    var subDirection = new ListPreference(context);
    subDirection.setKey(Constants.SUB_DIRECTION);
    subDirection.setTitle(R.string.sub_dir);
    subDirection.setSummaryProvider(preference -> {
      String val = getResources().getString(R.string.sub_dir_sum) + " ";
      String set = PreferenceManager.getDefaultSharedPreferences(context).getString(Constants.SUB_DIRECTION, "both");
      String setText;
      switch (set) {
        case "left-to-right" :
          setText = getResources().getString(R.string.l2r);
          break;
        case "right-to-left" :
          setText = getResources().getString(R.string.r2l);
          break;
        default:
          setText = getResources().getString(R.string.r_and_l);
      }
      return val + setText;
    });
    subDirection.setEntries(R.array.dir_labels);
    subDirection.setEntryValues(Constants.DIRECTIONS);

    // Add the preference selections to the screen
    screen.addPreference(soundPref);
    screen.addPreference(soundtrack);
    screen.addPreference(rapidMissiles);
    screen.addPreference(rapidCharges);
    screen.addPreference(frugal);
    screen.addPreference(planeCount);
    screen.addPreference(subCount);
    screen.addPreference(planeSpeed);
    screen.addPreference(subSpeed);
    screen.addPreference(planeDirection);
    screen.addPreference(subDirection);

    setPreferenceScreen(screen);
  }

  /**
   * Facade to access the soundFX setting in preferences
   * @param c   The current context
   * @return    a boolean of whether sounds should play or not
   */
  public static boolean soundFX(Context c) {
    return PreferenceManager.getDefaultSharedPreferences(c).getBoolean(Constants.PLAY_SOUNDS, true);
  }

  /**
   * Facade to access the soundtrack setting in preferences.
   * @param c   The current context
   * @return    a boolean of whether the soundtrack should play
   */
  public static boolean soundtrack(Context c) {
    return PreferenceManager.getDefaultSharedPreferences(c).getBoolean(Constants.PLAY_MUSIC, true);
  }

  /**
   * Facade to access the rapid fire missiles setting in preferences
   * @param c   The current context
   * @return    a boolean of whether rapid fire missiles is allowed
   */
  public static boolean multiMissiles(Context c) {
    return PreferenceManager.getDefaultSharedPreferences(c).getBoolean(Constants.RAPID_FIRE_MISSILES, true);
  }

  /**
   * Facade to access the rapid fire depth charges setting in preferences
   * @param c   The current context
   * @return    a boolean of whether rapid fire depth charges is allowed
   */
  public static boolean multiCharges(Context c) {
    return PreferenceManager.getDefaultSharedPreferences(c).getBoolean(Constants.RAPID_FIRE_CHARGES, true);
  }

  /**
   * Facade to access the frugality setting in preferences
   * @param c   The current context
   * @return    a boolean of whether a point should be removed for each missile/depth charge
   */
  public static boolean frugality(Context c) {
    return PreferenceManager.getDefaultSharedPreferences(c).getBoolean(Constants.FRUGALITY, false);
  }

  /**
   * Facade to access the number of plane enemies set in preferences
   * @param c   the current context
   * @return    the number of enemy planes to create
   */
  public static int planeCount(Context c) {
    String temp = PreferenceManager.getDefaultSharedPreferences(c).getString(Constants.PLANE_COUNT, "3");
    return Integer.parseInt(temp);
  }

  /**
   * Facade to access the number of sub enemies set in preferences
   * @param c   the current context
   * @return    the number of enemy submarines to create
   */
  public static int subCount(Context c) {
    String temp = PreferenceManager.getDefaultSharedPreferences(c).getString(Constants.SUB_COUNT, "3");
    return Integer.parseInt(temp);
  }

  /**
   * Facade to access the speed of the planes set in preferences
   * @param c   the current context
   * @return    the average speed that the planes will travel
   */
  public static int planeSpeed(Context c) {
    String temp = PreferenceManager.getDefaultSharedPreferences(c).getString(Constants.PLANE_SPEED, "10");
    return Integer.parseInt(temp);
  }

  /**
   * Facade to access the speed of the submarines set in preferences
   * @param c   the current context
   * @return    the average speed that the subs will travel
   */
  public static int subSpeed(Context c) {
    String temp = PreferenceManager.getDefaultSharedPreferences(c).getString(Constants.SUB_SPEED, "10");
    return Integer.parseInt(temp);
  }

  /**
   * Facade to access the direction setting for the planes set in preferences
   * @param c   the current context
   * @return    what direction the planes are limited to travel
   */
  public static String planeDirection(Context c) {
    return PreferenceManager.getDefaultSharedPreferences(c).getString(Constants.PLANE_DIRECTION, "both");
  }

  /**
   * Facade to access the direction setting for the submarines set in preferences
   * @param c   the current context
   * @return    what direction the subs are limited to travel
   */
  public static String subDirection(Context c) {
    return PreferenceManager.getDefaultSharedPreferences(c).getString(Constants.SUB_DIRECTION, "both");
  }
}
