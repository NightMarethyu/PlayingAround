package edu.byuh.cis.cis203.ammon.battleshipwar.sprite;

import java.util.Random;

/**
 * Direction is used for directing the missiles.
 */
public enum Direction {
    RIGHT_FACING,
    LEFT_FACING;

    /**
     * getRandomDirection will select a random direction from the directions in this enum.
     *
     * @return a direction selected randomly using Random.nextInt
     */
    public static Direction getRandomDirection() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
