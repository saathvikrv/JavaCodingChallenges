package org.usacoProbs;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class problem56v2 {
    public static void main(String[] args){
        Scanner s= new Scanner(System.in);
        int N = s.nextInt();
        int time = 0;
        int[][] grid = new int[2001][2001];
        for(int[] row : grid){
            Arrays.fill(row, -1);
        }

        int r = 1000;
        int c = 1000;
        grid[r][c] = 0;
        int minTime = Integer.MAX_VALUE;

        String dir;
        int steps;
        int diff;

        for(int i = 0; i < N; i++){
            dir = s.next();
            steps = s.nextInt();

            for(int j = 0; j < steps; j++){
                time++;
                if(Objects.equals(dir, "N")){
                    r++;
                }
                if(Objects.equals(dir, "S")){
                    r--;
                }
                if(Objects.equals(dir, "E")){
                    c++;
                }
                if(Objects.equals(dir, "W")){
                    c--;
                }

                if(grid[r][c] != time && grid[r][c] != -1){
                    diff = time - grid[r][c];
                    minTime = Math.min(diff, minTime);
                }
                grid[r][c] = time;
            }


        }
        if(minTime == Integer.MAX_VALUE){
            minTime = -1;
        }

        System.out.println(minTime);
    }
}
