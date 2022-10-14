package edu.byuh.cis.cis203.ammon.battleshipwar.sprite;

import android.os.Handler;
import android.os.Message;

import java.util.ArrayList;

public class Timer extends Handler {
    protected ArrayList<TickListener> subscribed;

    public Timer() {
        subscribed = new ArrayList<>();
        sendMessageDelayed(obtainMessage(), 50);
    }

    public void addListener(TickListener t) {
        subscribed.add(t);
    }

    public void removeListener(TickListener t) {
        subscribed.remove(t);
    }

    @Override
    public void handleMessage(Message m) {
        //ArrayList<TickListener> safe = new ArrayList<>();
        for (int i=0; i<subscribed.size(); i++) {
            subscribed.get(i).tick();
        }
        sendMessageDelayed(obtainMessage(), 50);
    }
}
