package org.usacoProbs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class AcornSpots {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int acorns = s.nextInt();

        int[][] intervals = new int[s.nextInt()][2];
        for(int i =0; i < intervals.length; i++){
            intervals[i][0] = s.nextInt();
            intervals[i][1] = s.nextInt();
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        long lo = 1;
        long hi = (int) Math.ceil((double) (intervals[intervals.length-1][1] - intervals[0][0]) / (double) acorns);
        long mid;
        while(lo < hi){
            mid = (lo+ hi +1)/2;
            boolean result = simulate(acorns, intervals, mid);

            if(result){
                lo = mid;
            } else {
                hi = mid-1;
            }

        }
        System.out.println(lo);
    }

    public static boolean simulate(int acorns, int[][] intervals, long D){
        boolean possible = true;
        long prev = intervals[0][0];
        int currInterval = 0;
        for(int i = 1; i < acorns; i++){
            long goal = prev + D;
            while(currInterval < intervals.length-1 && intervals[currInterval][1] < goal){
                currInterval ++;
            }
            if(intervals[currInterval][1] >= goal && intervals[currInterval][0] <= goal){
                prev = goal;
            } else if(goal > intervals[currInterval][1]) {
                possible = false;
                break;
            } else {
                prev = intervals[currInterval][0];
            }
        }

        return possible;
    }
}

/*
5 3
0 2
4 7
9 9
 */
