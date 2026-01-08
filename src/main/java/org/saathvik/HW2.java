package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class HW2 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int hillNum = s.nextInt();
        int[] hills = new int[hillNum];
        for(int i = 0; i < hillNum; i++){
            hills[i] = s.nextInt();
        }

        //int[] hills = {3, 5, 9, 20, 22, 25};

        System.out.println(landscaping(hills));

    }



    public static int landscaping(int[] hills){
        Arrays.sort(hills);

        final int hillDist = hills[hills.length-1] - hills[0] - 17;

        if(hillDist <= 0){
            return 0;
        }

        int j;
        int n;
        int price;
        int minPrice = Integer.MAX_VALUE;

        for(int i = 0; i < hillDist; i++){
            j = hillDist - i;
            price = 0;
            n = 0;

            while(hills[n] < hills[0]+j) {
                price += (hills[0]+j-hills[n])*(hills[0]+j-hills[n]);
                n+=1;
            }

            n = hills.length - 1;

            while(hills[n] > hills[hills.length - 1]-i) {
                price += (hills[hills.length - 1]-i-hills[n])*(hills[hills.length - 1]-i-hills[n]);
                n-=1;
            }

            if(minPrice > price){
                minPrice = price;
            }
        }

        return minPrice;
    }


}
