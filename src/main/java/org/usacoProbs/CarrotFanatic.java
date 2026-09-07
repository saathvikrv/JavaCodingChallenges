package org.usacoProbs;

import java.util.Arrays;
import java.util.Scanner;

public class CarrotFanatic {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int[] carrots = new int[s.nextInt()];
        int[] showcaseSize = new int[carrots.length];
        int K = s.nextInt();

        for(int i =0; i < carrots.length; i++){
            carrots[i] = s.nextInt();
        }
        Arrays.sort(carrots);

        for(int carrot = 0; carrot < carrots.length; carrot++){
            showcaseSize[carrot] = smallerThan(carrots[carrot] + K, carrots) - carrot + 1;
        }
        int max = 0;
        for(int i = 0; i < showcaseSize.length; i++){
            for(int j = i+1; j < showcaseSize.length; j++){
                if(j >= i+showcaseSize[i]) {
                    max = Math.max(max, showcaseSize[i] + showcaseSize[j]);
                } else {
                    max = Math.max(max, showcaseSize[j] + j - i);
                }
            }
        }


        System.out.println(max);
        System.out.println(Arrays.toString(showcaseSize));
        System.out.println(Arrays.toString(carrots));
    }

    public static int smallerThan(int a, int[] arr){
        int lo = 0;
        int hi = arr.length-1;
        int mid;
        while(lo < hi){
            // System.out.println(arr[lo] + ", " + arr[hi]);
            mid = (lo+ hi +1)/2;
            if(arr[mid] < a){
                lo = mid;
            } else if(arr[mid] > a){
                hi = mid-1;
            } if(arr[mid] == a){
                return mid;
            }

        }
        return lo;
    }

}

