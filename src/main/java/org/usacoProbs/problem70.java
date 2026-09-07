package org.usacoProbs;

import java.util.Arrays;
import java.util.Scanner;

public class problem70 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int len = s.nextInt();
        int[] curr = new int[len];

        for(int i =0; i < len; i++){
            curr[i] = s.nextInt();
        }
        int[] target = new int[len];

        for(int i =0; i < len; i++){
            target[i] = s.nextInt();
        }

        int[] indexes = new int[curr.length];

        for(int i =0; i < target.length; i++){
            indexes[target[i]-1] = i;
        }

        int count = 0;

        for(int i = target.length-1; i >=0; i--){
            if(curr[i] != target[i]){
                count += Math.abs(indexes[curr[i]-1] - i);
                curr = moveTo(curr, i, indexes[curr[i]-1]);
            }
        }

        System.out.println(count);

    }

    public static int[] moveTo(int[] list, int start, int end){
        int a = list[end];

        for(int i = end; i < start; i++){
            list[i] = list[i+1];
        }

        list[start] = a;
        System.out.println(Arrays.toString(list));
        return list;
    }
}

