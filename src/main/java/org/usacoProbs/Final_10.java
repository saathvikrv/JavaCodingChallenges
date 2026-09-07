package org.usacoProbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Final_10 {


    public static void main(String[] args) throws IOException {
        int[][] grid = new int[301][301];

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(r.readLine());

        int impacts = Integer.parseInt(st.nextToken());
        for(int i = 0; i < impacts; i++){
            st = new StringTokenizer(r.readLine());
            impact(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())+1, grid);
        }

        System.out.println(BFS(grid, 0, 0));
    }

    public static void impact(int x, int y, int time, int[][] grid){
        final int[][] POSITIONS = {
                {x, y},
                {x+1, y},
                {x-1, y},
                {x, y+1},
                {x, y-1},
        };

        for(int[] nextPos : POSITIONS){
            if(nextPos[0] >= 0 && nextPos[1] >= 0 && (grid[nextPos[0]][nextPos[1]] == 0 || grid[nextPos[0]][nextPos[1]] > time)){
                grid[nextPos[0]][nextPos[1]] = time;
            }
        }
    }

    public static int BFS(int[][] grid, int startX, int startY){
        int[][] steps = new int[grid.length][grid[0].length];
        for(int[] row : steps) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        steps[startX][startY] = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY});// add the starting index

        while(!q.isEmpty()) {
            // search the elements for the current step
            int[] x = q.poll();
            // if reached to N th element, write the answer and exit the program
            if(grid[x[0]][x[1]] == 0) {
                return steps[x[0]][x[1]]-1;
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
                                (grid[nextIndex[0]][nextIndex[1]] > steps[x[0]][x[1]]+1 || grid[nextIndex[0]][nextIndex[1]] == 0)
                ){
                    steps[nextIndex[0]][nextIndex[1]] = steps[x[0]][x[1]] + 1;

                    q.add(nextIndex);
                }
            }
        }
        return -1;
    }
}
