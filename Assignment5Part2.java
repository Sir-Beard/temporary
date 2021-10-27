package com.shpp.p2p.cs.ohubanov.assignment5;

import com.shpp.cs.a.console.TextProgram;

/**
 * Task: Addition Algorithm
 * Usage: program takes 2 values of type String and returns a value of type String, which is the sum of the accepted numbers.
 */

public class Assignment5Part2 extends TextProgram {
    public void run() {
        while (true) {
            String n1 = readLine("Enter first number: ");
            String n2 = readLine("Enter second number: ");
            println(n1 + " + " + n2 + " = " + addNumericStrings(n1, n2));
            println();
        }
    }

    /**
     * Method sums two Numeric Strings and return result of them
     * @param n1 - first number that user entered.
     * @param n2 - second number that user entered.
     * @return - result of two numeric strings
     */
    private String addNumericStrings(String n1, String n2) {
        // Ifs to modified Strings if they are not similar lengths.
        if (n1.length() > n2.length()) {
            StringBuilder n2Builder = new StringBuilder(n2);
            while (n2Builder.length() != n1.length()) {
                n2Builder.insert(0, "0");
            }
            n2 = n2Builder.toString();
        }
        if (n1.length() < n2.length()) {
            StringBuilder n1Builder = new StringBuilder(n1);
            while (n2.length() != n1Builder.length()) {
                n1Builder.insert(0, "0");
            }
            n1 = n1Builder.toString();
        }

        // variable where the result will be written
        StringBuilder result = new StringBuilder();
        // chars for one element from both strings.
        char current1;
        char current2;
        // var to sum chars from strings.
        int sumCurrents;
        // chars value of '0' for multiply elements.
        char firstSymb = 48;
        char secondSymb = 48;
        // Loop to sum elements of two Numeric Strings
        for (int i = n1.length() - 1; i >= 0; i--) {
            current1 = n1.charAt(i);
            current2 = n2.charAt(i);

            sumCurrents = (current1 - '0') + (current2 - '0');
            sumCurrents = sumCurrents + (firstSymb - '0');
            // reset to zero variable:
            firstSymb = 48;
            // When get sum of two ordinary elements. Cast them to type String.
            // For example: 7+8=15, 15 - is firstAndSecondSymb with type int to String.
            String firstAndSecondSymb = "" + sumCurrents;

            //If sum of elements is more then 9, there will be two chars(for example: 15), so do edit: save second char to result.
            // First char keep in mind. (for example: 15, 1 - first char, 5 - second char)
            if (sumCurrents > 9) {
                firstSymb = firstAndSecondSymb.charAt(0);
                secondSymb = firstAndSecondSymb.charAt(1);
                sumCurrents = secondSymb - '0';
                secondSymb = 48;
            } else {
                sumCurrents += secondSymb - '0';
                secondSymb = 48;
            }
            result.insert(0, sumCurrents);
        }
        if (firstSymb != 48) result.insert(0, firstSymb);

        return result.toString();
    }
}
