package org.usacoProbs;

import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int len = s.nextInt();
        int[] nums = new int[len];
        for(int i = 0; i < len; i++){
            nums[i] = s.nextInt();
        }

        quickSort(nums, 0, nums.length-1);
    }

    public static void quickSort(int[] nums, int left, int right){

        if(left >= right) {
            return;
        }

        int pivot = nums[right];
        int i = left - 1;
        int n;

        for(int j = left; j <= right; j++) {
            if(nums[j] <= pivot) {
                i++;
                n = nums[i];
                nums[i] = nums[j];
                nums[j] = n;
            }


        }

        for(int q = 0; q < nums.length; q++){
            if(q < nums.length-1){ System.out.print(nums[q] + " ");}
            else {System.out.println(nums[q]);}
        }

        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);

    }
}
