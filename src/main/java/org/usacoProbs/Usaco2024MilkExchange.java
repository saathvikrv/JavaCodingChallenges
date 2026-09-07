package org.usacoProbs;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Usaco2024MilkExchange {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String inst = scanner.nextLine();
        String line3 = scanner.nextLine();

        System.out.println("Crunching Numbers...");

        StringTokenizer st = new StringTokenizer(line1);
        int cows = Integer.parseInt(st.nextToken());
        int mins = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(line3);

        int[] buckets = new int[cows];
        for( int i = 0; i < cows; i++){
            buckets[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(milkExchange(cows, buckets, mins, inst));

    }

    public static int milkExchange(int cowNum, int[] bucketCapacity, int mins, String instructions){
        int[] buckets = bucketCapacity.clone();
        for(int j = 0; j < mins; j++) {
            if (j%1000 == 0) System.out.println("j="+j);
            for (int i = 0; i < cowNum; i++) {
                if(buckets[i] > 0) {
                    buckets[i] -= 1;
                    if (instructions.charAt(i) == 'L') {
                        if (i == 0) {
                            buckets[buckets.length - 1] += 1;
                        } else {
                            buckets[i - 1] += 1;
                        }
                    } else {
                        if (i == cowNum - 1) {
                            buckets[0] += 1;
                        } else {
                            buckets[i + 1] += 1;
                        }
                    }
                }
            }
            checkOverflow(bucketCapacity, buckets);
        }

        return sumArray(buckets);
    }

    public static void checkOverflow(int[] capacities, int[] currentMilkLevels){
        for(int i = 0; i < capacities.length; i++){
            if(currentMilkLevels[i] > capacities[i]){
                currentMilkLevels[i] = capacities[i];
            }
        }
    }

    public static int sumArray(int[] arr){
        int sum = 0;
        for(int i = 0 ; i < arr.length; i ++){
            sum += arr[i];
        }
        return sum;
    }
}
