package com.shpp.p2p.cs.ohubanov.assignment3;

import com.shpp.cs.a.console.TextProgram;

/**
 * Task: Collatz conjecture.
 * Usage: Take some positive integer and call it n
 * If n is even, then divide it by 2
 * If n is odd, then multiply by 3 and add 1
 * Continue this process until n is 1
 */

public class Assignment3Part2 extends TextProgram {
    public void run() {
        // Initialize n in order to enter the loop
        int n = -1;
        while (n <= 0) {
            n = readInt("Enter a number: ");
            // Check if user entered proper number
            if (n <= 0) {
                println("Number must be positive!");
            }
        }
        // Here we go, while number not 1, do actions
        while (n != 1) {
            if (n % 2 == 0) {
                print(n + " is even so I take half:  ");
                n /= 2;
                println(n);
            } else {
                print(n + " is odd so I make 3n + 1: ");
                n = n * 3 + 1;
                println(n);
            }
        }
        println("end.");
    }
}
