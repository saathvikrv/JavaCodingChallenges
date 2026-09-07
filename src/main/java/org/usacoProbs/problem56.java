package org.usacoProbs;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class problem56 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int moves = s.nextInt();
        boolean[][] grid = new boolean[1000][1000];
        for(boolean[] row: grid){
            Arrays.fill(row, false);
        }
        grid[500][500] = true;
        int x = 500;
        int y = 500;
        String dir;
        int steps;
        int time = 0;
        int minGap = Integer.MAX_VALUE;
        for(int move = 0; move < moves; move++){
            dir = s.next();
            steps = s.nextInt();
            if(Objects.equals(dir, "N")) {
                for(int i = 0; i < steps; i++){
                    y++;
                    time++;
                    if(grid[x][y] && time > 0){
                        minGap = Math.min(minGap, time);
                        time = 0;
                    }
                    grid[x][y] = true;
                }
            } else if(Objects.equals(dir, "S")){
                for(int i = 0; i < steps; i++){
                    y--;
                    time++;
                    if(grid[x][y] && time > 0){
                        minGap = Math.min(minGap, time);
                        time = 0;
                    }
                    grid[x][y] = true;
                }
            } else if(Objects.equals(dir, "E")){
                for(int i = 0; i < steps; i++){
                    x++;
                    time++;
                    if(grid[x][y] && time > 0){
                        minGap = Math.min(minGap, time);
                        time = 0;
                    }
                    grid[x][y] = true;
                }
            } else if(Objects.equals(dir, "W")){
                for(int i = 0; i < steps; i++){
                    x--;
                    time++;
                    if(grid[x][y] && time > 0){
                        minGap = Math.min(minGap, time);
                        time = 0;
                    }
                    grid[x][y] = true;
                }
            }

        }
        System.out.println(minGap);
    }
}
