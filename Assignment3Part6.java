package com.shpp.p2p.cs.ohubanov.assignment3;

import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/**
 * Task: Five seconds of glory
 * Usage: Program that displays 5 seconds of animation.
 *
 */

public class Assignment3Part6 extends WindowProgram {
    // Constants
    public static final int APPLICATION_WIDTH = 1600;
    public static final int APPLICATION_HEIGHT = 800;

    private static final Color COLOR_SKY = new Color(0, 191, 255);
    private static final Color COLOR_GROUND = new Color(63, 155, 11);
    private static final Color COLOR_HOUSE = new Color(150, 75, 0);

    private static final int GROUND_HEIGHT = 100;
    private static final int HOUSE_WIDTH = 500;
    private static final int HOUSE_HEIGHT = 300;

    private static final int DOOR_WIDTH = 75;
    private static final int DOOR_HEIGHT = 150;
    private static final int DOOR_HANDLE = 10;

    private static final int WINDOW_WIDTH = 150;
    private static final int WINDOW_HEIGHT = 150;

    private static final int SUN_RADIUS = 100;

    // Main method for running methods
    public void run() {
        // start timer
        long m = System.currentTimeMillis();
        // Animation method
        animation();
        // end timer
        System.out.println((double) (System.currentTimeMillis() - m));
    }
    
    private void animation() {
        drawObj();
    }

    // Method rendering for animation and static objects.
    private void drawObj() {
        // Color for background "sky".
        setBackground(COLOR_SKY);
        // Method, that draw ground.
        drawGround();
        // Method, that draw house.
        drawHouse();
        // Draw sun and move it
        drawSunAndMove();
    }

    // Draw oval(sun) and move it(animate)
    private void drawSunAndMove() {
        GOval sun = new GOval(-SUN_RADIUS / 2,
                getHeight() - (GROUND_HEIGHT * 2),
                SUN_RADIUS,
                SUN_RADIUS);
        sun.setFilled(true);
        sun.setColor(Color.YELLOW);
        add(sun);
        // boolean for quit the loop, when sun touch the top of window.
        boolean temp = true;
        while(temp) {
            sun.move(1, -1.0);
            pause(3);
            if (sun.getY() == 0) {
                temp = false;
            }
        }
        // boolean for quit the loop, when sun hiding behind the horizon.
        temp = true;
        while (temp) {
            sun.move(1.8, 1);
            pause(4);
            if (sun.getY() == APPLICATION_HEIGHT - GROUND_HEIGHT * 2) {
                temp = false;
            }
        }
    }

    // Draw ground.
    private void drawGround() {
        GRect ground = new GRect(0,
                getHeight() - GROUND_HEIGHT,
                getWidth(),
                GROUND_HEIGHT);
        ground.setFilled(true);
        ground.setColor(COLOR_GROUND);
        add(ground);
    }

    // Draw House.
    private void drawHouse() {
        // House box.
        GRect house = new GRect(APPLICATION_WIDTH / 2 - HOUSE_WIDTH / 2,
                getHeight() - GROUND_HEIGHT - HOUSE_HEIGHT,
                HOUSE_WIDTH,
                HOUSE_HEIGHT);
        house.setFilled(true);
        house.setColor(COLOR_HOUSE);
        add(house);
        // Roof lines.
        GLine roofFirstPart = new GLine(APPLICATION_WIDTH / 2 - HOUSE_WIDTH / 2,
                getHeight() - GROUND_HEIGHT - HOUSE_HEIGHT,
                APPLICATION_WIDTH / 2,
                (getHeight() - GROUND_HEIGHT - HOUSE_HEIGHT - (HOUSE_HEIGHT / 3))); // x, y, x2, y2
        add(roofFirstPart);
        GLine roofSecondPart = new GLine(APPLICATION_WIDTH / 2,
                (getHeight() - GROUND_HEIGHT - HOUSE_HEIGHT - (HOUSE_HEIGHT / 3)),
                APPLICATION_WIDTH / 2 + HOUSE_WIDTH / 2,
                getHeight() - GROUND_HEIGHT - HOUSE_HEIGHT);
        add(roofSecondPart);

        // Door.
        GRect door = new GRect(APPLICATION_WIDTH / 2 - HOUSE_WIDTH / 2 + DOOR_WIDTH,
                getHeight() - GROUND_HEIGHT - DOOR_HEIGHT,
                DOOR_WIDTH,
                DOOR_HEIGHT);
        door.setFilled(true);
        door.setColor(Color.BLACK);
        door.setFillColor(Color.DARK_GRAY);
        add(door);
        // Door handle
        GOval handle = new GOval(APPLICATION_WIDTH / 2 - HOUSE_WIDTH / 2 + DOOR_WIDTH + DOOR_HANDLE,
                getHeight() - GROUND_HEIGHT - DOOR_HEIGHT / 2,
                        DOOR_HANDLE,
                        DOOR_HANDLE);
        handle.setFilled(true);
        handle.setFillColor(Color.WHITE);
        add(handle);

        // Window.
        GRect window = new GRect(APPLICATION_WIDTH / 2 - HOUSE_WIDTH / 2 + WINDOW_WIDTH + (DOOR_WIDTH * 2),
                getHeight() - GROUND_HEIGHT - (WINDOW_HEIGHT * 1.5),
                WINDOW_WIDTH,
                WINDOW_HEIGHT);
        window.setFilled(true);
        window.setColor(Color.BLACK);
        window.setFillColor(Color.DARK_GRAY);
        add(window);
    }
}
