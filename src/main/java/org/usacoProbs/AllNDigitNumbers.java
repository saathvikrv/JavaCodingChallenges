package org.usacoProbs;

import java.util.Scanner;

public class AllNDigitNumbers {

    public static String[] nDigitNumbers(String[] nums, int digits){
        if(digits == 1){
            return nums;
        }

        String[] prev = nDigitNumbers(nums, digits -1);
        String[] ans = new String[prev.length*nums.length];
        for(int i =0; i < nums.length; i++){
            for(int j = i * prev.length; j < i * prev.length + prev.length; j++){
                ans[j] = nums[i] + prev[j - i * prev.length];
            }
        }
        return ans;
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int len = s.nextInt();
        String[] nums = new String[len];
        for(int i =0; i < nums.length; i ++){
            nums[i] = s.next();
        }
        int digits = s.nextInt();
        String[] ans = nDigitNumbers(nums, digits);
        for(int i =0; i < ans.length; i ++){
            System.out.println(ans[i]);
        }

    }
}
