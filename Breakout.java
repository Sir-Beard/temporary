package com.shpp.p2p.cs.ohubanov.assignment4;

import acm.graphics.*;
import acm.util.RandomGenerator;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Task: Breakout game.
 * Write the game with racket that user can move,
 * blocks that need to be broken, and a ball that flies across the field.
 */

public class Breakout extends WindowProgram {
    /** Width and height of application window in pixels */
    public static final int APPLICATION_WIDTH = 400;
    public static final int APPLICATION_HEIGHT = 600;

    /** Dimensions of game board (usually the same) */
    private static final int WIDTH = APPLICATION_WIDTH;
    private static final int HEIGHT = APPLICATION_HEIGHT;

    /** Dimensions of the paddle */
    private static final int PADDLE_WIDTH = 60;
    private static final int PADDLE_HEIGHT = 10;

    /** Offset of the paddle up from the bottom */
    private static final int PADDLE_Y_OFFSET = 30;

    /** Number of bricks per row */
    private static final int NBRICKS_PER_ROW = 10;

    /** Number of rows of bricks */
    private static final int NBRICK_ROWS = 10;

    /** Separation between bricks */
    private static final int BRICK_SEP = 4;

    /** Width of a brick */
    private static final int BRICK_WIDTH =
            (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

    /** Height of a brick */
    private static final int BRICK_HEIGHT = 8;

    /** Radius of the ball in pixels */
    private static final int BALL_RADIUS = 10;

    /** Offset of the top brick row from the top */
    private static final int BRICK_Y_OFFSET = 70;

    /** Number of turns */
    private static final int NTURNS = 3;

    // Speed of object(ball) movement on field
    private static final double PAUSE_TIME = 10;

    // To calculate the movement of the ball across the field, excluding the top menu of the application.
    private static final double TOP_MENU_HEIGHT = 23;

    // Constant for colors of bricks.
    private static final Color[] COLORS_OF_BRICKS = new Color[]{Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN};

    // Variables speed of object-ball
    private double vx;
    private double vy;

    @Override
    public void run() {
        /* You fill this in, along with any subsidiary methods */
        addMouseListeners();

        addBricks();
        addRacket();
        addBall();
        GOval ball = addBall();
        moveBall(ball);
        finishGameMes();
    }

    // Number of attempts in variable numOfAttempts to work with it in code.
    private int numOfAttempts = NTURNS;

    /**
     * Add object(ball) on field, give it random start position to move.
     * When user press the left mouse button the game will begin.
     * Object will move across the field with restrictions of field frames, bricks and racket(that user moves).
     * If object hits the floor, new attempt starts, object goes to starting position. Game progress will be saved.
     * User will have 3 attempts.
     * When there are no bricks left on the field, or attempts will run out, game will process the final message.
     * @param ball - object that is moving on field.
     */
    private void moveBall(GOval ball) {
        add(ball);
        randomBallMoveStartDirection();
        waitForClick();
        while (numOfAttempts > 0) {
            ball.move(vx, vy);
            // Movement of object(ball) in limits of field.
            if (ball.getX() >= WIDTH - BALL_RADIUS || ball.getX() < 0) {
                vx = -vx;
            }
            if (ball.getY() >= HEIGHT - BALL_RADIUS - TOP_MENU_HEIGHT || ball.getY() < 0) {
                vy = -vy;
            }
            // If object(ball) hits the floor (bellow racket), the ball moves to the starting position.
            if (ball.getY() > HEIGHT - BALL_RADIUS - TOP_MENU_HEIGHT) {
                System.out.println("Attempts left: " + --numOfAttempts);
                //moveBall(ball);
                nextAttempt(ball);
                waitForClick();
                randomBallMoveStartDirection();
            }
            ballCollide(ball);
            if (countBrick == 0) {
                numOfAttempts = -1;
            }
            pause(PAUSE_TIME);
        }
    }

    /**
     * Random movement of object(ball) on starting position when game starts.
     */
    private void randomBallMoveStartDirection() {
        RandomGenerator rgen = RandomGenerator.getInstance();
        vx = rgen.nextDouble(1.0, 3.0);
        vy = 3.0;
        if (rgen.nextBoolean(0.5)) vx = -vx;
    }

    /**
     * Set ball on middle of field, when starting the attempt.
     * @param ball - object which we set on middle.
     */
    private void nextAttempt(GOval ball) {
        ball.setLocation(WIDTH / 2 - BALL_RADIUS / 2,
                HEIGHT / 2 - BALL_RADIUS / 2);
    }

    // Total amount of bricks on field
    private int countBrick = NBRICKS_PER_ROW * NBRICK_ROWS;

    /**
     * If object(ball) hits an object on its way that is a racket, it will bounce.
     * If object(ball) hits an object in its path that is not a racket, and is not an empty object,
     * it will bounce, and the counter of bricks on field will decremented.
     * @param ball - object(ball) which moves on field.
     */
    private void ballCollide(GOval ball) {

        if (getElementAt(ball.getX(), ball.getY() + BALL_RADIUS) == racket) {
            vy = -vy;
        }
        if (getElementAt(ball.getX(), ball.getY()) != racket && getElementAt(ball.getX(), ball.getY()) != null) {
            remove(getElementAt(ball.getX(), ball.getY()));
            System.out.println("Bricks left: " + --countBrick);
            vy = -vy;
        }

        // Condition if ball is above the brick, so it does not "fall into" the brick.
        if (getElementAt(ball.getX() + BALL_RADIUS, ball.getY() + BALL_RADIUS) != racket && getElementAt(ball.getX() + BALL_RADIUS, ball.getY() + BALL_RADIUS) != null) {
            remove(getElementAt(ball.getX() + BALL_RADIUS, ball.getY() + BALL_RADIUS));
            System.out.println("Bricks left: " + --countBrick);
            vy = -vy;
        }

        // if ball is on side of brick
        if (getElementAt(ball.getX() + BALL_RADIUS, ball.getY()) != racket && getElementAt(ball.getX() + BALL_RADIUS, ball.getY()) != null) {
            remove(getElementAt(ball.getX() + BALL_RADIUS, ball.getY()));
            System.out.println("Bricks left: " + --countBrick);
            vy = -vy;
            vx = -vx;
        }
        if (getElementAt(ball.getX(), ball.getY() + BALL_RADIUS) != racket && getElementAt(ball.getX(), ball.getY() + BALL_RADIUS) != null) {
            remove(getElementAt(ball.getX(), ball.getY() + BALL_RADIUS));
            System.out.println("Bricks left: " + --countBrick);
            vy = -vy;
            vx = -vx;
        }
    }

    /**
     * Method that displays message on field either the player won or lost.
     */
    private void finishGameMes() {
        GLabel finalMes;
        if (countBrick == 0) {
            finalMes = new GLabel("YOU WON!");
            finalMes.setLocation(WIDTH / 2.0 - finalMes.getWidth(), HEIGHT / 2);
            finalMes.setFont("Arial-30");
            finalMes.setColor(Color.GREEN);
            add(finalMes);
        }
        if (numOfAttempts == 0) {
            finalMes = new GLabel("You lose.");
            finalMes.setLocation(WIDTH / 2.0 - finalMes.getWidth(), HEIGHT / 2);
            finalMes.setFont("Arial-20");
            finalMes.setColor(Color.RED);
            add(finalMes);
        }
    }

    /**
     * Making bricks on app screen.
     * Constants specify the number of rows(x) and columns(y).
     * Hard code for setting colors for each brick.
     */
    private void addBricks() {
        for (int y = 0; y < NBRICK_ROWS; y++) {
            for (int x = 0; x < NBRICKS_PER_ROW; x++) {
                GRect brick = new GRect((BRICK_WIDTH * x + BRICK_SEP * x),
                        BRICK_Y_OFFSET + (y * BRICK_SEP) * BRICK_SEP,
                        BRICK_WIDTH,
                        BRICK_HEIGHT);
                brick.setFilled(true);
                brick.setColor(COLORS_OF_BRICKS[y / 2]); // divide by 2 because there are only five colors in arr.
                add(brick);
            }
        }
    }

    /**
     * Method is makng a ball on application screen and return it.
     * @return - object(ball), that is moved across the app field.
     */
    private GOval addBall() {
        GOval ball = new GOval(WIDTH / 2 - BALL_RADIUS / 2,
                HEIGHT / 2 - BALL_RADIUS / 2,
                BALL_RADIUS,
                BALL_RADIUS);
        ball.setFilled(true);
        ball.setColor(Color.BLACK);
        return ball;
    }

    // Global variable for racket, so we can use it in methods bellow.
    private GObject selectedRacket;

    /**
     * When we push the mouse button, we get coordinates where exactly it was pressed.
     * Select the object under mouse pressed button.
     * Put the received data into a variable selectedRacket.
     * @param mouseEvent - mouse event parameter.
     */
    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        selectedRacket = getElementAt(mouseEvent.getX(), mouseEvent.getY());
    }

