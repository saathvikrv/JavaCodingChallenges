package org.usacoProbs;

import java.util.Scanner;

public class RooftopView {
    public static int count = 0;

    public static void fillBuilding(char[][] topView, int y, int x, boolean[][] filled){
        int[][] possibleNextPositions = {
                {x+1, y},
                {x-1, y},
                {x, y+1},
                {x, y-1},
        };

        for(int[] nextPos : possibleNextPositions){
            if(nextPos[0] >= 0 && nextPos[0] < topView.length && nextPos[1] >= 0 && nextPos[1] < topView[0].length && topView[nextPos[0]][nextPos[1]] != '.' && !filled[nextPos[0]][nextPos[1]]){
                filled[nextPos[0]][nextPos[1]] = true;
                topView[nextPos[0]][nextPos[1]] = 'B';

//                for(int n = 0; n < topView[0].length; n++){
//                    for(int m = 0; m < topView.length; m++){
//                        System.out.print(topView[m][n]);
//                    }
//                    System.out.println();
//                }
//                System.out.println();

                count++;
                fillBuilding(topView, nextPos[1], nextPos[0], filled);
            }
        }
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int x = s.nextInt();
        int y = s.nextInt();

        char[][] grid = new char[x][y];
        boolean[][] filled = new boolean[x][y];
        s.nextLine();
        int maxCount = 0;
        for(int i =0; i < y; i++){
            String line = s.nextLine();
            for(int j =0; j < x; j++){
                grid[j][i] = line.charAt(j);
            }
        }

        for(int i = 0; i < y; i++){
            for(int j = 0; j < x; j++){
                if(grid[j][i] == '*'){
//                    System.out.println("New Building: \n\n");
                    count = 1;
                    filled[j][i] = true;
                    grid[j][i] = 'B';
                    fillBuilding(grid, i, j, filled);
                    maxCount = Math.max(count, maxCount);
                }
            }
        }
        System.out.println(maxCount);
    }
}
/*
10 5
.......*..
.....***..
.....*..**
.....***.*
.......***



 */
