package edu.byuh.cis.cis203.ammon.battleshipwar.sprite;

import android.os.Handler;
import android.os.Message;

import java.util.ArrayList;

import edu.byuh.cis.cis203.ammon.battleshipwar.constants.Constants;

/**
 * The Timer class will run a delayed loop to allow the sprites to be drawn. It notifies the sprites
 * that they are to draw themselves every 50 milliseconds.
 */
public class Timer extends Handler {
  protected ArrayList<TickListener> subscribed;

  /**
   * A new timer contains an empty arraylist of subscribers and will send a delayed message in 50
   * milliseconds.
   */
  public Timer() {
    subscribed = new ArrayList<>();
    sendMessageDelayed(obtainMessage(), Constants.TICK_SPEED);
  }

  /**
   * Adds a new subscriber to be notified with each tick.
   *
   * @param t     a tickListener to be notified
   */
  public void addListener(TickListener t) {
    subscribed.add(t);
  }

  /**
   * Removes a subscriber from the list.
   *
   * @param t     the tickListener to be removed
   */
  public void removeListener(TickListener t) {
    subscribed.remove(t);
  }

  /**
   * Handle message copies the arraylist of subscribers and iterates through it to notify the
   * listeners.
   *
   * @param m     a message required by the handler class
   */
  @Override
  public void handleMessage(Message m) {
    ArrayList<TickListener> tempList = new ArrayList<>(subscribed);
    for (TickListener t : tempList) {
      t.tick();
    }
    sendMessageDelayed(obtainMessage(), Constants.TICK_SPEED);
  }
}
