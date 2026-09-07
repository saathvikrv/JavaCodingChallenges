package org.usacoProbs;

import java.util.HashMap;
import java.util.Scanner;

public class problem72 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int assignments = s.nextInt();
        int cows = s.nextInt();

        String[][] rankings = new String[assignments][cows];
        HashMap<String, Integer> order = new HashMap<>();
        for(int i =0; i < cows; i++){
            order.put(s.next(), i);
        }
        for(int j =0; j < assignments; j++){
            for(int i =0; i < cows; i++){
                rankings[j][i] = s.next();
            }
        }

        int[][] cowPoses = new int[rankings[0].length][rankings.length];

        for(int i =0; i < rankings.length; i++){
            for(int j = 0; j < rankings[0].length; j++){
                cowPoses[order.get(rankings[i][j])][i] = j;
            }
        }


        char[][] relations = new char[rankings[0].length][rankings[0].length];
        for(int i =0; i < relations.length; i++){
            relations[i][i] = 'B';
        }

        for(int i = 0; i < relations.length-1; i++){
            for(int j = i+1; j < relations.length; j++){
                relations[i][j] = compareCows(cowPoses[i], cowPoses[j], rankings);
            }
        }

        for(int i = 0; i < relations.length-1; i++){
            for(int j = i+1; j < relations.length; j++){
                if(relations[i][j] == '1'){
                    relations[j][i] = '0';
                } else if(relations[i][j] == '0'){
                    relations[j][i] = '1';
                } else if(relations[i][j] == '?'){
                    relations[j][i] = '?';
                }
            }
        }

        for(int i = 0; i < relations.length; i++){
            for(int j = 0; j < relations.length; j++){
                System.out.print(relations[i][j]);
            }
            System.out.println();
        }
     }

    public static char compareCows(int[] cow1, int[] cow2, String[][] rankings){
        String cow1Name = rankings[0][cow1[0]];
        String cow2Name = rankings[0][cow2[0]];
        boolean cow1First = cow1Name.compareToIgnoreCase(cow2Name) < 0; // IDK if correct
        for(int i = 0; i < cow1.length; i++){
            if(cow1[i] < cow2[i] && !cow1First){
                return '0';
            } else if(cow2[i] < cow1[i] && cow1First){
                return '1';
            } else if(cow1First){
                for(int c = Math.min(cow1[i],cow2[i])+1; c < Math.max(cow1[i],cow2[i]); c++){
                    if(cow1Name.compareToIgnoreCase(rankings[i][c]) > 0 || rankings[i][c].compareToIgnoreCase(cow2Name) > 0){
                        return '0';
                    }
                }
            } else {
                for(int c = Math.min(cow1[i],cow2[i])+1; c < Math.max(cow1[i],cow2[i]); c++){
                    if(cow1Name.compareToIgnoreCase(rankings[i][c]) < 0 || rankings[i][c].compareToIgnoreCase(cow2Name) < 0){
                        return '1';
                    }
                }
            }
        }
        return '?';
    }
}
