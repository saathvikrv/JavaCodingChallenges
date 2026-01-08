package org.example;

import java.util.Scanner;


public class problem1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numOfPeople = scanner.nextInt();
        int[][] locations = new int[numOfPeople][2];
        for(int i = 0; i < numOfPeople; i++){
            locations[i][0] = scanner.nextInt();
            locations[i][1] = scanner.nextInt();
        }

        double maxDist = 0;
        int person1 = -1;
        int person2 = -1;


        for(int i = 0; i < numOfPeople; i++){
            for(int j = i + 1; j < numOfPeople; j++){
                if(maxDist < calcDist(locations[i], locations[j])){
                    maxDist = calcDist(locations[i], locations[j]);
                    person1 = i+1;
                    person2 = j+1;
                }
            }
        }

        System.out.println(person1+ " "+person2);

        //System.out.println(calcDist(new int[]{0, 0}, new int[]{3, 4}));
    }

    public static double calcDist(int[] pt1, int[] pt2){
        int x, y;


        if(pt1[0] - pt2[0] < 0){
            x = pt2[0] - pt1[0];
        } else {
            x = pt1[0] - pt2[0];
        }

        if(pt1[1] - pt2[1] < 0){
            y = pt2[1] - pt1[1];
        } else {
            y = pt1[1] - pt2[1];
        }

        return Math.sqrt(x*x+y*y);
    }
}