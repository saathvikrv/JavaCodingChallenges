package org.usacoProbs;

import java.util.Scanner;

public class Midterm_11{
    public static int minDist;

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int height = s.nextInt();
        int width = s.nextInt();
        char[][] grid = new char[height+2][width+2];
        for(int i = 0; i < height; i++){
            String line = s.next();

            for(int j = 0; j < width; j++){
                grid[i+1][j+1] = line.charAt(j);
            }
        }
        int n = 0;
        while (grid[n / grid[0].length][n % grid[0].length] != 'X') {
            n++;
        }

        floodfill(grid, n / grid[0].length, n % grid[0].length, 'A');

        while (grid[n / grid[0].length][n % grid[0].length] != 'X') {
            n++;
        }

        floodfill(grid, n / grid[0].length, n % grid[0].length, 'B');

        minDist = Integer.MAX_VALUE;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 'A') {
                    minDist = Math.min(minDist, explore(grid, i, j, 0));
                }
            }
        }

        System.out.println(minDist);
    }

    public static int explore(char[][] grid, int x, int y, int count){
        int i = x;
        int j = y;
        int dist = 1;
        int ans = Integer.MAX_VALUE;
        i++;
        while(grid[i][j] == '.' && grid[i+1][j] != 'B' && grid[i-1][j] != 'B' && grid[i][j+1] != 'B' && grid[i][j-1] != 'B'){
            i++;
            dist++;
        }

        if(grid[i][j] == '.' && (grid[i+1][j] == 'B' || grid[i-1][j] == 'B' || grid[i][j+1] == 'B' || grid[i][j-1] == 'B')){
            ans = dist;
        }

        i = x;
        j = y;
        dist = 1;

        i--;
        while(grid[i][j] == '.' && grid[i+1][j] != 'B' && grid[i-1][j] != 'B' && grid[i][j+1] != 'B' && grid[i][j-1] != 'B'){
            i--;
            dist++;
        }

        if(grid[i][j] == '.' && (grid[i+1][j] == 'B' || grid[i-1][j] == 'B' || grid[i][j+1] == 'B' || grid[i][j-1] == 'B')){
            ans = Math.min(ans, dist);
        }

        i = x;
        j = y;
        dist = 1;

        j++;
        while(grid[i][j] == '.' && grid[i+1][j] != 'B' && grid[i-1][j] != 'B' && grid[i][j+1] != 'B' && grid[i][j-1] != 'B'){
            j++;
            dist++;
        }

        if(grid[i][j] == '.' && (grid[i+1][j] == 'B' || grid[i-1][j] == 'B' || grid[i][j+1] == 'B' || grid[i][j-1] == 'B')){
            ans = Math.min(ans, dist);
        }

        i = x;
        j = y;
        dist = 1;

        j--;
        while(grid[i][j] == '.' && grid[i+1][j] != 'B' && grid[i-1][j] != 'B' && grid[i][j+1] != 'B' && grid[i][j-1] != 'B'){
            j--;
            dist++;
        }

        if(grid[i][j] == '.' && (grid[i+1][j] == 'B' || grid[i-1][j] == 'B' || grid[i][j+1] == 'B' || grid[i][j-1] == 'B')){
            ans = Math.min(ans, dist);
        }

        return ans;
    }


    public static void floodfill(char[][] topView, int x, int y, char n){
        int[][] possibleNextPositions = {
                {x+1, y},
                {x-1, y},
                {x, y+1},
                {x, y-1},
        };

        for(int[] nextPos : possibleNextPositions){
            if(
                    topView[nextPos[0]][nextPos[1]] == 'X'
            ){
                topView[nextPos[0]][nextPos[1]] = n;

                floodfill(topView, nextPos[0], nextPos[1], n);
            }
        }


    }
}