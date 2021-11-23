package edu.wctc;

import edu.wctc.players.ScrabblePlayer;
import edu.wctc.players.ThreadedPlayer;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to Scrabble!");

        Scanner keyboard = new Scanner(System.in);
        int bagChoice = getBagType(keyboard);

        int playerChoice = getPlayerType(keyboard);

        if (playerChoice == 1)
            nonThreadedPlayers(bagChoice);
        else
            threadedPlayers(bagChoice);
    }

    private static int getPlayerType(Scanner keyboard) {
        System.out.println("1. Non-threaded Players");
        System.out.println("2. Threaded Players");
        System.out.print(">> ");

        return Integer.parseInt(keyboard.nextLine());
    }

    private static int getBagType(Scanner keyboard) {
        System.out.println("1. Classic (Lazy, Non-Thread-Safe)");
        System.out.println("2. Synchronized (Lazy, Thread-Safe)");
        System.out.println("3. Early, Thread-Safe");
        System.out.println("4. Enum");
        System.out.print(">> ");

        return Integer.parseInt(keyboard.nextLine());
    }

    public static void nonThreadedPlayers(int bagType) {
        System.out.println("Creating non-threaded players\n");
        ScrabblePlayer player1 = new ScrabblePlayer("Charlie");
        ScrabblePlayer player2 = new ScrabblePlayer("Jayne");

        System.out.println("Non-threaded players drawing tiles\n");
        player1.drawTile(bagType);
        System.out.println();
        player2.drawTile(bagType);
    }

    public static void threadedPlayers(int bagType) {
        System.out.println("Creating threaded players\n");
        ThreadedPlayer player3 = new ThreadedPlayer("Stacy", bagType);
        ThreadedPlayer player4 = new ThreadedPlayer("Gigi", bagType);

        System.out.println("Threaded players drawing tiles\n");
        player3.drawTile();
        System.out.println();
        player4.drawTile();
    }
}
