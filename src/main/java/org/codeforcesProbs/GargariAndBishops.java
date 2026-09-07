package org.codeforcesProbs;

import java.util.Arrays;
import java.util.Scanner;

public class GargariAndBishops {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int[][] grid = new int[size][size];

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                grid[i][j] = s.nextInt();
            }
        }
        int[] sums1 = new int[size * 2 -1];
        int n = 0;
        for(int i = 0; i < size; i++){
            for(int j = 0; i - j >= 0 && j < size; j++){
                sums1[n] += grid[i-j][j];
            }
            n++;
        }
        for(int i = 1; i < size; i++){
            for(int j = 0; i+j < size; j++){
                sums1[n] += grid[i+j][size - j - 1];
            }
            n++;
        }

        System.out.println(Arrays.toString(sums1));

        int[] sums2 = new int[size * 2 -1];
        n = 0;
        for(int i = size -1; i >= 0; i--){
            for(int j = 0; i + j < size; j++){
                sums2[n] += grid[j][i+j];
            }
            n++;
        }

        for(int i = size - 2; i >= 0; i--){
            for(int j = 0; i - j >= 0 && j < size; j++){
                sums2[n] += grid[size - 1 - j][i-j];
            }
            n++;
        }

        System.out.println(Arrays.toString(sums2));
    }
}
