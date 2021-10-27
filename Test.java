package com.shpp.p2p.cs.ohubanov.assignment6;

import com.shpp.cs.a.console.TextProgram;
import com.shpp.p2p.cs.ohubanov.assignment6.tm.StdAudio;

public class Test extends TextProgram {
    public void run() {

        //int[][] num = {{1,2,3},{100, 200, 300, 400, 500, 600}};
        int[][] num = new int[10][4];
        //int[] num = new int[10];
        int[] test = new int[15];
        System.out.println(num[5].length);
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {
                //num[i][j] = 123;
                //System.out.println("i: " + i + " j:" + j +" " +num[i][j]);
                test[num[i][j]]++;
            }
        }

        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }

//        int[] res = new int[20];
//
//        for (int i = 0; i < num.length; i++) {
//            for (int j = 0; j < num[i].length; j++) {
//
//            }
//        }
//        for (int i = 0; i < num2.length; i++) {
//            System.out.println(num2[i]);
//        }
    }
}
