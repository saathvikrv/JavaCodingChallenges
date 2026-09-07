package org.usacoProbs;

import java.util.Scanner;
import java.util.Stack;

public class TestingHaybales {
    public static void main(String[] args){
        Stack<Integer> initialOrder = new Stack<>();
        Stack<Integer> middleOrder = new Stack<>();
        Stack<Integer> finalOrder = new Stack<>();

        Scanner s= new Scanner(System.in);
        int totalHaybales = s.nextInt();

        for(int i = totalHaybales; i > 0; i--){
            initialOrder.push(i);
        }


        int num = 0;
        int processed = 0;

        while(processed < totalHaybales *2){
            if(s.nextInt() == 1){
                num = s.nextInt();
                for(int i = s.nextInt(); i > 0; i--){
                    middleOrder.push(initialOrder.pop());
                }
            } else {
                num = s.nextInt();
                for(int i = s.nextInt(); i > 0; i--){
                    finalOrder.push(middleOrder.pop());
                }
            }
            processed += num;
        }

        while(!finalOrder.isEmpty()){
            System.out.println(finalOrder.pop());
        }
    }
}
