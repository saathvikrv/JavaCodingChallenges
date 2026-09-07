package org.usacoProbs;

import java.util.Arrays;
import java.util.Scanner;

public class problem54 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int len = s.nextInt();
        int[] curr = new int[len];
        int[] target = new int[len];
        for(int i =0; i < len; i++){
            curr[i] = s.nextInt();
        }
        for(int i =0; i < len; i++){
            target[i] = s.nextInt();
        }

        int i = 0;
        int j;
        int minChange;
        int count = 0;
        while(!Arrays.equals(curr, target)){
            while(curr[i] == target[i]){
                i++;
            }
            j = i;
            if(target[i] > curr[i]){
                minChange = Integer.MAX_VALUE;
                while(j < curr.length && target[j] > curr[j]){
                    minChange = Math.min(minChange, target[j] - curr[j]);
                    j++;
                }
                for(int n = i; n < j; n++){
                    target[n] -= minChange;
                }
                count+=minChange;
            } else if(target[i] < curr[i]){
                minChange = Integer.MAX_VALUE;
                while(j < curr.length && target[j] < curr[j]){
                    minChange = Math.min(minChange, curr[j] - target[j]);
                    j++;
                }
                for(int n = i; n < j; n++){
                    target[n] += minChange;
                }
                count+=minChange;
            }
        }
        System.out.println(count);
    }
}
