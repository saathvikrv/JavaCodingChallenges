package org.usacoProbs;

import java.util.Arrays;
import java.util.Scanner;

public class PartitionedPastures {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        char[][] grid = new char[size * 2 + 1][size * 2 + 1];
        int cows = s.nextInt();
        int fences = s.nextInt();
        int[] fenceInfo;
        for(int i = 0; i < fences; i++){
            fenceInfo = new int[]{s.nextInt()*2, s.nextInt()*2, s.nextInt()*2, s.nextInt()*2};
            if(fenceInfo[0] == fenceInfo[2]){
                int mid = Math.max(fenceInfo[1], fenceInfo[3]) - 2;
                grid[fenceInfo[0]-2][mid] = '#';
                grid[fenceInfo[0]-1][mid] = '#';
                grid[fenceInfo[0]][mid] = '#';
            } else {
                int mid = Math.max(fenceInfo[0], fenceInfo[2]) - 2;
                grid[mid][fenceInfo[1]-2] = '#';
                grid[mid][fenceInfo[1]-1] = '#';
                grid[mid][fenceInfo[1]] = '#';
            }
        }

        for(int i = 0; i < size * 2 + 1; i++){
            grid[i][0] = '#';
            grid[0][i] = '#';
            grid[i][size*2] = '#';
            grid[size*2][i] = '#';
        }

        int q = 49;
        for(int i = 0; i < size* 2 -1; i++) {
            for (int j = 0; j < size * 2 - 1; j++) {
                if (grid[i][j] == '\u0000') {
                    floodfill(grid, i, j, (char) q);
                    q++;
                }
            }
        }
        int[] cowsInRegion = new int[q-49];

        for(int i = 0; i < cows; i++){
            int n = ((int) grid[s.nextInt()][s.nextInt()]) - 49;
            cowsInRegion[((int) grid[s.nextInt()][s.nextInt()]) - 49] ++;
        }
        System.out.println(Arrays.toString(cowsInRegion) +"\n");

        for(char[] row : grid){
            System.out.println(Arrays.toString(row));
        }


    }


    public static void floodfill(char[][] topView, int x, int y, char c){

        int[][] possibleNextPositions = {
                {x+1, y},
                {x-1, y},
                {x, y+1},
                {x, y-1},
        };

        for(int[] nextPos : possibleNextPositions){
            if(
                    nextPos[0] >= 0 &&
                            nextPos[0] < topView.length &&
                            nextPos[1] >= 0 &&
                            nextPos[1] < topView[0].length &&
                            topView[nextPos[0]][nextPos[1]] != c &&
                            topView[nextPos[0]][nextPos[1]] != '#'
            ){
                topView[nextPos[0]][nextPos[1]] = c;

//                for(int n = 0; n < topView[0].length; n++){
//                    for(int m = 0; m < topView.length; m++){
//                        System.out.print(topView[m][n]);
//                    }
//                    System.out.println();
//                }
//                System.out.println();

                floodfill(topView, nextPos[0], nextPos[1], c);
            }
        }


    }
}
