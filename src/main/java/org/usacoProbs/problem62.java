package org.usacoProbs;

import java.util.Arrays;
import java.util.Scanner;

public class problem62 {
    public static int func(char[][] grid, int limit, char dir, int x, int y){
        if(grid.length-2 == x && x == y){
            return 1;
        }


        int horizontal = 0;
        int vertical = 0;

        if(grid[x+1][y] == '.') {
            if (dir == 'E') {
                horizontal += func(grid, limit, 'E', x+1, y);
            } else if (limit > 0) {
                horizontal += func(grid, limit-1, 'E', x+1, y);
            }
        }
        if(grid[x][y+1] == '.') {
            if (dir == 'S') {
                vertical += func(grid, limit, 'S', x, y+1);
            } else if (limit > 0) {
                vertical += func(grid, limit-1, 'S', x, y+1);
            }
        }

        return horizontal + vertical;
    }

    public static int func(char[][] grid, int limit){
        if(grid.length-2 == 0){
            return 1;
        }

        int horizontal = 0;
        int vertical = 0;

        if(grid[1][0] == '.') {
            horizontal += func(grid, limit, 'E', 1, 0);
        }
        if(grid[0][1] == '.') {
            vertical += func(grid, limit, 'S', 0, 1);
        }

        return horizontal + vertical;
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int cases = s.nextInt();
        char[][] grid;
        int sideLen;
        int limit;
        String line;

        for(int test = 0; test < cases; test++){
            sideLen = s.nextInt();
            limit = s.nextInt();
            grid = new char[sideLen+1][sideLen+1];
            for(char[] row : grid){
                Arrays.fill(row, 'H');
            }

            for(int row = 0; row < sideLen; row++){
                line = s.next();
                for(int column = 0; column < sideLen; column++){
                    grid[row][column] = line.charAt(column);
                }
            }
            System.out.println(func(grid, limit));
        }
    }
}
