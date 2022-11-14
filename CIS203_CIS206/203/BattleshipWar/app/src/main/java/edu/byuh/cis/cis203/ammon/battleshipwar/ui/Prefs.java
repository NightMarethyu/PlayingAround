package edu.byuh.cis.cis203.ammon.battleshipwar.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.preference.ListPreference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;
import androidx.preference.PreferenceScreen;
import androidx.preference.SwitchPreference;

import edu.byuh.cis.cis203.ammon.battleshipwar.resources.Constants;

public class Prefs extends PreferenceFragmentCompat {
  @Override
  public void onCreatePreferences(Bundle b, String s) {
    Context context = getPreferenceManager().getContext();
    PreferenceScreen screen = getPreferenceManager().createPreferenceScreen(context);

    String[] nums = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    String[] speed = { "slow", "medium", "fast" };
    String[] speedVals = { "5", "10", "15" };

    // TODO Add preference widgets here
    // switch preferences with booleans
    // Turn sound effects off and on
    var soundPref = new SwitchPreference(context);
    soundPref.setTitle("Play Sound Effects?");
    soundPref.setSummaryOff("Sound effects will not play");
    soundPref.setSummaryOn("Sound effects will play");
    soundPref.setKey(Constants.PLAY_SOUNDS);

    // Turn music on and off
    var soundtrack = new SwitchPreference(context);
    soundtrack.setKey(Constants.PLAY_MUSIC);
    soundtrack.setTitle("Play Music");
    soundtrack.setSummaryOff("Soundtrack will not play");
    soundtrack.setSummaryOn("Soundtrack will play");

    // allow rapid fire missiles
    var rapidMissiles = new SwitchPreference(context);
    rapidMissiles.setKey(Constants.RAPID_FIRE_MISSILES);
    rapidMissiles.setTitle("Allow Rapid Fire Missiles");
    rapidMissiles.setSummaryOff("Only one missile at a time");
    rapidMissiles.setSummaryOn("Multi-fire enabled");

    // allow rapid fire depth charges
    var rapidCharges = new SwitchPreference(context);
    rapidCharges.setKey(Constants.RAPID_FIRE_CHARGES);
    rapidCharges.setTitle("Allow Rapid Fire Depth Charges");
    rapidCharges.setSummaryOff("Only one depth charge at a time");
    rapidCharges.setSummaryOn("Multi-fire enabled");

    // frugality mode
    var frugal = new SwitchPreference(context);
    frugal.setKey(Constants.FRUGALITY);
    frugal.setTitle("Frugality Mode");
    frugal.setSummaryOn("Points will be subtracted for each use of weapons");
    frugal.setSummaryOff("No change to score as weapons are fired");

    // List Preferences with multiple values
    // Number of planes allowed
    var planeCount = new ListPreference(context);
    planeCount.setKey(Constants.PLANE_COUNT);
    planeCount.setTitle("Plane Count");
    planeCount.setSummaryProvider(preference -> "Planes allowed on screen : " +
        PreferenceManager.getDefaultSharedPreferences(context).getString(Constants.PLANE_COUNT, "3"));
    planeCount.setEntries(nums);
    planeCount.setEntryValues(nums);

    // Number of subs allowed
    var subCount = new ListPreference(context);
    subCount.setKey(Constants.SUB_COUNT);
    subCount.setTitle("Submarine Count");
    subCount.setSummaryProvider(preference -> "Submarines allowed on screen : " +
        PreferenceManager.getDefaultSharedPreferences(context).getString(Constants.SUB_COUNT, "3"));
    subCount.setEntries(nums);
    subCount.setEntryValues(nums);

    // Plane Speed settings
    var planeSpeed = new ListPreference(context);
    planeSpeed.setKey(Constants.PLANE_SPEED);
    planeSpeed.setTitle("Plane Speed");
    planeSpeed.setSummaryProvider(preference -> {
      String val = "Average plane speed : ";
      String set = PreferenceManager.getDefaultSharedPreferences(context).getString(Constants.PLANE_SPEED, "medium");
      switch (set) {
        case "5":
          val = val + "Slow";
          break;
        case "15":
          val = val + "Fast";
          break;
        default:
          val = val + "Medium";
      }
      return val;
    });
    planeSpeed.setEntries(speed);
    planeSpeed.setEntryValues(speedVals);

    // Submarine Speed Settings
    var subSpeed = new ListPreference(context);
    subSpeed.setKey(Constants.SUB_SPEED);
    subSpeed.setTitle("Submarine Speed");
    subSpeed.setSummaryProvider(preference -> {
      String val = "Average submarine speed : ";
      String set = PreferenceManager.getDefaultSharedPreferences(context).getString(Constants.SUB_SPEED, "medium");
      switch (set) {
        case "5":
          val = val + "Slow";
          break;
        case "15":
          val = val + "Fast";
          break;
        default:
          val = val + "Medium";
      }
      return val;
    });
    subSpeed.setEntries(speed);
    subSpeed.setEntryValues(speedVals);

    // Plane direction
    var planeDirection = new ListPreference(context);
    planeDirection.setKey(Constants.PLANE_DIRECTION);
    planeDirection.setTitle("Plane Direction");
    planeDirection.setSummaryProvider(preference -> {
      String val = "Plane direction : ";
      String set = PreferenceManager.getDefaultSharedPreferences(context).getString(Constants.PLANE_DIRECTION, "both");
      return val + set;
    });
    planeDirection.setEntries(Constants.DIRECTIONS);
    planeDirection.setEntryValues(Constants.DIRECTIONS);

    // Sub direction
    var subDirection = new ListPreference(context);
    subDirection.setKey(Constants.SUB_DIRECTION);
    subDirection.setTitle("Submarine Direction");
    subDirection.setSummaryProvider(preference -> {
      String val = "Submarine direction : ";
      String set = PreferenceManager.getDefaultSharedPreferences(context).getString(Constants.SUB_DIRECTION, "both");
      return val + set;
    });
    subDirection.setEntries(Constants.DIRECTIONS);
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
