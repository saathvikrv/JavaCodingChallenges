package org.usacoProbs;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static int[] currList;

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int len = s.nextInt();
        int[] nums = new int[len];
        for(int i = 0; i < len; i++){
            nums[i] = s.nextInt();
        }
        currList = new int[len];
        System.arraycopy(nums, 0, currList, 0, len);
        mergeSort(nums, 0);
    }

    public static int[] mergeSort(int[] arr, int start){
        if(arr.length == 1){
            return arr;
        }

        int[] startHalf = Arrays.copyOfRange(arr, 0, ceilDiv(arr.length,2));
        int[] endHalf = Arrays.copyOfRange(arr, ceilDiv(arr.length,2), arr.length);

        startHalf = mergeSort(startHalf, start);
        endHalf = mergeSort(endHalf, start + startHalf.length);

        return merge(startHalf, endHalf, start);
    }

    public static int[] merge(int[] arr1, int[] arr2, int start){
        int i = 0;
        int j = 0;
        int k = 0;
        int num1;
        int num2;

        int[] result = new int[arr1.length+ arr2.length];


        while(i < arr1.length && j < arr2.length){

            num1 = arr1[i];

            num2 = arr2[j];

            if(num1 > num2){
                result[k] = arr2[j];
                j+=1;
            } else{
                result[k] = arr1[i];
                i+=1;
            }

            k+=1;
        }

        while(i < arr1.length){
            result[k] = arr1[i];
            i +=1;
            k +=1;
        }

        while(j < arr2.length){
            result[k] = arr2[j];
            j +=1;
            k +=1;
        }

        System.arraycopy(result, 0, currList, start, result.length);
        for(int q = 0; q < currList.length; q++){
            if(q < currList.length-1){ System.out.print(currList[q] + " ");}
            else {System.out.println(currList[q]);}
        }

        return result;
    }

    public static int ceilDiv(int a, int b){
        return (int) Math.ceil((double) a / b);
    }
}
