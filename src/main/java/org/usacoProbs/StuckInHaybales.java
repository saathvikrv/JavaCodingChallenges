package org.usacoProbs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StuckInHaybales {
    public static int maxX;
    public static int maxY;

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int bales = s.nextInt();
        int startX = s.nextInt();
        int startY = s.nextInt();
        maxX = 0;
        maxY = 0;
        char[][] grid = new char[1001][1001];

        for(int i =0; i < bales; i++){
            int x = s.nextInt();
            int y = s.nextInt();
            grid[x][y] = '@';
            maxX = Math.max(x, maxX);
            maxY = Math.max(y, maxY);
        }

        System.out.println(BFS(grid, startX, startY));

    }

    public static int BFS(char[][] grid, int startX, int startY){
        int[][] steps = new int[grid.length][grid[0].length];
        for(int[] row : steps) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        steps[startX][startY] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY});// add the starting index

        int ans = Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            // search the elements for the current step
            int[] x = q.poll();
            // if reached to N th element, write the answer and exit the program
            if(x[0] > maxX && x[1] > maxY) {
                ans = Math.min(steps[x[0]][x[1]], ans);
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
                                steps[nextIndex[0]][nextIndex[1]] > (grid[nextIndex[0]][nextIndex[1]] == '@' ? steps[x[0]][x[1]] + 1 : steps[x[0]][x[1]])
                ){
                    if(grid[nextIndex[0]][nextIndex[1]] == '@'){
                        steps[nextIndex[0]][nextIndex[1]] = steps[x[0]][x[1]] + 1;
                    } else {
                        steps[nextIndex[0]][nextIndex[1]] = steps[x[0]][x[1]];
                    }
                    q.add(nextIndex);
                }
            }
        }
        return ans;
    }
}

/*
4 2 2
2 1
1 2
2 3
4 2
10 10
..........
..***.....
..*.*.....
..*******.
....*****.
....**B**.
....*****.
....*****.
..........
..........
 */