package com.shpp.p2p.cs.ohubanov.assignment3;

import com.shpp.cs.a.console.TextProgram;

/**
 * Task: Raising a number to a power.
 * Usage: Take two parameters, and calculate the value of the first parameter raised to the power by the second parameter.
 */

public class Assignment3Part3 extends TextProgram {
    public void run() {
        println(raiseToPower(-2, -3));
    }

    /**
     * Method, that calculate the degree of the number with parameters and return the answer.
     * @param base - the number we want to raise to the power.
     * @param exponent - degree of number.
     * @return - result.
     */
    private double raiseToPower(double base, int exponent) {
        double n = 1.0;
        // If exponent is negative, do transformation according to the rule of Math.
        if (exponent < 0 && base != 0) {
            exponent = -1 * exponent;
            base = 1 / base;
        }
        // Calculate the degree using loop.
        for (int i = 0; i < exponent; i++) {
            n = n * base;
        }
        // Return result.
        if (exponent == 0) {
            return 1;
        } else {
            return n;
        }
    }
}
