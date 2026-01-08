package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class problem29 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int[][] bookPlacements = new int[s.nextInt()][2];

        for(int [] place : bookPlacements){
            place[0] = s.nextInt();
            place[1] = s.nextInt();
        }

        int max_x = 0;
        int max_y = 0;
        int x;
        int y;

        int wellPlacedCurrent = 0;

        for(int[] placement : bookPlacements){
            if(placement[0] > max_x){
                max_x = placement[0];
            }
            if(placement[1] > max_y){
                max_y = placement[1];
            }
        }

        boolean[][] shelf = new boolean[max_x+1][max_y+1];

        boolean[][] well = new boolean[max_x+1][max_y+1];

        for(int i = 0; i <= max_y; i++){
            Arrays.fill(shelf[i], false);
            Arrays.fill(well[i], false);
        }

        for(int[] placement : bookPlacements){
            shelf[placement[0]][placement[1]] = true;
            if(checkWell(shelf, placement[0], placement[1]) == 3){
                wellPlacedCurrent++;
                well[placement[0]][placement[1]] = true;
            }

            x = placement[0]+1;
            y = placement[1];

            if(checkWell(shelf, x, y) == 3){
                if(!well[x][y]){
                    well[x][y] = true;
                    wellPlacedCurrent++;
                }
            } else if(checkWell(shelf, x, y) == 4){
                if(well[x][y]){
                    well[x][y] = false;
                    wellPlacedCurrent--;
                }
            }

            x = placement[0]-1;

            if(checkWell(shelf, x, y) == 3){
                if(!well[x][y]){
                    well[x][y] = true;
                    wellPlacedCurrent++;
                }
            } else if(checkWell(shelf, x, y) == 4){
                if(well[x][y]){
                    well[x][y] = false;
                    wellPlacedCurrent--;
                }
            }

            x = placement[0];
            y = placement[1]-1;

            if(checkWell(shelf, x, y) == 3){
                if(!well[x][y]){
                    well[x][y] = true;
                    wellPlacedCurrent++;
                }
            } else if(checkWell(shelf, x, y) == 4){
                if(well[x][y]){
                    well[x][y] = false;
                    wellPlacedCurrent--;
                }
            }

            y = placement[1]+1;

            if(checkWell(shelf, x, y) == 3){
                if(!well[x][y]){
                    well[x][y] = true;
                    wellPlacedCurrent++;
                }
            } else if(checkWell(shelf, x, y) == 4){
                if(well[x][y]){
                    well[x][y] = false;
                    wellPlacedCurrent--;
                }
            }


//            if(!well[placement[0]][placement[1]+1]){
//                if(checkWell(shelf, placement[0], placement[1]+1)){
//                    wellPlacedCurrent++;
//                    well[placement[0]][placement[1]+1] = true;
//                }
//            } else {
//                if(!checkWell(shelf, placement[0], placement[1]+1)){
//                    wellPlacedCurrent--;
//                    well[placement[0]][placement[1]+1] = false;
//                }
//            }
//
//
//            if(!well[placement[0]][placement[1]-1]){
//                if(checkWell(shelf, placement[0], placement[1]-1)){
//                    wellPlacedCurrent++;
//                    well[placement[0]][placement[1]-1] = true;
//                }
//            } else {
//                if(!checkWell(shelf, placement[0], placement[1]-1)){
//                    wellPlacedCurrent--;
//                    well[placement[0]][placement[1]-1] = false;
//                }
//            }
//
//
//            if(!well[placement[0]+1][placement[1]]){
//                if(checkWell(shelf, placement[0]+1, placement[1])){
//                    wellPlacedCurrent++;
//                    well[placement[0]+1][placement[1]] = true;
//                }
//            } else {
//                if(!checkWell(shelf, placement[0]+1, placement[1])){
//                    wellPlacedCurrent--;
//                    well[placement[0]+1][placement[1]] = false;
//                }
//            }
//
//
//            if(!well[placement[0]-1][placement[1]]){
//                if(checkWell(shelf, placement[0]-1, placement[1])){
//                    wellPlacedCurrent++;
//                    well[placement[0]-1][placement[1]] = true;
//                }
//            } else {
//                if(!checkWell(shelf, placement[0]-1, placement[1])){
//                    wellPlacedCurrent--;
//                    well[placement[0]-1][placement[1]] = false;
//                }
//            }
            System.out.println(wellPlacedCurrent);

            for(boolean[] q : shelf){
                for(boolean w : q){
                    if(w){
                        System.out.print(" #");
                    } else {
                        System.out.print(" -");
                    }
                }
                System.out.println();
            }
        }

    }

    public static int checkWell(boolean[][] shelf, int xCor, int yCor){
        int adj = 0;

        if(xCor < 0 || yCor < 0 || xCor > shelf.length-1 || yCor > shelf[0].length-1){
            return -1;
        }
        if(!shelf[xCor][yCor]){
            return -1;
        }


        if(xCor < shelf.length-1) {
            if (shelf[xCor + 1][yCor]) {
                adj++;
            }
        }

        if(yCor < shelf[0].length-1) {
            if (shelf[xCor][yCor + 1]) {
                adj++;
            }
        }
        if(yCor > 0) {
            if (shelf[xCor][yCor - 1]) {
                adj++;
            }
        }

        if(xCor > 0) {
            if (shelf[xCor - 1][yCor]) {
                adj++;
            }
        }
        return adj;
    }


}
