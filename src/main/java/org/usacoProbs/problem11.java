package org.usacoProbs;

import java.util.Scanner;

public class problem11 {

    public static void main(String[] args){
        Scanner s= new Scanner(System.in);
        int lines = s.nextInt();
        int[][] swaps = new int[lines][2];
        int[] guesses = new int[lines];
        for(int i = 0; i < lines; i++){
            swaps[i][0] = s.nextInt();
            swaps[i][1] = s.nextInt();
            guesses[i] = s.nextInt();
        }
        int cardLoc = 1;
        int[] swap;
        int score1 =0;

        for(int i = 0; i < lines; i++){
           swap = swaps[i];

           if(swap[0] == cardLoc){
               cardLoc = swap[1];
           } else if(swap[1] == cardLoc){
               cardLoc = swap[0];
           }

           if(guesses[i] == cardLoc){
               score1 += 1;
           }
        }
        int score2 = 0;
        cardLoc = 2;

        for(int i = 0; i < lines; i++){
            swap = swaps[i];

            if(swap[0] == cardLoc){
                cardLoc = swap[1];
            } else if(swap[1] == cardLoc){
                cardLoc = swap[0];
            }

            if(guesses[i] == cardLoc){
                score2 += 1;
            }
        }

        int score3 = 0;
        cardLoc = 3;

        for(int i = 0; i < lines; i++){
            swap = swaps[i];

            if(swap[0] == cardLoc){
                cardLoc = swap[1];
            } else if(swap[1] == cardLoc){
                cardLoc = swap[0];
            }

            if(guesses[i] == cardLoc){
                score3 += 1;
            }
        }

        System.out.println(Math.max(score1, Math.max(score2, score3)));
    }
}
