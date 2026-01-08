package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class HW5_P2 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int sideLen = s.nextInt();
        int[] row = new int[sideLen];
        int[] rowMedians = new int[sideLen];

        for(int i = 0; i < sideLen; i++){
            for(int j = 0; j < sideLen; j++){
                row[j] = s.nextInt();
            }
            rowMedians[i] = findMedian(row);
        }
        System.out.println(Arrays.toString(rowMedians));
        System.out.println(findMedian(rowMedians));
    }



    public static int findMedian(int[] arr){
        Arrays.sort(arr);
        return arr[Math.floorDiv(arr.length, 2)];
    }
}
