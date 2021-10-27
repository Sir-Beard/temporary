package com.shpp.p2p.cs.ohubanov.assignment2;

import acm.graphics.GOval;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class Assignment2Part6 extends WindowProgram {
    // Size of one and each oval of Caterpillar.
    private static final int CATERPILLAR_OVAL_SIZE = 70;
    // Number of ovals.
    private static final int CATERPILLAR_NUMBER_OF_OVALS = 6;


    public void run() {
        // Loop to draw Caterpillar
        for (int i = 0; i < CATERPILLAR_NUMBER_OF_OVALS; i++) {
            GOval gOval = new GOval(CATERPILLAR_OVAL_SIZE,
                    CATERPILLAR_OVAL_SIZE);
            gOval.setFilled(true);
            gOval.setColor(Color.RED);
            gOval.setFillColor(Color.GREEN);
            // If i % 2 == 0, set location for ovals on "second floor"
            if (i % 2 == 0) {
                gOval.setLocation(CATERPILLAR_OVAL_SIZE / 2 * i,
                        CATERPILLAR_OVAL_SIZE / 2);
                add(gOval);
            } else {
                // If i % 2 == 1, set location for ovals on "first floor"
                gOval.setLocation(CATERPILLAR_OVAL_SIZE / 2 * i,
                        CATERPILLAR_OVAL_SIZE - CATERPILLAR_OVAL_SIZE);
                add(gOval);
            }
        }

    }
}
