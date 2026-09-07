package org.usacoProbs;

import java.util.Arrays;
import java.util.Scanner;

public class AcornsInALine {
    public static int count = 0;

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int len = (int) Math.pow(2d, s.nextInt());
        int[] nums = new int[len];
        for(int i = 0; i < len; i++){
            nums[i] = s.nextInt();
        }
        int[] ans = mergeSort(nums);
        System.out.println(count);

        for(int i =0; i < len; i++){
            System.out.println(ans[i]);
        }
    }

    public static int[] mergeSort(int[] arr){
        if(arr.length == 1){
            return arr;
        }

        int[] startHalf = Arrays.copyOfRange(arr, 0, ceilDiv(arr.length,2));
        int[] endHalf = Arrays.copyOfRange(arr,ceilDiv(arr.length,2), arr.length);

        startHalf = mergeSort(startHalf);
        endHalf = mergeSort(endHalf);

        return merge(startHalf, endHalf);
    }

    public static int[] merge(int[] arr1, int[] arr2){
        int[] result = new int[arr1.length + arr2.length];

        if(Arrays.compare(arr1, arr2) <= 0){
            System.arraycopy(arr1, 0, result, 0, arr1.length);
            System.arraycopy(arr2, 0, result, arr1.length, arr2.length);
        } else {
            count += arr1.length * (arr1.length + arr2.length);
            System.arraycopy(arr2, 0, result, 0, arr2.length);
            System.arraycopy(arr1, 0, result, arr2.length, arr1.length);
        }

        return result;
    }

    public static int ceilDiv(int a, int b){
        return (int) Math.ceil((double) a / b);
    }
}
