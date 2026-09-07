package org.usacoProbs;

import java.util.Scanner;

public class problem10 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        int y = s.nextInt();
        s.close();
        int cowPos = x;
        int cowPosCurrent;
        int stepsToWalk = 1;
        int steps =0;

        while(cowPos != y){
            cowPosCurrent = cowPos;
            if(stepsToWalk > 0) {
                while (cowPos != y && cowPos != x + stepsToWalk) {
                    cowPos += 1;
                    steps+=1;
                }
            } else {
                while (cowPos != y && cowPos != x + stepsToWalk) {
                    cowPos -= 1;
                    steps+=1;
                }
            }
            stepsToWalk *= -2;
        }
        System.out.println(steps);
    }
}
