package edu.wctc.singletons;

import edu.wctc.AbstractScrabbleLetterBag;

/**
 * Implements a scrabble letter bag with the classic singleton
 * mechanism: a private constructor, a private static field,
 * and a public static getInstance() method
 */
public class ScrabbleLetterBagClassic extends AbstractScrabbleLetterBag {

    private static ScrabbleLetterBagClassic instance = null;

    /**
     * This private constructor can only be called from inside
     * this class.
     */
    private ScrabbleLetterBagClassic() {
        System.out.println("Creating ScrabbleLetterBagClassic");

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

        System.out.printf("ScrabbleLetterBagClassic (%d) created with %d tiles%n%n",
                this.hashCode(), getTileCount());
    }

    /**
     * If the static field is null, creates one instance
     * of this class. Returns the singleton instance.
     * @return
     */
    public static ScrabbleLetterBagClassic getInstance() {
        if (instance == null) {
            instance = new ScrabbleLetterBagClassic();
        }

        return instance;
    }
}
