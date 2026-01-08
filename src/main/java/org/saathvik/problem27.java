package org.example;

import java.util.HashMap;
import java.util.Scanner;

public class problem27 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        String answer = s.nextLine()+s.nextLine()+s.nextLine();
        String guess = s.nextLine()+s.nextLine()+s.nextLine();
        int correct = 0;
        int wrongPlace = 0;

        HashMap<Character, Integer> answerLetters = new HashMap<>();
        HashMap<Character, Integer> guessLetters = new HashMap<>();

        for(int i = 0; i < 9; i++){
            answerLetters.putIfAbsent(answer.charAt(i), 0);
            answerLetters.put(answer.charAt(i), answerLetters.get(answer.charAt(i))+1);

            guessLetters.putIfAbsent(answer.charAt(i), 0);

            guessLetters.putIfAbsent(guess.charAt(i), 0);
            guessLetters.put(guess.charAt(i), guessLetters.get(guess.charAt(i))+1);

            if(answer.charAt(i) == guess.charAt(i)){
                correct++;
            }
        }

        for(int i =0; i < 9; i++){
            if(guessLetters.get(answer.charAt(i)) > 0){
                guessLetters.put(answer.charAt(i), guessLetters.get(answer.charAt(i))-1);
                wrongPlace++;
            }
        }



        System.out.println(correct);

        System.out.println(wrongPlace-correct);




    }
}
