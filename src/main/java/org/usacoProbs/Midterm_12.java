package org.usacoProbs;

import java.util.Scanner;
import java.util.Stack;

public class Midterm_12 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int len = s.nextInt();
        int[] line = new int[len];
        for(int i =0; i < len; i++){
            line[i] = s.nextInt();
        }

        int candies = 0;
        int pos = 0;
        int steps = 0;
        Stack<Thing> toPay = new Stack<>();
        while(pos < line.length){
            if(line[pos] < 0){
                if(candies < -1 * line[pos]) {
                    toPay.push(new Thing(line[pos], pos));
                } else {
                    candies += line[pos];
                }
            } else {
                candies+= line[pos];
                if(!toPay.isEmpty() && candies > toPay.peek().money * -1){
                    steps += (pos - toPay.peek().index) * 2;
                    candies += toPay.pop().money;
                }
            }
            pos++;
            steps++;
        }

        if(!toPay.isEmpty() && candies > toPay.peek().money * -1){
            steps += (pos - toPay.peek().index) * 2;
            candies -= toPay.pop().money;
        }

        System.out.println(steps);

    }

    public static class Thing{
        public int money;
        public int index;

        public Thing(int money, int index){
            this.money = money;
            this.index = index;
        }
    }
}
