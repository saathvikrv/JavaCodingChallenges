package org.usacoProbs;

import java.util.Scanner;
import java.util.Stack;

public class problem88 {
    public static void main(String[] args){
        Stack<Character> dancers;
        Scanner s = new Scanner(System.in);
        int numDancers;
        int pointingRight;
        String line;
        boolean balanced;

        int tests = s.nextInt();
        for(int t = 0; t < tests; t++) {
            dancers = new Stack<>();
            numDancers = s.nextInt();
            pointingRight = 0;
            line = s.next();
            balanced = true;
            for (int i = 0; i < numDancers; i++) {
                if (line.charAt(i) == '<') {
                    pointingRight--;
                    if (pointingRight < 0) {
                        balanced = false;
                        break;
                    }
                    dancers.pop();
                } else {
                    pointingRight++;
                    dancers.push('>');
                }
            }
            System.out.println((balanced && pointingRight == 0) ? "legal" : "illegal");


        }
    }
}
