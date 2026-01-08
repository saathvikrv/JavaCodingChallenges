package org.example;

import java.util.Scanner;

public class problem2 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        int y = s.nextInt();
        int m = s.nextInt();

        maxCharge(y, x, m);
    }

    public static void maxCharge(int largeCurrency, int smallCurrency, int maxVal){
        int j;
        int res = 0;
        int currentMax;
        for(int i = 0; i < Math.ceilDiv(maxVal, largeCurrency); i++){
            j = 0;
            while(largeCurrency*i+smallCurrency*j <= maxVal){
                j+=1;
            }
            currentMax = largeCurrency*i+smallCurrency*j-smallCurrency;

            if(res < currentMax){
                res = currentMax;
            }
        }
        System.out.println(res);
    }

}
