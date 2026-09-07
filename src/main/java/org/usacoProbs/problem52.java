package org.usacoProbs;

import java.util.Scanner;

public class problem52 {
    public static void main(String[] args){
        long BUNNY_AND_INSATIABLE_HUNGER = 0;

        Scanner s = new Scanner(System.in);

        long[][] deliveries = new long[s.nextInt()+1][2];
        long days = s.nextLong();
        for(int i =0; i < deliveries.length-1; i++){
            deliveries[i][0] = s.nextLong();
            deliveries[i][1] = s.nextLong();
        }
        deliveries[deliveries.length-1][0] = days+1;
        deliveries[deliveries.length-1][1] = 0;

        long j;

        long carrotStock = 0;
        for(int currDelivery  = 0; currDelivery < deliveries.length; currDelivery++){
            if(currDelivery > 0){
                j = Math.min(carrotStock, deliveries[currDelivery][0] - deliveries[currDelivery-1][0]);
                BUNNY_AND_INSATIABLE_HUNGER += j;
                carrotStock -= j;
            }
            carrotStock += deliveries[currDelivery][1];
        }
        System.out.println(BUNNY_AND_INSATIABLE_HUNGER);
    }
}
