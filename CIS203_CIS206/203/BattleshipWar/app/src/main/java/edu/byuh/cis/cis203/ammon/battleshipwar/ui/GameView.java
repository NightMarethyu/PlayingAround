package edu.byuh.cis.cis203.ammon.battleshipwar.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import edu.byuh.cis.cis203.ammon.battleshipwar.R;
import edu.byuh.cis.cis203.ammon.battleshipwar.resources.Constants;
import edu.byuh.cis.cis203.ammon.battleshipwar.sprite.Airplane;
import edu.byuh.cis.cis203.ammon.battleshipwar.sprite.Battleship;
import edu.byuh.cis.cis203.ammon.battleshipwar.sprite.DepthCharge;
import edu.byuh.cis.cis203.ammon.battleshipwar.sprite.Direction;
import edu.byuh.cis.cis203.ammon.battleshipwar.sprite.Missile;
import edu.byuh.cis.cis203.ammon.battleshipwar.sprite.Submarine;
import edu.byuh.cis.cis203.ammon.battleshipwar.sprite.TickListener;
import edu.byuh.cis.cis203.ammon.battleshipwar.sprite.Timer;

/**
 * GameView extends the Android View class to render the elements of the Battleship War clone made
 * as part of the BYUH Fall 2022 CIS 203 class.
 *
 * @author Ammon Turner
 * @version %I%, %G%
 * @since 0.1
 */
public class GameView extends View implements TickListener {

  private static GameView singleton;

  private final Paint paint;
  private Battleship ship;
  private final ArrayList<Airplane>  planes;
  private final ArrayList<Submarine> subs;
  private final ArrayList<DepthCharge> charges;
  private final ArrayList<Missile> missiles;
  private Bitmap water;
  private Bitmap fireMissile;
  private boolean initialized;
  private boolean gameOver;
  private Timer timer;
  private int score;
  private int timeLeft;
  private int timeCounter;
  private final int planeCount;
  private final int subCount;
  private MediaPlayer planeExplode;
  private MediaPlayer subExplode;
  private MediaPlayer missileLaunch;
  private MediaPlayer depthChargeBeep;
  private MediaPlayer depthCharge;

  /**
   * The Constructor of the GameView class.
   * This method calls the constructor of the <code>View</code> class, passing the <code>Context
   * </code> c parameter. Following the call to super, this will initialize the fields, putting
   * in the images used as sprites.
   *
   * @param c The Context the view is running in.
   * @see     Context
   * @since   0.1
   */
  private GameView(Context c) {
    super(c);
    paint = new Paint();
    paint.setStrokeWidth(10);
    water = BitmapFactory.decodeResource(getResources(), R.drawable.water);
    fireMissile = BitmapFactory.decodeResource(getResources(), R.drawable.star);
    paint.setColor(Color.WHITE);
    planes = new ArrayList<>();
    subs = new ArrayList<>();
    charges = new ArrayList<>();
    missiles = new ArrayList<>();
    timeCounter = 0;
    timeLeft = Constants.GAME_TIME;
    score = 0;
    createMediaPlayers();
    planeCount = Prefs.planeCount(c);
    subCount = Prefs.subCount(c);
    gameOver = false;
    initialized = false;
  }

  /**
   * The singleton constructor method, this method will return the single instance of this class that
   * should exist in the program.
   *
   * @param c   The context in which the class will be displayed
   * @return    The only instance of the GameView class
   */
  public static GameView getInstance(Context c) {
    if (singleton == null) {
      singleton = new GameView(c);
    }
    return singleton;
  }

  /**
   * This draws the sprites in the provided <code>Canvas</code>, implemented from
   * <code>android.view.View</code>.
   *
   * @param c The <code>Canvas</code> where the background is drawn
   * @see     Canvas
   * @since   0.1
   */
  @Override
  public void onDraw(Canvas c) {
    paint.setColor(Color.WHITE);
    c.drawPaint(paint);
    var screenWidth = getWidth();
    var screenHeight = getHeight();
    if (!initialized) {
      Context con = getContext();
      timer = new Timer();
      timer.addListener(this);
      water = Bitmap.createScaledBitmap(water, (screenWidth/20), (screenWidth/20), true);
      fireMissile = Bitmap.createScaledBitmap(fireMissile, (screenWidth/20), (screenWidth/20), true);
      var res = getResources();
      ship = new Battleship(res, screenWidth, screenHeight);
      for (int i=0; i<planeCount; i++) {
        planes.add(new Airplane(res, screenWidth, screenHeight, timer, Prefs.planeSpeed(con), Prefs.planeDirection(con)));
      }
      for (int i=0; i<subCount; i++) {
        subs.add(new Submarine(res, screenWidth, screenHeight, timer, Prefs.subSpeed(con), Prefs.subDirection(con)));
      }
      initialized = true;
    }
    drawWater(c, screenWidth, screenHeight);
    for (Submarine s : subs) {
      s.draw(c);
    }
    for (Airplane a : planes) {
      a.draw(c);
    }
    for (DepthCharge d : charges) {
      d.draw(c);
    }
    ship.draw(c);
    for (Missile m : missiles) {
      m.draw(c);
    }
    paint.setTextSize(screenHeight/20f);
    paint.setColor(Color.BLACK);
    float textPos = screenHeight/20f;
    String printScore = getResources().getString(R.string.score) + " " + score;
    int timeMinutes = timeLeft / 60;
    int timeSecs = timeLeft % 60;
    String timeText = getResources().getString(R.string.time);
    String timeLeft = timeText + " " + timeMinutes + ":" + String.format(Locale.ENGLISH, "%02d", timeSecs);
    c.drawText(printScore, 10, textPos + 5, paint);
    c.drawText(timeLeft, 10, 2 * textPos + 5, paint);
  }

