package org.usacoProbs;

import java.util.Scanner;

public class OneMoreThanZero {
    public static int count;

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int len = s.nextInt();

        boolean[] used = new boolean[len];
        count = 0;
        generate(0, used, 0);
        System.out.println(count);
    }

    public static void generate(int start, boolean[] used, int amtUsed){
        if(start == used.length){
            process(used, amtUsed);
        } else {
            generate(start + 1, used, amtUsed);
            used[start] = true;
            generate(start + 1, used, amtUsed+1);
            used[start] = false;
        }
    }

    public static void process(boolean[] used, int amtUsed){
        if(amtUsed > used.length - amtUsed){
            for(boolean n : used){
                if(n){
                    System.out.print(1);
                } else {
                    System.out.print(0);
                }
            }
            System.out.println();
            count++;
        }

    }
}
