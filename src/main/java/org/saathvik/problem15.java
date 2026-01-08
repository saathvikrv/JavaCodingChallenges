package org.example;

import java.util.HashMap;
import java.util.Scanner;

public class problem15 {
    public static HashMap<Character, Integer> createFreqTable(){
        HashMap<Character, Integer> digits = new HashMap<>();
        digits.put('0', 0);
        digits.put('1', 0);
        digits.put('2', 0);
        digits.put('3', 0);
        digits.put('4', 0);
        digits.put('5', 0);
        digits.put('6', 0);
        digits.put('7', 0);
        digits.put('8', 0);
        digits.put('9', 0);

        return digits;

    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int start = s.nextInt();
        int end = s.nextInt();
        StringBuilder nums = new StringBuilder(Integer.toString(start));
        for(int i = start + 1; i < end +1; i++){
            nums.append(i);
        }

        HashMap<Character, Integer> digits = createFreqTable();
        char currentChar;
        for(int i = 0; i < nums.length(); i++){
            currentChar = nums.charAt(i);
            digits.put(currentChar, digits.get(currentChar)+1);
        }
        System.out.print(digits.get('0')+" ");
        System.out.print(digits.get('1')+" ");
        System.out.print(digits.get('2')+" ");
        System.out.print(digits.get('3')+" ");
        System.out.print(digits.get('4')+" ");
        System.out.print(digits.get('5')+" ");
        System.out.print(digits.get('6')+" ");
        System.out.print(digits.get('7')+" ");
        System.out.print(digits.get('8')+" ");
        System.out.print(digits.get('9'));

    }
}