  /**
   * onTouchEvent is called when the screen is touched, my implementation will check where the
   * screen was touched and fire a missile or depth charge depending on where on the screen the
   * touch was. The bottom half of the screen will fire a depth charge, the top half will do
   * missiles.
   *
   * @param m The MotionEvent that is passed to the default version of onTouchEvent
   * @return true if the event was handled, false otherwise
   */
  @Override
  public boolean onTouchEvent(MotionEvent m) {
    float x = m.getX();
    float y = m.getY();
    float height = getHeight();
    float width = getWidth();
    var c = getContext();

    if (m.getActionMasked() == MotionEvent.ACTION_DOWN || m.getActionMasked() == MotionEvent.ACTION_POINTER_DOWN) {
      if (y > (height/2)) {
        if (Prefs.multiCharges(c)) {
          launchCharge(width, height, c);
        } else if (charges.size() == 0) {
          launchCharge(width, height, c);
        }
      } else if (x > width/2) {
        if (Prefs.multiMissiles(c)) {
          launchMissile(Direction.RIGHT_FACING, width, height, c);
        } else if (missiles.size() == 0) {
          launchMissile(Direction.RIGHT_FACING, width, height, c);
        }
      } else {
        if (Prefs.multiMissiles(c)) {
          launchMissile(Direction.LEFT_FACING, width, height, c);
        } else if (missiles.size() == 0) {
          launchMissile(Direction.LEFT_FACING, width, height, c);
        }
      }
      if (gameOver) {
        int message;
        int hs = checkHighScore();
        if (hs < score) {
          message = R.string.congrats;
          try (var outStream = getContext().openFileOutput(Constants.HIGH_SCORE, Context.MODE_PRIVATE)) {
            outStream.write(Integer.parseInt(""+score));
          } catch (IOException e) {
            e.printStackTrace();
          }
        } else {
          message = R.string.game_end;
        }
        AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
        alert.setTitle(R.string.time_up)
            .setMessage(message)
            .setCancelable(false)
            .setPositiveButton(R.string.play_again, (d, i) -> newGame())
            .setNegativeButton(R.string.exit, (dialogInterface, i) -> ((Activity)getContext()).finish());
        AlertDialog show = alert.create();
        show.show();
      }
    }
    return true;
  }

  /**
   * Creates a new missile and adds it to the missiles array. Will then play sounds and adjust score
   * based on the settings the user put in preferences.
   *
   * @param d       The direction of the missile, based on where the user touched
   * @param width   The width of the screen
   * @param height  The height of the screen
   * @param c       The current context
   */
  private void launchMissile(Direction d, float width, float height, Context c) {
    missiles.add(new Missile(d, width, height, paint, fireMissile, timer));
    if (Prefs.soundFX(c)) {
      missileLaunch.start();
    }
    if (Prefs.frugality(c)) {
      score--;
    }
  }

  /**
   * Creates a new depth charge and adds it to the charges array. Will then play sounds and adjust score
   * based on the settings the user put in preferences.
   *
   * @param width   Width of the screen
   * @param height  Height of the screen
   * @param c       the current context
   */
  private void launchCharge(float width, float height, Context c) {
    charges.add(new DepthCharge(getResources(), width, height, timer));
    if (Prefs.soundFX(c)) {
      depthCharge.start();
    }
    if (Prefs.frugality(c)) {
      score--;
    }
  }

  /**
   * checkHighScore will read the highScore.txt file and return the integer of the highest recorded
   * score
   *
   * @return  Highest Score recorded in the highScore.txt file
   */
  private int checkHighScore() {
    try (var inStream = getContext().openFileInput(Constants.HIGH_SCORE)) {
      Scanner s = new Scanner(inStream);
      return s.nextInt();
    } catch (IOException e) {
      return 0; // New Install
    }
  }

