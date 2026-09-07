package org.usacoProbs;

import java.util.Scanner;

public class problem70V2 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int len = s.nextInt();


        int[] a = new int[len];
        int[] b = new int[len];
        for(int i =0; i < len; i++){
            a[i] = s.nextInt();
        }
        for(int i =0; i < len; i++){
            b[i] = s.nextInt();
        }
        int[] bIndexes = new int[a.length];

        for(int i =0; i < a.length; i++){
            bIndexes[b[i]-1] = i;
        }
        int max = 0;
        int n;
        int count = 0;

        for(int i =0; i < a.length; i++){
            if(bIndexes[a[max]-1] > bIndexes[a[i]-1]){
                   n = a[i];
                   a[i] = a[i-1];
                   a[i-1] = n;
                   count++;
                   max++;
            } else {
                max = i;
            }
        }


        System.out.println(count);
    }
}
