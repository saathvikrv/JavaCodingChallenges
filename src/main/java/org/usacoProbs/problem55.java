package org.usacoProbs;

import java.util.Arrays;
import java.util.Scanner;

public class problem55 {
    public static int[] doodlyDoodad(int[] arr, int a1, int a2, int b1, int b2){
        int n;
        for(int i = a1; i < a2; i++){
            if(i > a2 + a1 - i){
                break;
            }
            n= arr[i];
            arr[i] = arr[a2 - i + a1];
            arr[a2 - i + a1] = n;
        }
        for(int i = b1; i < b2; i++){
            if(i > b2 + b1 - i){
                break;
            }
            n= arr[i];
            arr[i] = arr[b2 - i + b1];
            arr[b2 - i + b1] = n;
        }
        return arr;
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);


        int[] arr = new int[s.nextInt()];
        int[] original = new int[arr.length];
        for(int i =0; i < arr.length; i++){
            arr[i] = i+1;
            original[i] = i+1;
        }

        int times = s.nextInt();
        int a1 = s.nextInt();
        int a2 = s.nextInt();
        int b1 = s.nextInt();
        int b2 = s.nextInt();

        for(int i = 0; i < times; i++){
            arr = doodlyDoodad(arr, a1-1, a2-1, b1-1, b2-1);
            if(Arrays.equals(arr, original)){
                i = times - times % (i+1);
            }
        }

        for(int n : arr){
            System.out.println(n);
        }
    }
}
