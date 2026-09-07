package org.usacoProbs;

import java.util.Arrays;
import java.util.Scanner;

public class _TestProject {


    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int[][] board = new int[size][size];

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                board[i][j] = s.nextInt();
            }
        }
        char[][] grid = new char[size][size];
        for(char[] row : grid){
            Arrays.fill(row, '.');
        }

        for(int i = 0; i < size; i++){
            for(int j = 0; i - j >= 0 && j < size; j++){
                grid[i-j][j] = '#';
                for(char[] row : grid){
                    System.out.println(Arrays.toString(row));
                }
                System.out.println();
            }
        }
    }
}
