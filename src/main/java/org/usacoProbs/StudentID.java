package org.usacoProbs;

import java.util.Arrays;
import java.util.Scanner;

public class StudentID {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int nums = s.nextInt();
        int[] arr = new int[nums];
        int[] prefixSums = new int[nums+1];
        prefixSums[0] = 0;
        int sum = 0;

        for(int i = 0; i < nums; i++){
            arr[i] = s.nextInt();
            sum += arr[i];
            prefixSums[1+i] = sum;
        }

        int maxRange = 0;
        int range;

        for(int start = 0; start < nums; start++){
            for(int end = start; end < nums; end++){
                range = prefixSums[end+1] - prefixSums[start];
                if(range % 7 == 0 && maxRange < end + 1 - start) {
                    maxRange = end + 1 - start;
                }
            }
        }

        System.out.println(maxRange);
    }
}
