//package org.saathvik;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Usaco2021JustStalling {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();
        String line3 = scanner.nextLine();

        StringTokenizer st = new StringTokenizer(line1);
        int numCows = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(line2);

        long[] cows = new long[numCows];

        for(int i=0; i<numCows; i++){
            cows[i]=Long.parseLong(st2.nextToken());
        }

        StringTokenizer st3 = new StringTokenizer(line3);

        long[] stalls = new long[numCows];

        for(int i=0; i<numCows; i++){
            stalls[i]=Long.parseLong(st3.nextToken());
        }
//        System.out.println(numCows);
//
//        System.out.println(Arrays.toString(cows));
//
//        System.out.println(Arrays.toString(stalls));

        System.out.println(justStalling(4,cows, stalls));
    }


    public static long justStalling(int numStalls, long[] cows, long[] stalls) {
        Arrays.sort(cows);

        long possibleCombos = 1;
        int j;
        int stablesForCow;
        int i = cows.length - 1;
        while(i >= 0){
            j = 0;
            stablesForCow = 0;
            while(j < stalls.length){
                if(cows[i] <= stalls[j]){
                    stablesForCow+=1;
                }
                j += 1;
            }
            possibleCombos = (stablesForCow-cows.length+1+i) * possibleCombos;
            i -= 1;
        }

        return possibleCombos;
    }



}
