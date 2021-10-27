package com.shpp.p2p.cs.ohubanov.assignment5;

import com.shpp.cs.a.console.TextProgram;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Task: CSV parser.
 * This program opens a CSV file named filename,
 * finds the column and assigns it an index (0 for the first column, 1 for the second, and so on),
 * then returns an ArrayList that contains the information from that column.
 */

public class Assignment5Part4 extends TextProgram {
    public void run() {

        // Insert into "assets/food-origins.csv" - your file, to check if it works.
        extractColumn("assets/food-origins.csv", 1);

    }

    /**
     * This method take the line from a file and return ArrayList <String> containing all fields from a line.
     * Without quotation marks (invertedCommas).
     * @param line - line of Strings from file.
     * @return - modified list of elements from line.
     */
    private ArrayList<String> fieldsIn(String line) {
        // Variable to save modified Strings.
        ArrayList<String> field = new ArrayList<String>();
        char invertedCommas = '\"';
        char comma = ',';
        // String for every word come across
        String word = "";

        // With loop, go through line of Strings and modified it.
        for (int i = 0; i < line.length(); i++) {
            // If there is a specific info taken in inverted commas, it will pass them.
            if (line.charAt(i) == invertedCommas) {
                i++;
                while (line.charAt(i) != invertedCommas) {
                    word += line.charAt(i);
                    i++;
                }
                field.add(word);
                word = "";
            } else if (line.charAt(i) != comma){ // While there are no commas, transfer chars from line, to string, and then add it to List.
                while (line.charAt(i) != comma) {
                    word += line.charAt(i);
                    i++;
                    // To exit the loop without errors, due to overflow
                    if (i >= line.length()) {
                        break;
                    }
                }
                field.add(word);
                word = "";
            }
        }
        return field;
    }

    /**
     * Method opens a CSV file named filename, finds the column and assigns it an index (0 for the first column, 1 for the second, and so on).
     * Then returns an ArrayList that contains the information from that column.
     * @param filename - name of CSV file that will be analyzed.
     * @param columnIndex - number of col in file to be printed.
     * @return - list of elements from file.
     */
    private ArrayList<String> extractColumn(String filename, int columnIndex) {
        // Finish variable where will be saved result.
        ArrayList<String> infoFromColumns = new ArrayList<String>();
        // Temporary variable for lists to be modified.
        ArrayList<String> temporaryFields = new ArrayList<String>();
        // Strings to work with lines from file, and words from lines.
        String line;
        String temp = "";
        try {
            BufferedReader bf = new BufferedReader(new FileReader(filename));
            // Here reading the file by line.
            while ((line = bf.readLine()) != null) {
                // Save modified line in variable.
                temporaryFields = fieldsIn(line);
                // According to columnIndex-value get proper data and save it in variable temp.
                temp = "" + temporaryFields.get(columnIndex);
                // Add to final list that will be printed in console.
                infoFromColumns.add(temp);

            }
        } catch (IOException e) {
            // If File does not exist, return null.
            return null;
        }

        // Uncomment below code if you want print elements in line.
        //println("Info from CSV-file in line: " + infoFromColumns);

        //Print elements in column
        println("Info from CSV-file in col: ");
        for (int i = 0; i < infoFromColumns.size(); i++) {
            println(infoFromColumns.get(i));
        }

        return infoFromColumns;
    }
}
