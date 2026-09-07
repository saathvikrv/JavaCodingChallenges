package org.usacoProbs;

import java.util.Arrays;
import java.util.Scanner;

public class LaddersV2 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int moves = s.nextInt();
        String sequence = s.next();
        int maxX = 0;
        int minX = 0;
        int maxY = 0;
        int minY = 0;
        int x = 0;
        int y = 0;
        for(int i =0; i < moves; i++){
            if(sequence.charAt(i) == 'N') y++;
            else if(sequence.charAt(i) == 'S') y--;
            else if(sequence.charAt(i) == 'E') x++;
            else if(sequence.charAt(i) == 'W') x--;

            maxX = Math.max(maxX, x);
            maxY = Math.max(maxY, y);
            minX = Math.min(minX, x);
            minY = Math.min(minY, y);
        }

        char[][] grid = new char[(maxX - minX) * 2 + 3][(maxY - minY) * 2 + 3];

        int xStart = minX * -2 + 1;
        int yStart = minY * -2 + 1;


        for(char[] N : grid){
            Arrays.fill(N, '.');
        }

        x = xStart;
        y = yStart;
        grid[x][y] = '#';
        for(int i =0; i < moves; i++){
            char c = sequence.charAt(i);
            if(c == 'N'){
                grid[x][y+1] = '#';
                y+=2;
            } else if(c == 'S'){
                grid[x][y-1] = '#';
                y-=2;
            } else if(c == 'E'){
                grid[x+1][y] = '#';
                x+=2;
            } else if(c == 'W'){
                grid[x-1][y] = '#';
                x-=2;
            }
            grid[x][y] = '#';
        }

//        for(char[] N : grid){
//            System.out.println(Arrays.toString(N));
//        }
        int count = -1;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '.') {
                    grid[i][j] = '@';
                    count++;
                    floodfill(grid, i, j);
//                    for(char[] N : grid){
//                        System.out.println(Arrays.toString(N));
//                    }
//                    System.out.println('\n');
                }
            }
        }
        System.out.println(count);
    }

    public static void floodfill(char[][] topView, int x, int y){

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
                    topView[nextPos[0]][nextPos[1]] != '@' &&
                    topView[nextPos[0]][nextPos[1]] != '#'
            ){
                topView[nextPos[0]][nextPos[1]] = '@';

//                for(int n = 0; n < topView[0].length; n++){
//                    for(int m = 0; m < topView.length; m++){
//                        System.out.print(topView[m][n]);
//                    }
//                    System.out.println();
//                }
//                System.out.println();

                floodfill(topView, nextPos[0], nextPos[1]);
            }
        }


    }
}

/*

14
SSEENWWWNEESSS

  #####
  # # #
  #######
    # # #
    #####
      #
      #
 N A E
 W S W N
   S E E
     S
 */