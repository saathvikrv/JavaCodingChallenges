package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class problem34 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        int y = s.nextInt();
        char[][] grid = new char[x][y];
        int scale = s.nextInt();
        String line;
        s.nextLine();
        for(int i = 0; i < grid.length; i++){
            line = s.nextLine();
            for(int j = 0; j < grid[0].length; j++){
                grid[i][j] = line.charAt(j);
            }
        }
        System.out.println(Arrays.deepToString(grid));
        enlarge(grid, 2);
    }

    public static void enlarge(char[][] grid, int scale){
        char[][] res = new char[grid.length*scale][grid[0].length*scale];
        for(char[] row : res){
            Arrays.fill(row, 'X');
        }
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '.'){
                    for(int n = 0; n < scale; n++){
                        for(int m = 0; m < scale; m++){
                            res[scale*i+n][scale*j+m] = '.';
                        }
                    }
                }
            }
        }
        for(char[] n : res){
            for(char m : n) {
                System.out.print(m);
            }
            System.out.println();
        }
    }
}
