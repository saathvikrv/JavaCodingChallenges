package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class problem18 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int numOfAcorns = s.nextInt();
        int treeHeight = s.nextInt();
        int[] acorns = new int[numOfAcorns];

        for(int i = 0; i < numOfAcorns; i++){
            acorns[i] = s.nextInt();
        }


        s.close();

        acorns = mergeSort(acorns);

        int stackHeight = 0;
        int stackAcorns = 0;

        while(stackHeight < treeHeight){
            stackHeight += acorns[acorns.length - stackAcorns - 1];
            stackAcorns += 1;
        }

        System.out.println(stackAcorns);
    }

    public static int[] mergeSort(int[] arr){
        if(arr.length == 1){
            return arr;
        }

        int[] startHalf = Arrays.copyOfRange(arr, 0, Math.ceilDiv(arr.length,2));
        int[] endHalf = Arrays.copyOfRange(arr, Math.ceilDiv(arr.length,2), arr.length);

        startHalf = mergeSort(startHalf);
        endHalf = mergeSort(endHalf);

        return merge(startHalf, endHalf);
    }

    public static int[] merge(int[] arr1, int[] arr2){
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



        return result;
    }
}
