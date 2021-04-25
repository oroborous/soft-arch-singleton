package edu.wctc.players;

import edu.wctc.AbstractScrabbleLetterBag;
import edu.wctc.singletons.ScrabbleLetterBagClassic;
import edu.wctc.singletons.ScrabbleLetterBagEarly;
import edu.wctc.singletons.ScrabbleLetterBagEnum;
import edu.wctc.singletons.ScrabbleLetterBagSync;

public class ThreadedPlayer extends Thread {

    private String playerName;
    private int bagType;

    public ThreadedPlayer(String playerName, int bagType) {
        this.playerName = playerName;
        this.bagType = bagType;
    }

    public void drawTile() {
        start();
    }

    @Override
    public void run() {
        if (bagType == 4)
        {
            ScrabbleLetterBagEnum tileBag = ScrabbleLetterBagEnum.INSTANCE;
            String tile = tileBag.drawTile();
            System.out.printf("%s drew letter '%s' from Bag ID %d%n%d tiles remain in bag %d%n%n",
                    playerName, tile, tileBag.hashCode(),
                    tileBag.getTileCount(), tileBag.hashCode());
            return;
        }


        AbstractScrabbleLetterBag tileBag = null;

        if (bagType == 1)
            tileBag = ScrabbleLetterBagClassic.getInstance();
        else if (bagType == 2)
            tileBag = ScrabbleLetterBagSync.getInstance();
        else if (bagType == 3)
            tileBag = ScrabbleLetterBagEarly.getInstance();

        String tile = tileBag.drawTile();
        System.out.printf("%s drew letter '%s' from Bag ID %d%n%d tiles remain in bag %d%n%n",
                playerName, tile, tileBag.hashCode(),
                tileBag.getTileCount(), tileBag.hashCode());
    }
}
