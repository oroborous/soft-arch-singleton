package edu.wctc.singletons;

import edu.wctc.AbstractScrabbleLetterBag;

public class ScrabbleLetterBagSync extends AbstractScrabbleLetterBag {

    private static ScrabbleLetterBagSync instance = null;

    /**
     * This private constructor can only be called from inside
     * this class.
     */
    private ScrabbleLetterBagSync() {
        System.out.println("Creating ScrabbleLetterBagSync");

        fakeWaitTime();

        initTiles();

        System.out.printf("ScrabbleLetterBagSync (%d) created with %d tiles%n%n",
                this.hashCode(), getTileCount());
    }

    public static ScrabbleLetterBagSync getInstance() {
        // Double-checked locking
        if (instance == null) {
            synchronized (ScrabbleLetterBagSync.class) {
                if (instance == null) {
                    instance = new ScrabbleLetterBagSync();
                }
            }
        }

        return instance;
    }
}
