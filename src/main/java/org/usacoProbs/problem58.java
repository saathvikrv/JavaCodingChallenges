package org.usacoProbs;

import java.util.Arrays;
import java.util.Scanner;

public class problem58 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int[] poses = new int[s.nextInt()];
        for(int i = 0; i < poses.length; i++){
            poses[i] = s.nextInt();
        }
        boolean[] infected = new boolean[poses.length];
        Arrays.sort(poses);
        int ans = 0;
        int[] j;
        int a = 0;
        int b = 0;
        int c = 0;


        for(int i = 0; i < poses.length; i++){
            j = testCow(poses, i);

            //System.out.println(j);
            if(j[0]-j[1] > ans){
                ans = j[0] - j[1];
                a = j[0];
                b = j[1];
                c = i;
            }
        }
        System.out.println(ans+1);
        //System.out.println(a);
        //System.out.println(b);
        //System.out.println(y);

    }

    public static int[] testCow(int[] poses, int cow){
        int rightEnd = cow;
        int leftEnd = cow;
        int i = 0;
        int rExpands;
        int lExpands;
        boolean lFin = true;
        boolean rFin = true;
        int n = 1;

        while(leftEnd != 0 || rightEnd != poses.length-1){
            i++;
            n = 1;
            rExpands = 0;
            lExpands = 0;
            while(lFin && leftEnd - n >= 0 && poses[leftEnd] - i <= poses[leftEnd-n]){
                lExpands ++;
                n++;
                //System.out.println("hi");
            }
            leftEnd -= n -1;
            n= 1;
            while(rFin && rightEnd + n <= poses.length-1 && poses[rightEnd] + i >= poses[rightEnd+n]){
                rExpands ++;
                n++;
                //System.out.println("hi");
            }
            rightEnd += n -1;
            if(rExpands == 0){
                rFin = false;
            }
            if(lExpands == 0){
                lFin = false;
            }
            if(!lFin && !rFin){
                break;
            }
        }

        return new int[]{rightEnd, leftEnd};
    }
}
