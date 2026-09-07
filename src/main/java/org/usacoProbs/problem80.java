package org.usacoProbs;

import java.util.Arrays;
import java.util.Scanner;

public class problem80 {
    public static void main(String[] args){
        Scanner s= new Scanner(System.in);
        int targets = s.nextInt();
        int acorns = s.nextInt();
        int[] targetLocations = new int[targets];
        for(int i = 0; i < targets; i++){
            targetLocations[i] = s.nextInt();
        }
        boolean solved = false;
        Arrays.sort(targetLocations);
        int r = 1;
        while(!successful(targetLocations, r, acorns)){
            r++;
        }
        System.out.println(r);
    }

    public static int greaterThan(int a, int[] arr){
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

    public static boolean successful(int[] targets, int r, int shots){
        int currentPoint  = targets[0];
        int currentTarget = 0;
        for(int i =0; i < shots; i++) {
            currentPoint += r * 2 + 1;
            currentTarget = greaterThan(currentPoint, targets);
            currentPoint = Math.max(currentPoint, targets[currentTarget]);
        }
        if(currentTarget+1 >= targets.length-1){
            return true;
        } else {
            return false;
        }
    }
}
