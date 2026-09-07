package org.usacoProbs;

import java.util.Scanner;

public class problem12 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int rooms = s.nextInt();
        int[] roomCapacities = new int[rooms];
        for(int i = 0; i < rooms; i++){
            roomCapacities[i] = s.nextInt();
        }
        int[] stepsPerRoom = new int[rooms];
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < rooms; i++){
            stepsPerRoom[i] = calculateSteps(roomCapacities, i+1);
            min = Math.min(stepsPerRoom[i], min);
        }
        System.out.println(min);
    }
    public static int calculateSteps(int[] roomCaps, int door){

        int cap;
        int dist;
        int steps = 0;

        for(int i = 0; i < roomCaps.length; i++){
            cap = roomCaps[i];
            dist = i+1-door;
            if(dist < 0){
                dist += roomCaps.length;
            }

            steps+= dist*cap;
        }

        return steps;
    }
}
