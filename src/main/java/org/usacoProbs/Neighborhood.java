package org.usacoProbs;

import java.util.Arrays;
import java.util.Scanner;

public class Neighborhood {
    public static int count = 0;
    public static int maxSize;

    public static void main(String[] args){
        char[][] grid = new char[101][101];
        Scanner s = new Scanner(System.in);
        int points = s.nextInt();
        for(char[] n: grid){
            Arrays.fill(n, '.');
        }
        maxSize = 0;
        for(int i =0; i < points; i++){
            int x = s.nextInt();
            int y = s.nextInt();

            maxSize = Math.max(maxSize, Math.max(x + 4, y + 4));
            grid[x][y] = '@';
        }

        for(int n = 0; n < maxSize; n++){
            for(int m = 0; m < maxSize; m++){
                System.out.print(grid[m][n]);
            }
            System.out.println();
        }
        System.out.println();

        floodfill(grid, 0, 0);
        System.out.println(count);
    }

    public static void floodfill(char[][] topView, int x, int y){

        int l = 0;
        if(x > 0 && topView[x-1][y] == '@'){
            count++;
            l++;
        }
        if(y > 0 && topView[x][y-1] == '@'){
            count++;
            l++;
        }
        if(x < maxSize && topView[x+1][y] == '@'){
            count++;
            l++;
        }
        if(y < maxSize && topView[x][y+1] == '@'){
            count++;
            l++;
        }
        if(l > 0) {
            topView[x][y] = (char) (l + '0');
        }

        int[][] possibleNextPositions = {
                {x+1, y},
                {x-1, y},
                {x, y+1},
                {x, y-1},
        };
        int q = 0;
        for(int[] nextPos : possibleNextPositions){
            if(
                    nextPos[0] >= 0 &&
                    nextPos[0] < maxSize &&
                    nextPos[1] >= 0 &&
                    nextPos[1] < maxSize &&
                    topView[nextPos[0]][nextPos[1]] != '@' &&
                    topView[nextPos[0]][nextPos[1]] != '`' &&
                    topView[nextPos[0]][nextPos[1]] != '1' &&
                    topView[nextPos[0]][nextPos[1]] != '2' &&
                    topView[nextPos[0]][nextPos[1]] != '3' &&
                    topView[nextPos[0]][nextPos[1]] != '4'
            ){
                topView[nextPos[0]][nextPos[1]] = '`';

//                for(int n = 0; n < maxSize; n++){
//                    for(int m = 0; m < maxSize; m++){
//                        System.out.print(topView[m][n]);
//                    }
//                    System.out.println();
//                }
//                System.out.println();
                q++;
                floodfill(topView, nextPos[0], nextPos[1]);
            }
        }
        if(q == 0){
            for(int n = 0; n < maxSize; n++){
                for(int m = 0; m < maxSize; m++){
                    System.out.print(topView[m][n]);
                }
                System.out.println();
            }
            System.out.println();
        }

    }
}
