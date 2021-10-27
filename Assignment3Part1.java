package com.shpp.p2p.cs.ohubanov.assignment3;

import com.shpp.cs.a.console.TextProgram;

/**
 * Name of task: Aerobics
 * Usage: Asks the user for number of minutes spent in the last seven days on exercises, and, accordingly, reports:
 * 1. Whether enough time was given to exercise for cardiovascular health, and if not,
 * how many days of proper life (with classes of more than 30 minutes) are not enough for the recommended schedule.
 * 2. Whether there was enough exercise to lower blood pressure and cholesterol,
 * and if not, how many days the user did not last 40 minutes a day.
 */
public class Assignment3Part1 extends TextProgram {
    // Array keeps the minutes for each day of training.
    private int[] masOfTrainMinADay = new int[7];

    public void run() {
        int minutes;
        int oneWeek = 7;
        for (int i = 1; i <= oneWeek; i++) {
            minutes = readInt("How many minutes did you do on day " + i + "? ");
            masOfTrainMinADay[i - 1] = minutes;
        }
        println();
        calculateCardiovacularHealth();
        calculateBloodPressure();
    }

    // Void method calculate the Cardiovacular Health.
    private void calculateCardiovacularHealth() {
        int needMinToTrainCardiovacularHealth = 30;
        int daysNeedToTrainCardiovascularHealth = 5;
        for (int i = 0; i < masOfTrainMinADay.length; i++) {
            if (masOfTrainMinADay[i] >= needMinToTrainCardiovacularHealth) {
               daysNeedToTrainCardiovascularHealth--;
           }
            if (daysNeedToTrainCardiovascularHealth <= 0) {
                break;
            }
        }
        println("Cardiovacular health: ");
        if (daysNeedToTrainCardiovascularHealth == 0) {
            println("   Great job! You've done enough exercise for cardiovacular health.");
        } else {
            println("   You needed to train hard for at least " + daysNeedToTrainCardiovascularHealth + " more day(s) a week!");
        }
    }

    // Void method calculate the Blood Pressure.
    private void calculateBloodPressure() {
        int needMinToTrainBloodPressure = 40;
        int daysNeedToTrainBloodPressure = 3;
        for (int i = 0; i < masOfTrainMinADay.length; i++) {
            if (masOfTrainMinADay[i] >= needMinToTrainBloodPressure) {
                daysNeedToTrainBloodPressure--;
            }
            if (daysNeedToTrainBloodPressure <= 0) {
                break;
            }
        }
        println("Blood pressure: ");
        if (daysNeedToTrainBloodPressure == 0) {
            println("   Great job! You've done enough exercise to keep a low blood pressure.");
        } else {
            println("   You needed to train hard for at least " + daysNeedToTrainBloodPressure + " more day(s) a week!");
        }
    }
}
