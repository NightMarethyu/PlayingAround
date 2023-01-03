package edu.byuh.cis.cis203.ammon.battleshipwar.resources;

public class Constants {

  // Scaling variables
  public static final float BIG_SCALE = .12f;
  public static final float MED_SCALE = .08f;
  public static final float SML_SCALE = .04f;

  // Scores for Submarines
  public static final int SML_SUB_SCORE = 150;
  public static final int MED_SUB_SCORE = 40;
  public static final int BIG_SUB_SCORE = 25;

  // Scores for Planes
  public static final int SML_PLANE_SCORE = 75;
  public static final int MED_PLANE_SCORE = 20;
  public static final int BIG_PLANE_SCORE = 15;

  // Percent random speed change
  public static final float MOVE_SPEED_CHANGE_CHANCE = .05f;

  // Base tick speed
  public static final int TICK_SPEED = 50;

  // Base Game Time
  public static final int GAME_TIME = 20;

  // High Score File Name
  public static final String HIGH_SCORE = "highScore.txt";

  // Preference Keys
  public static final String PLAY_SOUNDS = "PLAY_SOUNDS";
  public static final String PLAY_MUSIC = "PLAY_MUSIC";
  public static final String RAPID_FIRE_MISSILES = "RAPID_FIRE_MISSILES";
  public static final String RAPID_FIRE_CHARGES = "RAPID_FIRE_CHARGES";
  public static final String FRUGALITY = "FRUGALITY";
  public static final String PLANE_COUNT = "PLANE_COUNT";
  public static final String SUB_COUNT = "SUB_COUNT";
  public static final String PLANE_SPEED = "PLANE_SPEED";
  public static final String SUB_SPEED = "SUB_SPEED";
  public static final String PLANE_DIRECTION = "PLANE_DIRECTION";
  public static final String SUB_DIRECTION = "SUB_DIRECTION";

  // Direction Array
  public static final String[] DIRECTIONS = { "left-to-right", "right-to-left", "both"};

  }
