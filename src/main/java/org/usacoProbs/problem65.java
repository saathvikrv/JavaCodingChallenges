package org.usacoProbs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class problem65 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int[][] bombLocations = new int[s.nextInt()][2];
        for(int i= 0; i < bombLocations.length; i++){
            bombLocations[i][0] = s.nextInt();
            bombLocations[i][1] = s.nextInt();
        }



        Arrays.sort(bombLocations, Comparator.comparingInt(a -> a[0]));
        int[] bomb;
        int minDist = Integer.MAX_VALUE;
        for(int i =0; i < bombLocations.length; i++){
            if(bombLocations[i][1] == 0){
                if(i != 0){
                    minDist = Math.min(minDist, bombLocations[i][0] - bombLocations[i-1][0]);
                }

                while(i+1 < bombLocations.length && bombLocations[i+1][1] == 0) {
                    i++;
                }
                if (i != bombLocations.length-1){
                    minDist = Math.min(minDist, bombLocations[i+1][0] - bombLocations[i][0]);
                }

            }
        }

        int triggered = 1;

        for(int i = 0; i < bombLocations.length-1; i++){
            if(bombLocations[i][1] == 1) {
                if (bombLocations[i + 1][0] - bombLocations[i][0] >= minDist && bombLocations[i+1][1] == 1) {
                    triggered++;
                }
            } else if(bombLocations[i+1][1] == 1){
                triggered++;
            }
        }
        System.out.println(triggered);


    }
}