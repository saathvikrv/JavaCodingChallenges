package org.example;

import java.util.Scanner;

public class HW3 {
    public static void main(String[] args){
        String[] words;
        Scanner s = new Scanner(System.in);
        int numWords = s.nextInt();
        int charsPerLine = s.nextInt();
        words = new String[numWords];
        for(int i = 0; i < numWords; i++){
            words[i] = s.next();
        }

        StringBuilder currentLine = new StringBuilder();
        int lineLen = 0;

        for(String currentWord : words){
            if(currentLine.isEmpty()){
                currentLine.append(currentWord);
                lineLen = currentWord.length();
            }
            else if(currentWord.length() + lineLen <= charsPerLine ){
                currentLine.append(" ");
                currentLine.append(currentWord);
                lineLen += currentWord.length();

            } else {
                System.out.println(currentLine);
                currentLine = new StringBuilder(currentWord);
                lineLen = currentWord.length();
            }
        }
        System.out.println(currentLine);

    }


}
