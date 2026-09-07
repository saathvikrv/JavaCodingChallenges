package org.usacoProbs;

import java.util.Scanner;

public class problem21 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int cows = s.nextInt();

        int[] startTimes = new int[cows];
        int[] endTimes = new int[cows];
        int[] lockers = new int[cows];

        for(int i =0; i < cows; i++){
            startTimes[i] = s.nextInt();
            endTimes[i] = s.nextInt();
            lockers[i] = s.nextInt();
        }





        int currentLockers = 0;
        int maxLockers = 0;

        for(int i = 1; i < 1000; i++){
            for(int j = 0; j < startTimes.length; j++){
                if(startTimes[j] == i){
                    currentLockers+=lockers[j];
                }
            }

            for(int j = 0; j < endTimes.length; j++){
                if(endTimes[j] == i){
                    currentLockers-=lockers[j];
                }
            }

            if(currentLockers > maxLockers){
                maxLockers = currentLockers;
            }
        }

        System.out.println(maxLockers);
    }
}
