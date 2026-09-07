package org.usacoProbs;

import java.util.*;


public class AcornSurveillance{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int amtIntervals = s.nextInt();

        int[][] intervals = new int[amtIntervals*2][3];

        for(int i = 0; i < amtIntervals*2; i+=2){
            intervals[i][0] = s.nextInt();
            intervals[i][1] = 1;
            intervals[i][2] = i;
            intervals[i+1][0] = s.nextInt();
            intervals[i+1][1] = -1;
            intervals[i+1][2] = i;
        }

        int curX = 0;
        int total = 0;
        Set<Integer> currIds = new HashSet<>();
        int[] alone = new int[amtIntervals];


        for(int[] event : intervals){
            if(currIds.size() > 0){
                total += event[0] - curX;
            }
            if(currIds.size() == 1){
                alone[currIds.iterator().next()] += event[0] - curX;
            }

            if(event[1] == 1){
                currIds.add(event[2]);
            } else if(event[1] == -1){
                currIds.remove(event[2]);
            }

            curX = event[0];
        }

        int min = Integer.MAX_VALUE;

        for(int i : alone){
            min = Math.min(i, min);
        }

        System.out.println(total - min);
    }
}
