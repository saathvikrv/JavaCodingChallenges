package org.usacoProbs;

import java.util.Arrays;
import java.util.Scanner;

public class problem23 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        s.nextLine();
        String roomOrder =  s.nextLine();
        int[] gaps = new int[roomOrder.length()];
        int j = 0;
        int gapLen = 0;
        char q;


        for(int i = 0; i < roomOrder.length(); i++){
            q = roomOrder.charAt(i);
            if(q == '0'){
                gapLen++;
            } else {
                gaps[j] = gapLen;
                gapLen = 0;
                j++;
            }
        }

        gaps[j] = gapLen;
        gapLen = 0;
        j++;

        gaps = Arrays.copyOfRange(gaps, 0, Math.max(j, 1));

        System.out.println(Arrays.toString(gaps));

        if(gaps[0] > 0) {
            gaps[0] = gaps[0] * 2 - 1;
        }
        if(gaps[gaps.length-1] > 0) {
            gaps[gaps.length - 1] = gaps[gaps.length - 1] * 2 - 1;
        }

        Arrays.sort(gaps);

        System.out.println(Arrays.toString(gaps));

        int largestGap = gaps[gaps.length - 1];



        if (largestGap % 3 < 2) {
            largestGap = (largestGap - (largestGap % 3)) / 3;
        } else {
            largestGap = (largestGap + 1) / 3;
        }

        if(gaps.length > 1) {

            int secondLargestGap = gaps[gaps.length - 2];

            if (secondLargestGap % 2 == 0) {
                secondLargestGap = secondLargestGap / 2 - 1;
            } else {
                secondLargestGap = (secondLargestGap + 1) / 2;
            }
            int res = Math.max(secondLargestGap, largestGap);
            System.out.println(Math.min(gaps[0], res));
        } else {
            System.out.println(largestGap);
        }
    }
}
