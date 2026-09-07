package org.usacoProbs;

import java.util.Scanner;

public class Usaco2023RotateAndShift {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int cows = s.nextInt();
        int switchers = s.nextInt();
        int mins = s.nextInt();
        int[] arr = new int[cows];
        int[] switchIndexes = new int[switchers];

        for(int i = 0; i < cows; i++){
             arr[i] = i;
        }

        for(int i = 0; i < switchers; i++){
            switchIndexes[i] = s.nextInt();
        }




        rotateAndShift(arr, switchIndexes, mins);
    }




    public static void rotateAndShift(int[] arr, int[] switchIndexes, int mins){


        for(int time = 0; time < mins; time++){
            arr = rotate(arr, switchIndexes);
            for(int i =0; i <  switchIndexes.length; i++){
                switchIndexes[i]++;
                if(switchIndexes[i] == arr.length){
                    switchIndexes[i] = 0;
                }
            }
        }
        for(int i = 0; i < arr.length-1; i ++){
            System.out.print(arr[i]+" ");
        }
        System.out.print(arr[arr.length-1]);
    }


    public static int[] rotate(int[] arr, int[] indices){
        int oldCowPos = arr[indices[1]];
        arr[indices[1]] = arr[indices[0]];
        arr[indices[0]] = arr[indices[indices.length-1]];


        for(int i = indices.length-1; i > 2; i --){
            arr[indices[i]] = arr[indices[i-1]];
        }

        arr[indices[2]] = oldCowPos;

        return arr;
    }
}
