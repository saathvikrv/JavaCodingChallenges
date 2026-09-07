package org.usacoProbs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CowbellRetrieval {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int width = s.nextInt();
        int height = s.nextInt();
        int startX = -1;
        int startY = -1;
        int endX = -1;
        int endY = -1;

        char[][] grid = new char[width][height];

        for(int i =0; i < width; i++){
            String str = s.next();
            for(int j =0; j < height; j++){
                grid[i][j] = str.charAt(j);
                if(grid[i][j] == 'B'){
                    startX = i;
                    startY = j;
                } else if(grid[i][j] == 'C'){
                    endX = i;
                    endY = j;
                }
            }
        }

        System.out.println(BFS(grid, startX, startY, endX, endY));

    }

    public static int BFS(char[][] grid, int startX, int startY, int endX, int endY){
        int[][] steps = new int[grid.length][grid[0].length];
        for(int[] row : steps) {
            Arrays.fill(row, -1);
        }
        steps[startX][startY] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY});          // add the starting index
        while(!q.isEmpty()) {
            // search the elements for the current step
            int[] x = q.poll();
            // if reached to N th element, write the answer and exit the program
            if(x[0] == endX && x[1] == endY) {
                return steps[x[0]][x[1]];
            }

            // make the moves, and update the valid and not visited elements
            int[][] moves = {
                    {x[0] + 1, x[1]},
                    {x[0] - 1, x[1]},
                    {x[0], x[1] + 1},
                    {x[0], x[1] - 1}
            };
            for(int[] nextIndex : moves) {
                if(
                        nextIndex[0] >= 0 &&
                                nextIndex[0] < steps.length &&
                                nextIndex[1] >= 0 &&
                                nextIndex[1] < steps[0].length &&
                                steps[nextIndex[0]][nextIndex[1]] == -1 &&
                                grid[nextIndex[0]][nextIndex[1]] != '*'
                ){
                    steps[nextIndex[0]][nextIndex[1]] = steps[x[0]][x[1]] + 1;
                    q.add(nextIndex);
                }
            }
        }
        return -1;
    }
}
