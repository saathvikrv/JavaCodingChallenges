package org.usacoProbs;

import java.util.Scanner;
import java.util.Stack;

public class problem86 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int ops = s.nextInt();
        Stack<Integer> storage = new Stack<>();
        int num = 1;
        for(int i =0; i < ops; i++){
            if(s.next().equals("ADD")){
                storage.push(num);
                num++;
            } else {
                storage.pop();
            }
        }
        int[] numbers = new int[storage.size()];
        for(int i =storage.size()-1; i >= 0; i--){
           numbers[i] = storage.pop();
        }
        System.out.println(numbers.length);
        for(int number : numbers){
            System.out.println(number);
        }
    }
}
