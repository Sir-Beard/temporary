package com.shpp.p2p.cs.ohubanov.assignment3;

import acm.util.RandomGenerator;
import com.shpp.cs.a.console.TextProgram;

/**
 * Task: St. Petersburg paradox.
 * Usage: Two people play: LuckyMan and Sweaty.
 * The game ends when the first one earns >= 20$.
 * Sweaty puts 1$ on table, LuckyMan starts tossing a coin.
 * If eagle - sweaty adds to the amount on the table exactly the same amount.
 * If tail - everything on the table, goes to the lucky one. If the lucky winner is less than $ 20, the game repeates.
 */

public class Assignment3Part5 extends TextProgram {
    // Constant for maximum $ wining
    private static final int topMoney = 20;

    // Business logic here
    public void run() {
        // Local variables.
        // A Man, that is lucky, and wants to win some cash $.
        int luckyMan = 0;
        // Sweaty == table. :)
        int table = 1;
        // Counter for games played.
        int counter = 0;

        // When game will be finishd main method of game will return the counter of games played.
        counter = playGame(luckyMan, table, counter);

        // Final message when game is finished.
        finalMessage(counter);
    }

    /**
     * Main logic of game, counts how much money wins Lucky Man.
     * @param luckyMan - variable (aka Lucky Man), that receives money from table (aka Sweaty)
     * @param table - variable Sweaty, that puts money on table, while luckyMan has tails on coin.
     * @param counter - counter for games played.
     * @return - returns final played games.
     */
    private int playGame(int luckyMan, int table, int counter) {
        //While LuckyMan will not earned top of possible money (>= 20$ as in constant), method is in progress.
        while (luckyMan <= topMoney) {
            if (coinGenerator()) {
                table += table;
            } else {
                luckyMan += table;
                println("This game, you earned $" + table);
                println("Your total is $" + luckyMan);
                // Repeat game (dump the table). LuckyMan will safe all that he earned.
                table = 1;
                counter++;
            }
        }
        return counter;
    }

    // Coin Generator is a function, that flips an imaginary coin to either heads or tails (oryol and reshka)
    private boolean coinGenerator() {
        RandomGenerator coin = RandomGenerator.getInstance();
        return coin.nextBoolean();
    }

    /**
     * Prints final message, when game is over. Takes count parameter.
     * @param count - counter of games played.
     */
    private void finalMessage(int count) {
        println("It took " + count + " games to earn $20");
    }
}