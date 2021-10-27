package com.shpp.p2p.cs.ohubanov.assignment5;

import com.shpp.cs.a.console.TextProgram;

/**
 * Task: counting the number of vowels.
 * write method: private int syllablesInWord (String word)
 * … Which takes the "word" parameter and returns the number of syllables in it.
 */

public class Assignment5Part1 extends TextProgram {
    public void run() {
        while (true) {
            String word = readLine("Enter a single word: ");
            println("   Syllable count: " + syllablesIn(word));
        }
    }

    /**
     * Algorithm finding of vowels in String
     * @param word - string that user input in console.
     * @return - vowels integer counting.
     */
    private int syllablesIn(String word) {
        // String to lower case for a simplified algorithm.
        word = word.toLowerCase();
        int vowelCount = 0;
        // write the number of characters in String to operate with them in a loop.
        int letterCount = word.length();

        // If word had last char 'e', don't count it.
        if (word.endsWith("e")) {
            letterCount--;
        } else {
            // concatenate a "space" char into a string for better algorithm work
            word = word + " ";
        }
        // Loop for String, looking for vowels and count them.
        // Iterate over each character of the string.
        for (int i = 0; i < letterCount; i++) {
            // If finds, while subsequent characters = vowels: go to next char.
            if (isVowel(word.charAt(i))) {
                while (isVowel(word.charAt(i)) && i < letterCount){
                    i++;
                }
                vowelCount++;
            }
        }

        // Edge case if String has only one char of vowel.
        if (vowelCount == 0) vowelCount++;

        return vowelCount;
    }

    /**
     * Simple method that is check if there is a char of vowels.
     * @param vowel - char of vowels.
     * @return - returning true, if finds.
     */
    private boolean isVowel(char vowel) {
        return vowel == 'a' || vowel == 'e' || vowel == 'i' || vowel == 'o' || vowel == 'u' || vowel == 'y';
    }
}
