package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Final_1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[] arr = new int[s.nextInt()];
        for(int i = 0; i < arr.length; i++){
            arr[i] = s.nextInt();
        }

        int[] arrSorted = arr.clone();
        boolean[] correctPos = new boolean[arr.length];

        Arrays.sort(arrSorted);

        for(int i = 0; i < arr.length; i++){
           correctPos[i] = (arr[i] == arrSorted[i]);
        }
        //System.out.println(Arrays.toString(arr));
        int n = 0;
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            if(!correctPos[i]){
                for(int j = 0; j < arr.length; j++){
                    if(arr[j] == arrSorted[i] && !correctPos[j]){
                        n = j;
                        break;
                    }
                }

                arr = swap(arr, n, i);
                //System.out.println(Arrays.toString(arr));

                correctPos[i] = (arr[i] == arrSorted[i]);
                correctPos[n] = (arr[n] == arrSorted[n]);

                count++;
            }
        }
        System.out.println(count);
    }

    public static int[] swap(int[] arr, int a, int b){
        int c = arr[a];
        arr[a] = arr[b];
        arr[b] = c;
        return arr;
    }
}
