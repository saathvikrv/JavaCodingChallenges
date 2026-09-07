package org.usacoProbs;

import java.util.Arrays;
import java.util.Scanner;

public class Final_5 {
    public static void  main(String[] args){
        Scanner s = new Scanner(System.in);
        int fieldSize = s.nextInt();
        String line;
        int[][] field = new int[fieldSize][fieldSize];
        for(int i =0; i < fieldSize; i++){
            line = s.next();
            for(int j =0; j < fieldSize; j++){
                field[i][j] = line.charAt(j) - '0';
            }
        }


        int currCow;
        int[][] cowInfo = new int[9][5];
        for(int[] row : cowInfo){
            Arrays.fill(row, 0);
        }

//        each row: {if cow print present, cow x max, cow y max, cow x min, cow y min}
        for(int row = 0; row < field.length; row++){
            for(int column = 0; column < field.length; column++){
                currCow = field[row][column];
                if(currCow != 0) {
                    if (cowInfo[currCow - 1][0] == 0) {
                        cowInfo[currCow - 1][0] = 1;
                        cowInfo[currCow - 1][1] = row;
                        cowInfo[currCow - 1][2] = column;
                        cowInfo[currCow - 1][3] = row;
                        cowInfo[currCow - 1][4] = column;
                    } else {
                        if (row > cowInfo[currCow - 1][1]) {
                            cowInfo[currCow - 1][1] = row;
                        }
                        if (row < cowInfo[currCow - 1][3]) {
                            cowInfo[currCow - 1][3] = row;
                        }
                        if (column > cowInfo[currCow - 1][2]) {
                            cowInfo[currCow - 1][2] = column;
                        }
                        if (column < cowInfo[currCow - 1][4]) {
                            cowInfo[currCow - 1][4] = column;
                        }
                    }
                }
            }
        }

        boolean[] grazedFirst = new boolean[9];
        Arrays.fill(grazedFirst, true);

        for(int cow = 0; cow < cowInfo.length; cow++){
            int[] currCowInfo = cowInfo[cow];
            if(currCowInfo[0] == 1) {
                for (int row = currCowInfo[3]; row <= currCowInfo[1]; row++) {
                    for (int column = currCowInfo[4]; column <= currCowInfo[2]; column++) {
                        if(field[row][column] != cow + 1){
                            grazedFirst[field[row][column]-1] = false;
                        }
                    }
                }
            } else {
                grazedFirst[cow] = false;
            }
        }

        int count = 0;
        for(boolean possible : grazedFirst){
            if(possible){
                count++;
            }
        }

        System.out.println(count);
        //System.out.println(Arrays.toString(grazedFirst));
    }
}
