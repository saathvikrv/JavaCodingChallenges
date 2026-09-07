package org.usacoProbs;

import java.util.Arrays;
import java.util.Scanner;

public class problem30 {
    public static char[][] rotateNinety(char[][] grid) {
        char[][] newGrid = new char[grid.length][grid.length];
        float h = (float) (grid.length-1) / 2;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid.length; j++){
                newGrid[j][(int) (2*h-i)]= grid[i][j];
            }
        }

        return newGrid;
    }

    public static char[][] rotateTwoSeventy(char[][] grid) {
        char[][] newGrid = new char[grid.length][grid.length];
        float h = (float) (grid.length-1) / 2;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid.length; j++){
                newGrid[(int) (2*h- j)][i]= grid[i][j];
            }
        }

        return newGrid;
    }

    public static char[][] rotateOneEighty(char[][] grid) {
        char[][] newGrid = new char[grid.length][grid.length];
        float h = (float) (grid.length-1) / 2;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid.length; j++){
                newGrid[(int) (2*h- i)][(int) (2*h- j)]= grid[i][j];
            }
        }

        return newGrid;
    }

    public static char[][] flip(char[][] grid) {
        char[][] newGrid = new char[grid.length][grid.length];
        float h = (float) (grid.length-1) / 2;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid.length; j++){
                newGrid[i][(int) (2*h- j)]= grid[i][j];
            }
        }

        return newGrid;
    }

    public static void main(String[] args){

        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        String line;

        char[][] grid = new char[size][size];
        char[][] res = new char[size][size];

        for(int i = 0; i < size; i++){
            line = s.nextLine();
            for(int j = 0; j < size; j++){
                grid[i][j] = line.charAt(j);
            }
        }

        for(int i = 0; i < size; i++){
            line = s.nextLine();
            for(int j = 0; j < size; j++){
                res[i][j] = line.charAt(j);
            }
        }


        if(Arrays.deepEquals(rotateNinety(grid),res)){
            System.out.println('1');
        } else if(Arrays.deepEquals(rotateOneEighty(grid),res)){
            System.out.println('2');
        } else if(Arrays.deepEquals(rotateTwoSeventy(grid),res)){
            System.out.println('3');
        } else if(Arrays.deepEquals(flip(grid),res)){
            System.out.println('4');
        } else if(Arrays.deepEquals(rotateNinety(flip(grid)),res)){
            System.out.println('5');
            //System.out.println('1');
        } else if(Arrays.deepEquals(rotateOneEighty(flip(grid)),res)){
            System.out.println('5');
            //System.out.println('2');
        } else if(Arrays.deepEquals(rotateTwoSeventy(flip(grid)),res)){
            System.out.println('5');
            //System.out.println('3');
        } else if(Arrays.deepEquals(grid,res)){
            System.out.println('6');
        } else {
            System.out.println('7');
        }
    }
}