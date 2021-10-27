package com.shpp.p2p.cs.ohubanov.assignment2;

import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class Assignment2Part4 extends WindowProgram {
    // Window size
    public static final int APPLICATION_WIDTH = 500;
    public static final int APPLICATION_HEIGHT = 500;

    // Canvas size for flag on screen
    public static final int CANVAS_FLAG_WIDTH = 300;
    public static final int CANVAS_FLAG_HEIGHT = 300;

    // Size of flag
    public static final int FLAG_WIDTH = 300;
    public static final int FLAG_HEIGHT = 300;

    //set colors of Flag (Belgium at this point)
    private static final Color BELGIUM_BLACK = new Color(0, 0, 0);
    private static final Color BELGIUM_YELLOW = new Color(253, 218, 36);
    private static final Color BELGIUM_RED = new Color(239, 51, 64);


    public void run() {
        /**
         * Flag I have chosen uses three vertical stripes.
         * So the code is written for flags with "vertical colors"
         */

        // Draw first part of flag
        GRect gRect1 = new GRect(APPLICATION_WIDTH / 2.0 - CANVAS_FLAG_WIDTH / 2.0,
                APPLICATION_HEIGHT / 2.0 - CANVAS_FLAG_HEIGHT / 2.0,
                FLAG_WIDTH / 3.0,
                FLAG_HEIGHT);
        gRect1.setFilled(true);
        gRect1.setColor(BELGIUM_BLACK);
        add(gRect1);

        // Draw second part of flag
        GRect gRect2 = new GRect(APPLICATION_WIDTH / 2.0 - CANVAS_FLAG_WIDTH / 2.0 + FLAG_WIDTH / 3.0,
                APPLICATION_HEIGHT / 2.0 - CANVAS_FLAG_HEIGHT / 2.0,
                FLAG_WIDTH / 3.0,
                FLAG_HEIGHT);
        gRect2.setFilled(true);
        gRect2.setColor(BELGIUM_YELLOW);
        add(gRect2);

        // Draw third part of flag
        GRect gRect3 = new GRect(APPLICATION_WIDTH / 2.0 - CANVAS_FLAG_WIDTH / 2.0 + FLAG_WIDTH - FLAG_WIDTH / 3.0,
                APPLICATION_HEIGHT / 2.0 - CANVAS_FLAG_HEIGHT / 2.0,
                FLAG_WIDTH / 3.0,
                FLAG_HEIGHT);
        gRect3.setFilled(true);
        gRect3.setColor(BELGIUM_RED);
        add(gRect3);

        // Draw name of flag under the flag.
        GLabel gLabel = new GLabel("Flag of Belgium");
        gLabel.setFont("Times new Roman-16");
        gLabel.getWidth();
        add(gLabel,
                APPLICATION_WIDTH / 2.0 + CANVAS_FLAG_WIDTH / 2.0 - gLabel.getWidth() / 2,
                APPLICATION_HEIGHT / 2.0 + CANVAS_FLAG_HEIGHT / 2.0 + gLabel.getHeight());
    }
}
