package edu.wctc.singletons;

import edu.wctc.AbstractScrabbleLetterBag;

/**
 * Similar to the classic singleton, this version creates
 * its single instance before getInstance() is called.
 *
 * Static fields are initialized the first time the class
 * is loaded into memory. This may be too soon and result
 * in unnecessary delay if the scrabble letter bag isn't
 * actually needed yet.
 */
public class ScrabbleLetterBagEarly extends AbstractScrabbleLetterBag {

    private static ScrabbleLetterBagEarly instance = new ScrabbleLetterBagEarly();

    /**
     * This private constructor can only be called from inside
     * this class.
     */
    private ScrabbleLetterBagEarly() {
        System.out.println("Creating ScrabbleLetterBagEarly");

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

        System.out.printf("ScrabbleLetterBagEarly (%d) created with %d tiles%n%n",
                this.hashCode(), getTileCount());
    }

    public static ScrabbleLetterBagEarly getInstance() {
        return instance;
    }

}
