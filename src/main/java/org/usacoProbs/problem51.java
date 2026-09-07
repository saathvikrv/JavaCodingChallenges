package org.usacoProbs;

import java.util.Scanner;

public class problem51 {
    public static void main(String[] args){
        boolean[] painted = new boolean[101];

        Scanner s = new Scanner(System.in);
        final int start1 = s.nextInt();
        final int end1 = s.nextInt();
        final int start2 = s.nextInt();
        final int end2 = s.nextInt();

        for(int i = start1; i < end1; i++){
            painted[i] = true;
        }
        for(int i = start2; i < end2; i++){
            painted[i] = true;
        }

        int count = 0;

        for(boolean item : painted){
            if(item){
                count ++;
            }
        }
        System.out.println(count);
    }
}
