package org.example;

import java.util.Scanner;

public class problem26 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int gridLength = s.nextInt();
        int gridWidth = s.nextInt();

        int[][] grid = new int[gridLength][gridWidth];

        for(int i = 0; i < gridLength; i++) {
            for (int j = 0; j < gridWidth; j++) {
                grid[i][j] = s.nextInt();
            }
        }





        int max = 0;
        int maxX = 0;
        int maxY = 0;

        for(int i = 1; i < gridLength-1; i++){
            for(int j = 1; j < gridWidth-1; j++ ){
                if(threeXThreeSum(grid, i, j) > max){
                    max = threeXThreeSum(grid, i , j);
                    maxX = i;
                    maxY = j;
                }
            }
        }

        System.out.println(max);
        System.out.println(maxX+" "+maxY);
    }

    public static int threeXThreeSum(int[][] grid, int x, int y){
        int rows = grid.length;
        int columns = grid[0].length;

        /*
        (0, 0) (0, 1) (1, 0) (1, 1) (0, 2) (1, 2) (2, 2) (2, 0) (2, 1)
        */

        return grid[x-1][y-1]+grid[x][y]+grid[x-1][y]+grid[x][y-1]+grid[x+1][y]+grid[x][y+1]+grid[x+1][y-1]+grid[x-1][y+1]+grid[x+1][y+1];

    }
}
