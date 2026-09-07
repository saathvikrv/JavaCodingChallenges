package org.usacoProbs;

import java.util.Arrays;
import java.util.Scanner;

public class problem82 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int len = s.nextInt();

        long[] cows = new long[len];
        for(int i =0; i < len; i++){
            cows[i] = s.nextLong();
        }

        Arrays.sort(cows);
        long count = 0;
        for(int cow1 = 0; cow1 < cows.length-2; cow1++){
            for(int cow2 = cow1+1; cow2 < cows.length-1; cow2++){
                long diff = cows[cow2]-cows[cow1];
                long min = greaterThan(cows[cow2] + diff, cows);
                long max = smallerThan(cows[cow2] + diff*2, cows);
                if(cows[cow2] + diff <= cows[cows.length-1]) {
                    count += max - min + 1;
                }
                System.out.println(cow1 + ", " + cow2 + ", " + max + ", " + min);
            }
        }
        System.out.println(count);
    }

    public static long smallerThan(long a, long[] arr){
        int lo = 0;
        int hi = arr.length-1;
        int mid;
        while(lo < hi){
            // System.out.println(arr[lo] + ", " + arr[hi]);
            mid = (lo+ hi +1)/2;
            if(arr[mid] < a){
                lo = mid;
            } else if(arr[mid] > a){
                hi = mid-1;
            } if(arr[mid] == a){
                return mid;
            }

        }
        return lo;
    }

    public static long greaterThan(long a, long[] arr){
        int lo = 0;
        int hi = arr.length-1;
        int mid;
        while(lo < hi){
            // System.out.println(arr[lo] + ", " + arr[hi]);
            mid = (lo+ hi)/2;
            if(arr[mid] < a){
                lo = mid+1;
            } else if(arr[mid] > a){
                hi = mid;
            } if(arr[mid] == a){
                return mid;
            }

        }
        return hi;
    }
}
