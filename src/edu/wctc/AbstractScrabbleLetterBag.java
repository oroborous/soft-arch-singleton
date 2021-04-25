package edu.wctc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class AbstractScrabbleLetterBag {

    private List<String> tiles;

    public String drawTile() {
        return tiles.remove(0);
    }

    protected void initTiles() {
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

    public int getTileCount() {
        return tiles.size();
    }
}
