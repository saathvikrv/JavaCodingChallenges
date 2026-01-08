package org.example;

import java.util.Scanner;

public class problem31 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int[][] grid = new int[size][size];
        s.nextLine();
        String line;
        for(int i = 0; i < size; i++){
            line = s.nextLine();
            for(int j = 0; j < size; j++){
                grid[i][j] = Integer.parseInt(line.charAt(j)+"");
            }
        }
        //System.out.println("done");

        boolean flipped = false;
        int[] xy;
        int count = 0;

        while(!flipped){
            xy = findClosestToBR(grid);
            if(xy.length == 1){
                flipped = true;
            } else {
                grid = flipRegion(grid, xy[0], xy[1]);
                count++;
            }
        }
        System.out.println(count);

    }




    public static int[][] flipRegion(int[][] arr, int x, int y){
        int n=0;
        for(int i = 0; i <= x; i++){
            for(int j = 0; j <= y; j++){
                arr[i][j] = Math.abs(arr[i][j] -1);
                n += 3;
            }

        }
        return arr;
    }


    public static int[] findClosestToBR(int[][] arr){
        int size = arr.length;
        for(int i = size*2-2; i >=0; i--){
            for(int j = 0; j <= i; j++){
                while(i-j >= size){
                    j++;
                }
                if(j >=size){
                    break;
                }

                if(arr[j][i-j] == 1){
                    int n = i - j;
                    //System.out.println(j+", "+n);
                    return new int[]{j, i-j};
                }
            }
        }
        //System.out.println();
        return new int[]{-1};
    }
}
