package com.shpp.p2p.cs.ohubanov.assignment5;

import com.shpp.cs.a.console.TextProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Task: Game on the road
 * Usage: Program that asks user for a string of three letters, then display the words that can be composed of these letters.
 * The program is looped, at each iteration asks user to enter new 3 letters and processes them (thus letters can be any case).
 */

public class Assignment5Part3 extends TextProgram {
    public void run() {
        while (true) {
            String letters = readLine("Enter three letters: ");
            // If there are three symbols, go to methods that will work with them, if not - re-ask user.
            if (letters.length() == 3) {
                println(words(letters));
            } else {
                println("Please, enter 3 letters!");
            }
        }
    }

    /**
     * Method that writes into String all words that it finds, with lower cases register.
     * @param letters - three symbols that user entered.
     * @return - string, that is full of result words.
     */
    private String words(String letters) {
        String word = readFileAndReturnWords(letters.toLowerCase());
        return word;
    }

    /**
     * Reading file, get line by line from it and work with each of lines.
     * @param letters - three symbols that user entered.
     * @return - string, that is full of result words.
     */
    private String readFileAndReturnWords(String letters) {
        // Result string with words in it.
        String res = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader("assets/en-dictionary.txt"));
            // Line string from file.
            String lineFromFile;
            // While there is something to read in file, do editing.
            while ((lineFromFile = br.readLine()) != null) {
                // If there is matches in line with letters, write the word into result.
                if (checkForMatches(lineFromFile, letters)) {
                    res += lineFromFile + "\n";
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    }

    /**
     * Algorithm that check for matches with words and letters.
     * @param lineFromFile - word from file.
     * @param letters - three symbols that user entered.
     * @return - true, if match found. false if not.
     */
    private boolean checkForMatches(String lineFromFile, String letters) {
        // Temporary variable for counting the found letters.
        int count = 0;
        // Var char for letters, that user entered.
        char ch = ' ';

        for (int i = 0; i < lineFromFile.length(); i++) {
            // write first letter into char.
            if (count == 0) ch = letters.charAt(0);
            // If first letter found, write another into char.
            if (count == 1) ch = letters.charAt(1);
            if (count == 2) ch = letters.charAt(2);

            //If found match, increment the counter.
            if (lineFromFile.charAt(i) == ch) {
                count++;
            }

            //When all three letters are found, return true.
            if (count == 3) return true;
        }
        return false;
    }
}
