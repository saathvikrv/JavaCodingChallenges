package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class problem28 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int width = s.nextInt();
        int length = s.nextInt();

        s.nextLine();

        String q;



        char[][] grid = new char[width][length];
        /*{
                {'.','.','.','.','.','.','#','.'},
                {'.','#','.','.','.','#','.','.'},
                {'.','#','.','.','.','.','.','#'},
                {'.','.','.','#','#','.','.','#'},
                {'#','.','.','.','.','.','.','.'},
                {'.','#','.','.','#','.','#','#'}
        };*/

        for(int i = 0; i < width; i++){
            q = s.nextLine();
            for(int j = 0; j < length; j++){
                grid[i][j] = q.charAt(j);
            }
        }

        boolean[][] puddleLog = new boolean[grid.length][grid[0].length];
        for(boolean[] row : puddleLog) {
            Arrays.fill(row, false);
        }

        int count = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j =0; j < grid[0].length; j++){
                if(!puddleLog[i][j]){
                    if(grid[i][j] == '#'){
                        puddleLog[i][j] = true;
                        if(i > 0){
                            if(grid[i-1][j] == '#'){
                                puddleLog[i-1][j] = true;
                            }
                        }
                        if(i < grid.length-1){
                            if(grid[i+1][j] == '#'){
                                puddleLog[i+1][j] = true;
                            }
                        }
                        if(j > 0){
                            if(grid[i][j-1] == '#'){
                                puddleLog[i][j-1] = true;
                            }
                        }
                        if(j < grid[0].length-1){
                            if(grid[i][j+1] == '#'){
                                puddleLog[i][j+1] = true;
                            }
                        }
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
