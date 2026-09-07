package org.usacoProbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class problem81 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(r.readLine());
        PrintWriter pw = new PrintWriter(System.out);

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[][] grid = new int[x][y];
        for(int i =0; i < grid.length; i++){
            st = new StringTokenizer(r.readLine());
            for(int j =0; j < grid[0].length; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int max = 0;
        for(int i =0; i < grid.length; i++){
            for(int j =0; j < grid[0].length; j++){
                if(verify(i, j, grid)) {
                    max = Math.max(max, grid[i][j]);
                }
            }
        }
        System.out.println(max);
    }

    public static boolean verify(int x, int y, int[][] grid){
        if(x > 0 && grid[x][y] == grid[x-1][y]){
            return true;
        } else if(y > 0 && grid[x][y] == grid[x][y-1]){
            return true;
        } else if(x < grid.length-1 && grid[x][y] == grid[x+1][y]){
            return true;
        } else if(y < grid[0].length -1 && grid[x][y] == grid[x][y+1]){
            return true;
        } else if(x > 0 && y > 0 && grid[x][y] == grid[x-1][y-1]){
            return true;
        } else if(x > 0 && y < grid[0].length -1 && grid[x][y] == grid[x-1][y+1]){
            return true;
        } else if(x < grid.length-1 && y > 0 && grid[x][y] == grid[x+1][y-1]){
            return true;
        } else if(x < grid.length-1 && y < grid[0].length -1 && grid[x][y] == grid[x+1][y+1]){
            return true;
        } else {
            return false;
        }
    }
}
