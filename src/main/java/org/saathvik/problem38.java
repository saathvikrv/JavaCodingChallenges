package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class problem38 {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int[][] shifts = new int[s.nextInt()][2];

        for(int i =0; i < shifts.length; i++){
            shifts[i][0] = s.nextInt();
            shifts[i][1] = s.nextInt();
        }

        int[] solos = new int[shifts.length];
        shifts = mergeSort(shifts);
        int j = shifts[0][0];
        int currSolo;
        boolean isSolo;
        int unwatched = 0;
        int maxVal = 0;

        for(int i = 0; i < shifts.length; i++){
            if(shifts[i][1] > maxVal){
                maxVal = i;
            }
        }

        while(true){
            currSolo = -1;
            isSolo = true;

            for(int i = 0; i < shifts.length; i++){

                if(shifts[i][0] <= j && j <= shifts[i][1]){

                    if(currSolo == -1){

                        currSolo = i;

                    } else {

                        isSolo = false;

                    }

                }

            }

            if(currSolo == -1){
                if(j > shifts[maxVal][1]) {
                    break;
                } else {
                    unwatched++;
                }
            }

            if(isSolo && currSolo >= 0){
                solos[currSolo]++;
            }
            j++;
        }


        int min = Integer.MAX_VALUE;

        solos[0] -= 1;
        solos[maxVal] -=1;

        for(int i : solos){
            if(i < min){
                min = i;
            }
        }
        System.out.println(j - min - 2 - unwatched - shifts[0][0]);
        // System.out.println("end: "+j);
        // System.out.println("min: "+min);
        // System.out.println("start: "+shifts[0][0]);
        // System.out.println(Arrays.deepToString(shifts));
        // System.out.println(Arrays.toString(solos));
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
