package com.shpp.p2p.cs.ohubanov.assignment2;

import com.shpp.cs.a.console.TextProgram;

/**
 * Assignment 2 Part 1.
 * a*(x^2) + b*x + c = 0
 */

public class Assignment2Part1 extends TextProgram {
    public void run() {
        double a = -1.0;
        double b = -1.0;
        double c = -1.0;
        a = readInt("Please enter a: ");
        // According to the rule: `a` can't be `0`, so check
        while (a == 0) {
            println("Error, 'a' must be != 0");
            a = readInt("Please enter a: ");
        }
        b = readInt("Please enter b: ");
        c = readInt("Please enter c: ");

        // Method that calculate the quadratic equation
        quadraticEquation(a, b, c);
    }

    // Calculate the quadratic equation
    private void quadraticEquation(double a, double b, double c) {
        double x1 = 0.0;
        double x2 = 0.0;
        // Finding discriminant
        double d = (b * b) - (4 * a * c);

        // Check the conditions
        if (d > 0) {
            x1 = (-b + Math.sqrt(d)) / (2 * a);
            x2 = (-b - Math.sqrt(d)) / (2 * a);
            println("There are two roots: " + x1 + " and " + x2);
        } else if (d == 0) {
            x1 = (-b - Math.sqrt(d)) / (2 * a);
            println("There is one root: " + x1);
        } else {
            println("There are no real roots");
        }
    }
}
