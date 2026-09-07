package org.usacoProbs;

import java.util.Arrays;
import java.util.Scanner;

public class problem78 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int len = s.nextInt();
        int boxes = s.nextInt();
        int[] cards = new int[len];
        int[] boxList = new int[boxes];
        for(int i =0; i < len; i++){
            cards[i] = s.nextInt();
        }
        Arrays.sort(cards);
        for(int i = cards[cards.length-1]; i > 1; i--){

        }

    }
}
/*
(a-b)x+b(n)
 */
