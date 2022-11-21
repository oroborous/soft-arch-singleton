package edu.wctc.singletons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Enums can't extend other classes because they
 * all inherit from the abstract class java.lang.Enum.
 */
public enum ScrabbleLetterBagEnum {
    INSTANCE;

    private List<String> tiles;

    /**
     * Enum constructors are inherently private.
     */
    ScrabbleLetterBagEnum() {
        System.out.println("Creating ScrabbleLetterBagEnum");

        fakeWaitTime();

        initTiles();

        System.out.printf("ScrabbleLetterBagEnum (%d) created with %d tiles%n%n",
                this.hashCode(), tiles.size());
    }

    private void fakeWaitTime() {
        try {
            // Simulate a long-running constructor, maybe a network or database call?
            for (int i = 0; i < 5; i++) {
                System.out.print(". ");
                Thread.sleep(500);
            }
            System.out.println();
        } catch (InterruptedException ex) {
        }
    }

    private void initTiles() {
        String[] scrabbleLetters = {"a", "a", "a", "a", "a", "a", "a", "a", "a",
                "b", "b", "c", "c", "d", "d", "d", "d", "e", "e", "e", "e", "e",
                "e", "e", "e", "e", "e", "e", "e", "f", "f", "g", "g", "g", "h",
                "h", "i", "i", "i", "i", "i", "i", "i", "i", "i", "j", "k", "l",
                "l", "l", "l", "m", "m", "n", "n", "n", "n", "n", "n", "o", "o",
                "o", "o", "o", "o", "o", "o", "p", "p", "q", "r", "r", "r", "r",
                "r", "r", "s", "s", "s", "s", "t", "t", "t", "t", "t", "t", "u",
                "u", "u", "u", "v", "v", "w", "w", "x", "y", "y", "z"};

        tiles = new ArrayList<>(Arrays.asList(scrabbleLetters));

        Collections.shuffle(tiles);
    }

    public String drawTile() {
        return tiles.remove(0);
    }

    public int getTileCount() {
        return tiles.size();
    }
}
