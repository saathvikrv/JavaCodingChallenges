package org.usacoProbs;

import java.util.Arrays;
import java.util.Scanner;

public class problem74 {
    public static void main(String[] args){
        Scanner s= new Scanner(System.in);

        int towns = s.nextInt();
        int numroads = towns -1;

        int[][] roads = new int[numroads][2];

        for(int i = 0; i < numroads; i++){
            roads[i][0] = s.nextInt();
            roads[i][1] = s.nextInt();
        }

        boolean[] townsHasExit = new boolean[towns];
        Arrays.fill(townsHasExit, false);

        for(int i = 0; i < roads.length; i++){
            townsHasExit[roads[i][0]-1] = true;
        }

        int currTown = -2;

        for(int i =0; i < townsHasExit.length; i++){
            if(!townsHasExit[i] && currTown == -2){
                currTown = i+1;
            } else if(!townsHasExit[i]){
                currTown = -1;
            }
        }
        System.out.println(currTown);
    }
}
