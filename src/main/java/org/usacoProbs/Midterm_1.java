package org.usacoProbs;

import java.util.Arrays;
import java.util.Scanner;

public class Midterm_1 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int[] nums = new int[7];
        for(int i = 0; i < 7; i++){
            nums[i] = s.nextInt();
        }

        Arrays.sort(nums);
        int thirdVal = nums[nums.length -1] - nums[0] - nums[1];

        System.out.println(nums[0]+" "+nums[1]+" "+thirdVal);
    }
}
