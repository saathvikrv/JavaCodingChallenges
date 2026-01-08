package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class problem8 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int numLines = s.nextInt();
        HashMap<String, Integer> cowScores = new HashMap<>();
        String cowName;
        int cowScore;

        for(int i = 0; i < numLines; i++){
            cowName = s.next();
            cowScore = s.nextInt();
            if(cowScores.containsKey(cowName)){
                cowScores.put(cowName, cowScores.get(cowName) + cowScore);
            } else {
                cowScores.put(cowName, cowScore);
            }
        }
        String[] cows = cowScores.keySet().toArray(new String[0]);

        int min = cowScores.get(cows[0]);
        int secondMin = Integer.MAX_VALUE;
        String minCow = cows[0];
        String secondMinCow = "";


        for(String i : cows){
            if(!Objects.equals(cows[0], i)) {
                if (cowScores.get(i) < min) {

                    secondMin = min;
                    secondMinCow = minCow;
                    min = cowScores.get(i);
                    minCow = i;


                } else if (cowScores.get(i) == min) {
                    minCow = "Tie";

                } else if (cowScores.get(i) < secondMin) {
                    secondMin = cowScores.get(i);
                    secondMinCow = i;

                } else if (cowScores.get(i) == secondMin) {
                    secondMinCow = "Tie";
                }
            }
        }
        if(!Objects.equals(secondMinCow, "")) {
            System.out.println(secondMinCow);
        } else {
            System.out.println(minCow);
        }
    }
}
