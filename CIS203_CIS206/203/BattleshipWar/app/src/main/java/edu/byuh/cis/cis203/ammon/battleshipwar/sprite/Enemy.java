package edu.byuh.cis.cis203.ammon.battleshipwar.sprite;

/**
 * Enemy is an extension of Sprite and adds functionality necessary for the enemies in the game.
 */
public abstract class Enemy extends Sprite {
    protected Size bigness;

    /**
     * The constructor of the Enemy class calls the default constructor and uses the Size.getRandomSize()
     * to randomize the size of the enemy.
     */
    public Enemy() {
        super();
        bigness = Size.getRandomSize();
    }
}
