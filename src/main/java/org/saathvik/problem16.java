package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class problem16 {

    public static int[] getTimeToRate(int[] milkingSpeeds, int[] milkingTimes) {

        int[] timeToRate = new int[100];
        int currentTaskTime;
        int currentMin = 0;


        for(int i = 0; i < milkingSpeeds.length; i++) {

            currentTaskTime = milkingTimes[i];

            for(int j = 0; j < currentTaskTime; j++) {

                timeToRate[currentMin] = milkingSpeeds[i];
                currentMin += 1;

            }
        }
        return timeToRate;
    }

    public static void main(String[] args){


        Scanner s = new Scanner(System.in);
        int bessieSessions = s.nextInt();
        int recordSessions = s.nextInt();
        int[] bessieMilkingSpeeds = new int[bessieSessions];
        int[] bessieMilkingTimes = new int[bessieSessions];
        int[] recordMilkingSpeeds = new int[recordSessions];
        int[] recordMilkingTimes = new int[recordSessions];

        for(int i = 0; i < bessieSessions; i++){
            bessieMilkingTimes[i] = s.nextInt();
            bessieMilkingSpeeds[i] = s.nextInt();
        }

        for(int i = 0; i < recordSessions; i++){
            recordMilkingTimes[i] = s.nextInt();
            recordMilkingSpeeds[i] = s.nextInt();
        }





       int[] bessie = getTimeToRate(recordMilkingSpeeds, recordMilkingTimes);
       int[] record = getTimeToRate(bessieMilkingSpeeds, bessieMilkingTimes);

       int maxDiff = 0;
       for(int i = 0; i < 100; i++){
           maxDiff = Math.max(maxDiff, bessie[i]-record[i]);
       }
       System.out.println(maxDiff);
    }
}
