package org.usacoProbs;

import java.util.Scanner;

public class problem3 {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int numOfCows = s.nextInt();
        int[] cows = new int[numOfCows];
        for(int i = 0; i < numOfCows; i++){
            cows[i] = s.nextInt();
        }
        System.out.println(countGoodPairs(cows));
    }

    public static int countGoodPairs(int[] cows){

         int sum;
         int count = 0;
         double avg;

        for(int i = 0; i < cows.length; i++){
            for(int j = 0; j < cows.length; j++){
                sum = 0;

                for(int k = i; k < j+1; k++){
                    sum += cows[k];
                }
                avg = (double) sum/(j-i+1);

                for(int k = i; k < j+1; k++){
                    if(avg == cows[k]){
                        count += 1;
                    }
                    break;
                }
            }
        }
        return count;
    }
}
