package org.usacoProbs;

import java.util.Scanner;

public class WorldDomination {
    public static int area = 0;
    public static int perimeter = 0;

    public static void fillContinent(char[][] topView, int y, int x, boolean[][] filled){
        if(x > 0 && (topView[x-1][y] == '.' || topView[x-1][y] == '\u0000')){
            perimeter++;
        }
        if(y > 0 && (topView[x][y-1] == '.' || topView[x][y-1] == '\u0000')){
            perimeter++;
        }
        if(x < topView.length-1 && (topView[x+1][y] == '.' || topView[x+1][y] == '\u0000')){
            perimeter++;
        }
        if(y < topView[0].length-1 && (topView[x][y+1] == '.' || topView[x][y+1] == '\u0000')){
            perimeter++;
        }

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
                    topView[nextPos[0]][nextPos[1]] != '.' &&
                    topView[nextPos[0]][nextPos[1]] != '\u0000' &&
                    !filled[nextPos[0]][nextPos[1]]
            ){
                filled[nextPos[0]][nextPos[1]] = true;
                topView[nextPos[0]][nextPos[1]] = '@';

//                for(int n = 0; n < topView[0].length; n++){
//                    for (char[] chars : topView) {
//                        System.out.print(chars[n]);
//                    }
//                    System.out.println();
//                }
//                System.out.println();

                area++;
                fillContinent(topView, nextPos[1], nextPos[0], filled);
            }
        }
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int size = s.nextInt();

        char[][] grid = new char[size + 2][size + 2];
        boolean[][] filled = new boolean[size + 2][size + 2];
        s.nextLine();
        int maxArea = 0;
        int maxPerimeter = 0;
        for(int i =1; i < size+1; i++){
            String line = s.nextLine();
            for(int j =1; j < size + 1; j++){
                grid[j][i] = line.charAt(j-1);
            }
        }

        for(int i = 1; i < size + 1; i++){
            for(int j = 1; j < size + 1; j++){
                if(grid[j][i] == '#'){
//                    System.out.println("\nNew Continent: \n");
                    area = 1;
                    perimeter = 0;
                    filled[j][i] = true;
                    grid[j][i] = '@';
                    fillContinent(grid, i, j, filled);
                    if(area > maxArea){
                        maxArea = area;
                        maxPerimeter = perimeter;
                    } else if(area == maxArea){
                        maxPerimeter = Math.max(perimeter, maxPerimeter);
                    }
                }
            }
        }
        System.out.print(maxArea + " ");
        System.out.println(maxPerimeter);
    }
}
