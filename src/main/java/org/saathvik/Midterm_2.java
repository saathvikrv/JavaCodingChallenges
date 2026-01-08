package org.example;

import java.util.HashMap;
import java.util.Scanner;

public class Midterm_2 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String cowphabet = s.nextLine();
        String wordsUttered = s.nextLine();
        HashMap<Character, Integer> alphabetOrder = new HashMap<>();
        for(int i = 0; i < 26; i++){
            alphabetOrder.put(cowphabet.charAt(i), i);
        }
        int maxReps = 1;
        int a;
        int b;

        for(int i = 1; i < wordsUttered.length(); i++){
            a = alphabetOrder.get(wordsUttered.charAt(i-1));
            b = alphabetOrder.get(wordsUttered.charAt(i));
            if(a >= b){
                maxReps++;
            }
        }
        System.out.println(maxReps);
    }
}
