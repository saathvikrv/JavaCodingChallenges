package org.usacoProbs;

import java.util.Arrays;
import java.util.Scanner;

public class Midterm_9 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        final int AMT_OF_COWS = s.nextInt();
        final int AMT_OF_FERRIES = s.nextInt();
        final int FERRY_CAP = s.nextInt();
        int[] ferryArrangement = new int[AMT_OF_FERRIES * FERRY_CAP +1];
        Arrays.fill(ferryArrangement, Integer.MAX_VALUE);
        for(int i = 0; i < AMT_OF_COWS; i++){
            ferryArrangement[i] = s.nextInt();
        }

        Arrays.sort(ferryArrangement);
        ferryArrangement[ferryArrangement.length-1] = -1;
        // System.out.println(Arrays.toString(ferryArrangement));
        int max = 0;
        for(int i = AMT_OF_COWS - 1; i >=0; i--){
            max = update(i, ferryArrangement, FERRY_CAP, max);
        }
        System.out.println(Arrays.toString(ferryArrangement));
        System.out.println(max);
    }

    /**
     * @return new max difference per ferry
     */
    public static int update(int index, int[] arrangement, int ferrySize, int currMax){
        int i = index;

        while(arrangement[i+1] == Integer.MAX_VALUE){
            i++;
        }
        while(arrangement[findEndOfFerry(i, ferrySize)] < Integer.MAX_VALUE && arrangement[findEndOfFerry(i, ferrySize)] - arrangement[index] > currMax && arrangement[i] == Integer.MAX_VALUE){
            i--;
        }
        while(arrangement[findEndOfFerry(i, ferrySize)] < Integer.MAX_VALUE && arrangement[findEndOfFerry(i, ferrySize)] - arrangement[index] > currMax){
            currMax++;
            for(int j = arrangement.length-2; j > i; j--){
                while(arrangement[j] == Integer.MAX_VALUE && arrangement[j-1] == Integer.MAX_VALUE){
                    j--;
                }
                while(arrangement[j] == Integer.MAX_VALUE && arrangement[findEndOfFerry(i, ferrySize)] - arrangement[j-1] < currMax){
                    arrangement[j] = arrangement[j-1];
                    arrangement[j-1] = Integer.MAX_VALUE;
                    if(arrangement[j+1] == Integer.MAX_VALUE){
                        j++;
                    }
                }
            }
        }
        int prevVal = arrangement[index];
        arrangement[index] = Integer.MAX_VALUE;
        arrangement[i] = prevVal;


        return currMax;
    }

    public static int findEndOfFerry(int index, int ferryCap){
        return Math.ceilDiv(index + 1, ferryCap) * ferryCap - 1;
    }
}

/*
8 5 2
2 2 7 8 10 12 13 5
 */