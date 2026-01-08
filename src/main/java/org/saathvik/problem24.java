package org.example;

import java.util.Arrays;
import java.util.Scanner;


public class problem24 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int cowNum = s.nextInt();


        int[][] cows = new int[cowNum][2];

        for(int i = 0; i < cowNum; i++){
            cows[i][0] = s.nextInt();
            cows[i][1] = s.nextInt();
        }

        cows = mergeSort(cows);



        int time = 0;
        int currentCow = 0;
        while (currentCow < cows.length) {
            while (time < cows[currentCow][0]) {
                time++;
            }
            for (int i = 0; i < cows[currentCow][1]; i++) {
                time++;
            }
            currentCow++;
        }


        System.out.println(time);
    }

    public static int[][] mergeSort(int[][] arr){
        if(arr.length == 1){
            return arr;
        }

        int[][] startHalf = Arrays.copyOfRange(arr, 0, Math.ceilDiv(arr.length,2));
        int[][] endHalf = Arrays.copyOfRange(arr, Math.ceilDiv(arr.length,2), arr.length);

        startHalf = mergeSort(startHalf);
        endHalf = mergeSort(endHalf);

        return merge(startHalf, endHalf);
    }

    public static int[][] merge(int[][] arr1, int[][] arr2){
        int i = 0;
        int j = 0;
        int k = 0;
        int num1;
        int num2;

        int[][] result = new int[arr1.length+ arr2.length][2];


        while(i < arr1.length && j < arr2.length){

            num1 = arr1[i][0];

            num2 = arr2[j][0];

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

