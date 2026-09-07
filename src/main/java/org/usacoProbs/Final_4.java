package org.usacoProbs;

import java.util.HashMap;
import java.util.Scanner;

public class Final_4 {
    public static void main(String[] args){
        Scanner s= new Scanner(System.in);
        int numMatches = s.nextInt();
        int[][] matches = new int[numMatches][2];
        for(int i =0; i < numMatches; i++){
            matches[i][0] = s.nextInt();
            matches[i][1] = s.nextInt();
        }

        HashMap<Integer, Character> signs;

        signs = new HashMap<>();
        signs.put(1, 'h');
        signs.put(2, 's');
        signs.put(3, 'g');
        test(matches, signs);

        signs = new HashMap<>();
        signs.put(1, 'h');
        signs.put(2, 'g');
        signs.put(3, 's');
        test(matches, signs);

        signs = new HashMap<>();
        signs.put(1, 'g');
        signs.put(2, 'h');
        signs.put(3, 's');
        test(matches, signs);

        signs = new HashMap<>();
        signs.put(1, 'g');
        signs.put(2, 's');
        signs.put(3, 'h');
        test(matches, signs);

        signs = new HashMap<>();
        signs.put(1, 's');
        signs.put(2, 'g');
        signs.put(3, 'h');
        test(matches, signs);

        signs = new HashMap<>();
        signs.put(1, 's');
        signs.put(2, 'h');
        signs.put(3, 'g');
        test(matches, signs);
    }

    public static int test(int[][] games, HashMap<Integer, Character> signs){
        int count = 0;
        char cow1Symbol;
        char cow2Symbol;

        for(int[] match : games){
            cow1Symbol = signs.get(match[0]);
            cow2Symbol = signs.get(match[1]);
            if((cow1Symbol == 'h' && cow2Symbol == 's') || (cow1Symbol == 's' && cow2Symbol == 'g') || (cow1Symbol == 'g' && cow2Symbol == 'h')){
                count++;
            }
        }

        return count;
    }
}
