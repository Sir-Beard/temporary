package com.shpp.p2p.cs.ohubanov.assignment3;

import acm.graphics.GLabel;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Task: Pyramid.
 * Usage: Build a pyramid of bricks. Starts from botoom of screen. Each row has one less brick. Must be centered.
 * Constants - BRICK_HEIGHT, BRICK_WIDTH, BRICKS_IN_BASE, plus App WIDTH and HEIGHT.
 */

public class Assignment3Part4 extends WindowProgram {
    private static final double BRICK_HEIGHT = 50;
    private static final double BRICK_WIDTH = 100;
    private static final double BRICKS_IN_BASE = 5;

    public static final int APPLICATION_WIDTH = 1000;
    public static final int APPLICATION_HEIGHT = 500;

    // Main method to run.
    public void run() {
        bricksBuilder();
    }

    // Building bricks dynamically.
    private void bricksBuilder() {
        GRect brick;
        // Value 'temp' is decrement the constant BRICKS_IN_BASE to work in the loop.
        double temp = BRICKS_IN_BASE;
        // Cols
        for (int y = 1; y <= BRICKS_IN_BASE; y++) {
            // Rows
            for (int x = 0; x < temp; x++) {
                brick = new GRect((getWidth() / 2.0 - (temp * BRICK_WIDTH / 2.0)) + BRICK_WIDTH * x,
                        getHeight() - BRICK_HEIGHT * y,
                        BRICK_WIDTH,
                        BRICK_HEIGHT);
                brick.setFilled(true);
                brick.setColor(Color.BLACK);
                brick.setFillColor(Color.RED);
                add(brick);
                // For pseudo animation
                pause(100);
            }
            // Decrement the value for next level of building pyramid.
            temp--;
        }
    }
}
