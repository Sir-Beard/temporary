package com.shpp.p2p.cs.ohubanov.assignment2;

import acm.graphics.GOval;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class Assignment2Part3 extends WindowProgram {
    /* Constants controlling the relative positions of the
     * three toes to the upper-left corner of the pawprint.
     */
    private static final double FIRST_TOE_OFFSET_X = 0;
    private static final double FIRST_TOE_OFFSET_Y = 20;
    private static final double SECOND_TOE_OFFSET_X = 30;
    private static final double SECOND_TOE_OFFSET_Y = 0;
    private static final double THIRD_TOE_OFFSET_X = 60;
    private static final double THIRD_TOE_OFFSET_Y = 20;

    /* The position of the heel relative to the upper-left
     * corner of the pawprint.
     */
    private static final double HEEL_OFFSET_X = 20;
    private static final double HEEL_OFFSET_Y = 40;

    /* Each toe is an oval with this width and height. */
    private static final double TOE_WIDTH = 20;
    private static final double TOE_HEIGHT = 30;

    /* The heel is an oval with this width and height. */
    private static final double HEEL_WIDTH = 40;
    private static final double HEEL_HEIGHT = 60;

    /* The default width and height of the window. */
    public static final int APPLICATION_WIDTH = 270;
    public static final int APPLICATION_HEIGHT = 220;

    public void run() {
        drawPawprint(20, 20);
        drawPawprint(180, 70);
    }

    // Drawning the Pawprint
    private void drawPawprint(double x, double y) {
        // Draw first toe
        GOval gOval1 = new GOval(x + FIRST_TOE_OFFSET_X,
                y + FIRST_TOE_OFFSET_Y,
                TOE_WIDTH,
                TOE_HEIGHT);
        gOval1.setFilled(true);
        gOval1.setFillColor(Color.BLACK);
        add(gOval1);

        // Draw second toe
        GOval gOval2 = new GOval(x +SECOND_TOE_OFFSET_X,
                y + SECOND_TOE_OFFSET_Y,
                TOE_WIDTH,
                TOE_HEIGHT);
        gOval2.setFilled(true);
        gOval2.setFillColor(Color.BLACK);
        add(gOval2);

        // Draw third toe
        GOval gOval3 = new GOval(x + THIRD_TOE_OFFSET_X,
                y + THIRD_TOE_OFFSET_Y,
                TOE_WIDTH,
                TOE_HEIGHT);
        gOval3.setFilled(true);
        gOval3.setFillColor(Color.BLACK);
        add(gOval3);

        // Draw heel
        GOval gOval4 = new GOval(x +HEEL_OFFSET_X,
                y + HEEL_OFFSET_Y,
                HEEL_WIDTH,
                HEEL_HEIGHT);
        gOval4.setFilled(true);
        gOval4.setFillColor(Color.BLACK);
        add(gOval4);
    }
}
