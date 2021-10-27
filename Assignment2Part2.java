package com.shpp.p2p.cs.ohubanov.assignment2;

import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class Assignment2Part2 extends WindowProgram {
    // Diameter of oval
    private static final int DIAMETER_OF_OVAL = 100;

    // If you want to check if it works with different sizes of window, change next values:
    public static final int APPLICATION_WIDTH = 300;
    public static final int APPLICATION_HEIGHT = 300;

    @Override
    public void run() {
        //Set each oval on window
        GOval gOval = new GOval(
                getWidth() - getWidth(),
                getHeight() - getHeight(),
                DIAMETER_OF_OVAL,
                DIAMETER_OF_OVAL);
        gOval.setFilled(true);
        gOval.setColor(Color.BLACK);
        add(gOval);

        GOval gOval2 = new GOval(
                getWidth() - DIAMETER_OF_OVAL,
                getHeight() - getHeight(),
                DIAMETER_OF_OVAL,
                DIAMETER_OF_OVAL);
        gOval2.setFilled(true);
        gOval2.setColor(Color.BLACK);
        add(gOval2);

        GOval gOval3 = new GOval(
                getWidth() - getWidth(),
                getHeight() - DIAMETER_OF_OVAL,
                DIAMETER_OF_OVAL,
                DIAMETER_OF_OVAL);
        gOval3.setFilled(true);
        gOval3.setColor(Color.BLACK);
        add(gOval3);

        GOval gOval4 = new GOval(
                getWidth() - DIAMETER_OF_OVAL,
                getHeight() - DIAMETER_OF_OVAL,
                DIAMETER_OF_OVAL,
                DIAMETER_OF_OVAL);
        gOval4.setFilled(true);
        gOval4.setColor(Color.BLACK);
        add(gOval4);

        // Set rectangle on each oval
        GRect gRect = new GRect(
                DIAMETER_OF_OVAL / 2,
                DIAMETER_OF_OVAL / 2,
                getWidth() - DIAMETER_OF_OVAL,
                getHeight() - DIAMETER_OF_OVAL);
        gRect.setFilled(true);
        gRect.setColor(Color.WHITE);
        gRect.setFillColor(Color.WHITE);
        add(gRect);
    }
}
