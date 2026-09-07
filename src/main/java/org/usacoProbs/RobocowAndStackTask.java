package org.usacoProbs;

import java.util.Arrays;
import java.util.Scanner;

public class RobocowAndStackTask {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int K = s.nextInt();

        int[] arr = new int[N+2];

        for(int i = 0; i < K; i++){
            arr[s.nextInt()] ++;
            arr[s.nextInt()+1] --;
        }

        int[] result = new int[N+2];

        int sum = 0;
        for(int i = 0; i < result.length; i++){
            result[i] = sum;
            sum += arr[i];
        }

        Arrays.sort(result);
        System.out.println(Arrays.toString(result));
        System.out.println(result[(result.length)/2+1]);
    }
}