  /**
   * This draws the water for the game.
   * drawWater performs the necessary calculations to draw the water in the correct location. It
   * will then do the drawing in a simple for loop to cover the screen in a straight line.
   *
   * @param c         The <code>Canvas</code> where the water will be drawn
   * @param width     The width of the screen, used for calculating the number of water sprites to draw
   * @param height    The height of the screen, used to calculate the position of the sprites
   * @see             Canvas
   * @since           0.1
   */
  private void drawWater(Canvas c, int width, int height) {
    var drawHeight = height/2;
    var waterWidth = water.getWidth();
    var waterToDraw = width/waterWidth;
    for(int i=0; i<waterToDraw; i++) {
      var curWater = waterWidth*i;
      c.drawBitmap(water, curWater, drawHeight, paint);
    }
  }

  // creates the media players for the different sounds
  private void createMediaPlayers() {
    planeExplode = MediaPlayer.create(getContext(), R.raw.plane_explosion);
    subExplode = MediaPlayer.create(getContext(), R.raw.sub_explosion);
    missileLaunch = MediaPlayer.create(getContext(), R.raw.missle_launch);
    depthChargeBeep = MediaPlayer.create(getContext(), R.raw.depth_charge_beep);
    depthCharge = MediaPlayer.create(getContext(), R.raw.depth_charge_drop);
  }

  /**
   * Sends pause command to timer class.
   */
  public void pause() {
    if (timer != null) {
      timer.pause();
    }
  }

  /**
   * Sends resume command to timer class.
   */
  public void resume() {
    if (timer != null) {
      timer.resume();
    }
  }

  /**
   * Called each game tick by the Timer. Calculates the time left in the game,
   * checks for collisions between player attacks and enemies, then redraws the screen.
   */
  @Override
  public void tick() {
    charges.removeIf(DepthCharge::getOutside);
    missiles.removeIf(Missile::getOutside);
    timeCounter++;
    if (timeCounter == (1000 / Constants.TICK_SPEED)) {
      timeLeft--;
      timeCounter = 0;
      if (Prefs.soundFX(getContext()) && charges.size() > 0) {
        depthChargeBeep.start();
      }
    }
    if (timeLeft == 0) {
      gameEnd();
    }
    detectCollisions();
    invalidate();
  }

  /**
   * gameEnd will remove all the tick listener from the Timer and will clear the array lists. This
   * will freeze everything on screen.
   */
  private void gameEnd() {
    gameOver = true;
    for (Airplane a : planes) {
      timer.removeListener(a);
    }
    planes.clear();
    for (Submarine s : subs) {
      timer.removeListener(s);
    }
    subs.clear();
    for (DepthCharge c : charges) {
      timer.removeListener(c);
    }
    charges.clear();
    for (Missile m : missiles) {
      timer.removeListener(m);
    }
    missiles.clear();
    timer.removeListener(this);
  }

  /**
   * newGame sets up the basics for a new game to start, it adds 'this' to the timer and repopulates
   * the planes and subs arraylists.
   */
  private void newGame() {
    gameOver = false;
    score = 0;
    var screenWidth = getWidth();
    var screenHeight = getHeight();
    var res = getResources();
    Context c = getContext();
    timer.addListener(this);
    for (int i=0; i<planeCount; i++) {
      planes.add(new Airplane(res, screenWidth, screenHeight, timer, Prefs.planeSpeed(c), Prefs.planeDirection(c)));
    }
    for (int i=0; i<subCount; i++) {
      subs.add(new Submarine(res, screenWidth, screenHeight, timer, Prefs.subSpeed(c), Prefs.subDirection(c)));
    }
    createMediaPlayers();
    timeLeft = Constants.GAME_TIME;
    timeCounter = 0;
    invalidate();
  }

  /**
   * Loops through the planes and subs and checks if there are any collisions between the attacks
   * the player triggered. Will remove missiles and depth charges on collision, sets the enemy's
   * explosion, and increments the player's score.
   */
  @SuppressLint("NewApi")
  private void detectCollisions() {
    for (Airplane a : planes) {
      missiles.removeIf((m) -> {
        if (m.overlaps(a)) {
          a.explode();
          return true;
        }
        return false;
      });
      if (a.getIsExploding()) {
        if (Prefs.soundFX(getContext())) {
          planeExplode.start();
        }
        score += a.getPointValue();
      }
    }
    for (Submarine s : subs) {
      charges.removeIf((c) -> {
        if (c.overlaps(s)) {
          s.explode();
          return true;
        }
        return false;
      });
      if (s.getIsExploding()) {
        if (Prefs.soundFX(getContext())) {
          subExplode.start();
        }
        score += s.getPointValue();
      }
    }
  }
}
