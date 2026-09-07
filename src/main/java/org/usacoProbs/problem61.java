package org.usacoProbs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class problem61 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int numBeavers = s.nextInt();
        int[][] beavers = new int[numBeavers][3];
        String dir;

        for(int i = 0; i < numBeavers; i++){
            dir = s.next();
            if(Objects.equals(dir, "N")){
                beavers[i][0] = 1;
            } else {
                beavers[i][0] = 0;
            }
            beavers[i][1] = s.nextInt();
            beavers[i][2] = s.nextInt();
        }

        int[] beaver1;
        int[] beaver2;
        int timeNorth;
        int timeEast;
        ArrayList<Integer>[] stopTime = new ArrayList[beavers.length];
        Arrays.fill(stopTime, null);
        for(int i = 0; i < beavers.length; i++){
            for(int j = i + 1; j < beavers.length; j++){
                if(stopTime[i] == null && stopTime[j] == null) {
                    beaver1 = beavers[i];
                    beaver2 = beavers[j];
                    if (beaver1[0] > beaver2[0] && beaver1[1] > beaver2[1] && beaver1[2] < beaver2[2]) {
                        //b1 north, b2 east
                        timeEast = beaver1[1] - beaver2[1];
                        timeNorth = beaver2[2] - beaver1[2];
                        if (timeNorth > timeEast) {
                            if(stopTime[i] == null){
                                stopTime[i] = new ArrayList<>();
                            }
                            stopTime[i].add(timeNorth);
                        }
                        if (timeNorth < timeEast) {
                            if(stopTime[j] == null){
                                stopTime[j] = new ArrayList<>();
                            }
                            stopTime[j].add(timeEast);
                        }


                    } else if (beaver1[0] < beaver2[0] && beaver1[1] < beaver2[1] && beaver1[2] > beaver2[2]) {
                        //b1 east, b2 north
                        timeNorth = beaver2[1] - beaver1[1];
                        timeEast = beaver1[2] - beaver2[2];
                        if (timeNorth < timeEast) {
                            if(stopTime[i] == null){
                                stopTime[i] = new ArrayList<>();
                            }
                            stopTime[i].add(timeNorth);
                        }
                        if (timeNorth > timeEast) {
                            if(stopTime[j] == null){
                                stopTime[j] = new ArrayList<>();
                            }
                            stopTime[j].add(timeEast);
                        }
                    }
                }
            }
        }
        for(ArrayList<Integer> time : stopTime){
            if(time == null){
                System.out.println("Infinity");
            } else {

                int max = 0;
                for(Integer num : time){
                    max = Math.max(num, max);
                }
                System.out.println(Math.abs(max));
            }
        }
    }
}
