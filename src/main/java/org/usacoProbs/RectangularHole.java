package org.usacoProbs;

import java.util.Scanner;

public class RectangularHole {
    public static int fillHole(int depth, int[] haybales){
        boolean[] used = new boolean[haybales.length];
        return fillHole(depth, haybales, used, 0);
    }

    private static int fillHole(int depth, int[] haybales, boolean[] used, int currHeight){
        int min = Integer.MAX_VALUE;
        for(int haybale = 0; haybale < haybales.length; haybale++){
            if(!used[haybale]){
                if(currHeight + haybales[haybale] > depth){
                    min = Math.min(min, currHeight+haybales[haybale] - depth);
                } else {
                    used[haybale] = true;
                    min = Math.min(min, fillHole(depth, haybales, used, currHeight + haybales[haybale]));
                    used[haybale] = false;
                }
            }
            System.out.println("Min: " + min);
            System.out.println("Curr Height: " + currHeight);

        }
        return min;
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int amtOfHaybales = s.nextInt();
        int depth = s.nextInt();
        int[] haybales = new int[amtOfHaybales];
        for(int i =0; i < amtOfHaybales; i++){
            haybales[i] = s.nextInt();
        }
        System.out.println(fillHole(depth, haybales));
    }
}
