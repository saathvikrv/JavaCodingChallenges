package org.usacoProbs;

import java.util.*;

public class problem37 {
    public static void minCows(int[] cowPos){
        Set<Integer> toNotify = new HashSet<>();
        Arrays.sort(cowPos);
        boolean a;
        boolean b;
        int count = 0;
        int countPerInterval;

        for(int i = 1; i < cowPos.length; i++){
            if(leftOrRight(cowPos, i) == 'r' && leftOrRight(cowPos, i-1) == 'l'){
                toNotify.add(i);
            }
        }
        toNotify.add(0);
        toNotify.add(cowPos.length);

        Object[] intervals = toNotify.toArray();
        Arrays.sort(intervals);

        for(int j = 0; j < intervals.length-1; j++) {
            countPerInterval = 0;
            for (int i = (int) intervals[j]; i < (int) intervals[j+1]; i++) {
                a = false;
                b = false;

                if (i < (int) intervals[j+1] - 1) {
                    if (i == (int) intervals[j+1] - 2) {
                        a = true;
                    } else if (cowPos[i + 1] - cowPos[i] <= cowPos[i + 2] - cowPos[i + 1]) {
                        a = true;
                    }
                }
                if (i > (int) intervals[j]) {
                    if (i == (int) intervals[j]+1) {
                        b = true;
                    } else if (cowPos[i] - cowPos[i - 1] < cowPos[i - 1] - cowPos[i - 2]) {
                        b = true;
                    }
                }
                if (!a && !b) {
                    toNotify.add(cowPos[i]);
                    countPerInterval++;
                }
            }
            count += Math.max(1, countPerInterval);
        }

        System.out.println(count);
    }


    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int[] pos = new int[s.nextInt()];
        for(int i =0; i < pos.length; i++){
            pos[i] = s.nextInt();
        }
        minCows(pos);
    }

    public static char leftOrRight(int[] cowPos, int pos){
        if(pos == 0){
            return 'r';
        }

        if(pos == cowPos.length-1){
            return 'l';
        }

        if(cowPos[pos+1] - cowPos[pos] < cowPos[pos] - cowPos[pos-1]){
            return 'r';
        } else {
            return 'l';
        }
    }
}