    /**
     * When we move mouse with selected object, new coordinates sets to obj.
     * Our racket is static on Y coordinate and can move only in X coordinate.
     * @param mouseEvent - in this case, listen the racket, if user want to move it with mouse.
     */
    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        if (selectedRacket == racket) {
            double newX = mouseEvent.getX() - selectedRacket.getWidth() / 2.0;
            double staticY = HEIGHT - PADDLE_Y_OFFSET * 2;
            selectedRacket.setLocation(newX, staticY);

            /**
             * Boundary conditions for racket in application width.
             * So racket will not fly over the edges.
             */
            if (newX < 0){
                selectedRacket.setLocation(0, staticY);
            }
            if (newX > WIDTH - PADDLE_WIDTH) {
                selectedRacket.setLocation(WIDTH - PADDLE_WIDTH, staticY);
            }
        }
    }

    // Create GRect for racket globally, so we can use throughout the program.
    private GRect racket;

    /**
     * Making the object(racket) and add it on field.
     */
    private void addRacket() {
        racket = new GRect(WIDTH / 2 - PADDLE_WIDTH / 2,
                HEIGHT - PADDLE_Y_OFFSET * 2,
                PADDLE_WIDTH,
                PADDLE_HEIGHT);
        racket.setFilled(true);
        racket.setColor(Color.BLACK);
        add(racket);
    }
}
