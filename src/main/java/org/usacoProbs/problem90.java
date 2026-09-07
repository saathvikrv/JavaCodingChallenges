package org.usacoProbs;

import java.util.Arrays;
import java.util.Scanner;

public class problem90 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();

        char[] wordSorted = s.toCharArray();
        Arrays.sort(wordSorted);
        char[] word = s.toCharArray();

        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < s.length(); j++){
                if(wordSorted[j] == word[i]){
                    word[i] = (char) (j + 48);
                }
            }
        }

        long factorialSize = word.length-1;
        long acc = 0;
        for(int i = 0; i < word.length; i++){
            acc += ((long) word[i] - 48) * getFactorial(factorialSize);
            factorialSize--;
            for(int j =i; j < word.length; j++){
                if(word[j] > word[i]){
                    word[j] = (char) ((int) word[j] - 1);
                }
            }
        }

        System.out.println(acc % 1000000007L);
    }

    public static long getFactorial(long a){
        if(a == 1){
            return 1;
        }
        if(a == 0){
            return 0;
        }

        return a * getFactorial(a-1);

    }
}
