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

        try {
            // Simulate a long-running constructor, maybe a network or database call?
            for (int i = 0; i < 5; i++) {
                System.out.print(". ");
                Thread.sleep(500);
            }
            System.out.println();
        } catch (InterruptedException ex) {
        }

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
