package org.usacoProbs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HarvestSeason {
    public static int count;

    public static void generate(int[] aPos, int[] bPos, boolean[][] unpicked, int emptyFields){
        System.out.println("Empty Fields:" + emptyFields);
        for(int i = 0; i < unpicked.length; i++){
            for(int j = 0; j < unpicked.length; j++){
                if(aPos[0] == i && aPos[1] == j){
                    System.out.print("A ");
                } else if(bPos[0] == i && bPos[1] == j){
                    System.out.print("B ");
                } else if(!unpicked[i][j]){
                    System.out.print("_ ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
        System.out.println();

        ArrayList<int[]> aMoves = aMoves(aPos, unpicked);

        ArrayList<int[]> bMoves = bMoves(bPos, unpicked);

        if(Arrays.equals(aPos, bPos) || emptyFields == 24){
            return;
        } else if(emptyFields == unpicked.length * unpicked.length - 3 && aMoves.size() == 1 && bMoves.size() == 1){
            count++;
            System.out.println("Found a Way");
            return;
        }

        for(int[] aMove : aMoves){
            for(int[] bMove : bMoves){
                unpicked[aMove[0]][aMove[1]] = true;
                unpicked[bMove[0]][bMove[1]] = true;
                generate(aMove, bMove, unpicked, emptyFields+2);
                unpicked[aMove[0]][aMove[1]] = false;
                unpicked[bMove[0]][bMove[1]] = false;
            }
        }
    }

    public static ArrayList<int[]> aMoves(int[] aPos, boolean[][] unpicked){
        ArrayList<int[]> aMoves = new ArrayList<>();
        if(aPos[0] > 0 && !unpicked[aPos[0] - 1][aPos[1]]){
            aMoves.add(new int[]{aPos[0] - 1, aPos[1]});
        }
        if(aPos[1] > 0 && !unpicked[aPos[0]][aPos[1] - 1]){
            aMoves.add(new int[]{aPos[0], aPos[1] - 1});
        }
        if(aPos[0] < unpicked.length-1 && !unpicked[aPos[0] + 1][aPos[1]]){
            aMoves.add(new int[]{aPos[0] + 1, aPos[1]});
        }
        if(aPos[1] < unpicked.length-1 && !unpicked[aPos[0]][aPos[1] + 1]){
            aMoves.add(new int[]{aPos[0], aPos[1] + 1});
        }
        return aMoves;
    }

    public static ArrayList<int[]> bMoves(int[] bPos, boolean[][] unpicked){
        ArrayList<int[]> bMoves = new ArrayList<>();
        if(bPos[0] > 0 && !unpicked[bPos[0] - 1][bPos[1]]){
            bMoves.add(new int[]{bPos[0] - 1, bPos[1]});
        }
        if(bPos[1] > 0 && !unpicked[bPos[0]][bPos[1] - 1]){
            bMoves.add(new int[]{bPos[0], bPos[1] - 1});
        }
        if(bPos[0] < unpicked.length-1 && !unpicked[bPos[0] + 1][bPos[1]]){
            bMoves.add(new int[]{bPos[0] + 1, bPos[1]});
        }
        if(bPos[1] < unpicked.length-1 && !unpicked[bPos[0]][bPos[1] + 1]){
            bMoves.add(new int[]{bPos[0], bPos[1] + 1});
        }
        return bMoves;
    }

    public static void main(String[] args){
        count = 0;

        int m = 5;

        boolean[][] n  = new boolean[m][m];
        n[0][0] = true;
        n[4][4] = true;

        Scanner s= new Scanner(System.in);
        int empty = s.nextInt();
        for(int i = empty; i > 0; i--){
            n[s.nextInt()-1][s.nextInt()-1] = true;
        }

        generate(new int[]{0, 0}, new int[]{4, 4}, n, empty);
        System.out.println(count);
    }
}
