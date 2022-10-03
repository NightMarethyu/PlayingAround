package edu.byuh.cis.cis203.ammon.battleshipwar.sprite;

import java.util.Random;

/**
 * Size is used to know which picture to render and how big to display it on screen.
 */
public enum Size {
    BIG,
    MED,
    SML;

    /**
     * getRandomSize will select a size from the listed sizes using a random integer from the Random class
     * @return a Size enum, randomized with Random.nextInt
     */
    public static Size getRandomSize() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
