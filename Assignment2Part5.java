package com.shpp.p2p.cs.ohubanov.assignment2;

import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class Assignment2Part5 extends WindowProgram {
    // Window size
    public static final int APPLICATION_WIDTH = 500;
    public static final int APPLICATION_HEIGHT = 500;

    /* The number of rows and columns in the grid, respectively. */
    public static final int NUM_ROWS = 5;
    private static final int NUM_COLS = 6;

    /* The width and height of each box. */
    private static final double BOX_SIZE = 40;

    /* The horizontal and vertical spacing between the boxes. */
    private static final double BOX_SPACING = 10;

    public void run() {
        // Using loop to draw illusion with several rects
        // First loop for rows
        for (int y = 0; y < NUM_ROWS; y++) {
            // Second for columns
            for (int x = 0; x < NUM_COLS; x++) {
                GRect gRect = new GRect(BOX_SPACING + (BOX_SIZE * x + BOX_SPACING * x),
                        BOX_SPACING + (BOX_SIZE * y + BOX_SPACING * y),
                        BOX_SIZE,
                        BOX_SIZE);
                gRect.setFilled(true);
                gRect.setFillColor(Color.BLACK);
                add(gRect);
            }
        }
    }

}
