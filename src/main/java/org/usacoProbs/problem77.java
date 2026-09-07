package org.usacoProbs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class problem77 {
    public static int[] x;
    public static int[] y;
    public static int xSize;
    public static int ySize;


    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        ySize = s.nextInt();
        xSize = s.nextInt();
        x = new int[xSize * ySize];
        y = new int[xSize * ySize];
        Integer[] order = new Integer[xSize * ySize];
        int n = 0;
        for(int i =0; i < xSize; i++){
            for(int j =0; j < ySize; j++){
                x[n] = i;
                y[n] = j;
                order[n] = n;
                n ++;
            }
        }
        Arrays.sort(order, new comp());
        int[][] grid = new int[xSize][ySize];
        for(int i =0; i < order.length; i++){
            grid[x[order[i]]][y[order[i]]] = i+1;
        }

        for(int i = 0; i < xSize; i++){
            for(int j = 0; j < ySize; j++){
                System.out.print(grid[i][j]);
                if(j < ySize -1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }

    private static class comp implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            int x1 = problem77.x[o1];
            int x2 = problem77.x[o2];

            int y1 = problem77.y[o1];
            int y2 = problem77.y[o2];

            int aDist = dist(x1, problem77.xSize-1, y1, problem77.ySize/2);
            int bDist = dist(x2, problem77.xSize-1, y2, problem77.ySize/2);

            if(aDist == bDist){
                if(x1 == x2){
                    return Integer.compare(y1, y2);
                } else {
                    return Integer.compare(x1, x2) * -1;
                }
            } else {
                return Integer.compare(aDist, bDist);
            }
        }

        private static int dist(int x1, int x2, int y1, int y2){
            return (int) Math.pow(x1-x2, 2) + (int) Math.pow(y1-y2, 2);
        }
    }

}
