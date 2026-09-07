package org.usacoProbs;

import java.util.ArrayList;

public class SeedPlacement {
    public static void plantSeed(char[][] grid, int x, int y){

        if(grid[x][y] == '*'){
        } else {
            int result = 0;
            grid[x][y] = '*';
            ArrayList<int[]> emptyBorderSeeds = isSeedCramped(grid, x, y);
            if(emptyBorderSeeds.size() == 1){
                plantSeed(grid, emptyBorderSeeds.getFirst()[0], emptyBorderSeeds.getFirst()[1]);

            }
        }
    }

    public static ArrayList<int[]> isSeedCramped(char[][] grid, int x, int y){
        final int[][] locations = {
                {x+1, y},
                {x-1, y},
                {x, y+1},
                {x, y-1}
        };
        ArrayList<int[]> emptySquares = new ArrayList<>();

        for(int[] location : locations){
            if(grid[location[0]][location[1]] != '*'){
                emptySquares.add(location);
            }
        }


        return emptySquares;
    }
}
