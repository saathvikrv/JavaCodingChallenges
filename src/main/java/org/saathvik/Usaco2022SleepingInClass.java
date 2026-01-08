//package org.saathvik;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Usaco2022SleepingInClass {
    public static void findVal(int[] arr){
        int sum = 0;
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int num : arr){
            sum += num;
            if(num > max){
                max = num;
            }
            if(num < min){
                min = num;
            }
        }

        if(min == max){
            System.out.println(0);
        } else {
            int pileSize = arr[0];
            int i = 0;
            int quotient = sum % Math.max(pileSize, 1);
            while (quotient > 0 || pileSize < max) {
                i++;
                pileSize += arr[i];
                if(pileSize == 0) {
                    while(arr[i] == 0){
                        i++;
                    }
                    pileSize += arr[i];
                }
                quotient = sum % pileSize;
            }
            int currPileSize;
            int j = 0;
            while (j < arr.length) {
                currPileSize = arr[0];
                j = 0;
                while (pileSize >= currPileSize && j < arr.length) {
                    if (pileSize == currPileSize) {
                        currPileSize = 0;
                    }
                    j++;
                    if (j < arr.length) {
                        currPileSize += arr[j];
                    } else {
                        break;
                    }
                }
                if (pileSize < currPileSize) {
                    i++;
                    pileSize += arr[i];
                }
            }
            System.out.println(arr.length -sum / pileSize);
        }
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int testCases = s.nextInt();
        int len;
        int[] arr;
        //System.out.println();
        for(int n =0; n < testCases; n++){
            len = s.nextInt();
            arr = new int[len];
            Arrays.fill(arr, -1);
            for(int i = 0; i < len-1; i++){
                arr[i] = s.nextInt();
            }
            arr[len-1] = s.nextInt();

            //System.out.println(Arrays.toString(arr));
            findVal(arr);
        }

    }
}
