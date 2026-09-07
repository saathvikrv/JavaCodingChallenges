package org.usacoProbs;

import java.util.Arrays;
import java.util.Scanner;

public class problem5 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int numOfSpots = s.nextInt();
        int numOfCows = s.nextInt();
        int[] cows = new int[numOfCows];
        for(int i =0; i < numOfCows; i++){
            cows[i] = s.nextInt();
        }
        maxRevenue(cows, numOfSpots);
    }

    public static int maxRevenue(int[] prices, int numOfSpots){
        int maxRev = -1;
        int priceMax = 0;
        int rev = 0;
        int j;
        int fixedPrice;
        Arrays.sort(prices);
        for(int i = prices.length - 1; i > -1; i--){
            rev = 0;
            fixedPrice = prices[i];
            j = 0;
            while( j < numOfSpots-1 && prices[prices.length - 1 - j] >= fixedPrice){
                rev += fixedPrice;
                j += 1;
            }
            if(rev > maxRev){
                maxRev = rev;
                priceMax = fixedPrice;
            }
        }

        System.out.print(priceMax+" "+maxRev);
        return maxRev;
    }
}
