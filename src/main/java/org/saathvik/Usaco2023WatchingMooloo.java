package org.saathvik;

import java.io.*;
import java.util.*;

import java.lang.Math;


public class Usaco2023WatchingMooloo {
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();

        StringTokenizer st = new StringTokenizer(line1);
        int numOfDays = Integer.parseInt(st.nextToken());
        long defaultPrice = Long.parseLong(st.nextToken());

        StringTokenizer stTwo = new StringTokenizer(line2);

        long[] moolooDays = new long[numOfDays];

        for(int i=0; i<numOfDays; i++){
            moolooDays[i]=Long.parseLong(stTwo.nextToken());
        }
        //System.out.println(numOfDays+", "+defaultPrice+", "+Arrays.toString(moolooDays));

        System.out.println(watchingMooloo(numOfDays, defaultPrice, moolooDays));
    }


    public static long watchingMooloo(int numDays, long defPrice, long[] moolooDays){
        int i = 1;
        long moonies = defPrice+1;

        while(i < moolooDays.length){
            if(defPrice + 1 < moolooDays[i] - moolooDays[i-1]){
                moonies += defPrice + 1;

            } else {
                moonies += moolooDays[i] - moolooDays[i - 1];
            }
            i += 1;
        }
        return moonies;
    }


    /*public static int watchingMooloo2(int numDays, int defPrice, int[] moolooDays){
        if(moolooDays.length==1){
            return defPrice+1;
        }

        int midPoint = Math.ceilDiv(moolooDays.length, 2);

        int firstHalf = watchingMooloo(midPoint+1,defPrice, Arrays.copyOfRange(moolooDays, 0, midPoint));

        int secondHalf = watchingMooloo(moolooDays.length - midPoint-1,defPrice, Arrays.copyOfRange(moolooDays, midPoint-1, moolooDays.length -1));

        return Math.min(firstHalf+secondHalf, moolooDays[moolooDays.length-1]-moolooDays[0]+defPrice+1);

    }

    */
}
