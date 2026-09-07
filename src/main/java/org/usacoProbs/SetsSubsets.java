package org.usacoProbs;

import java.util.Scanner;

public class SetsSubsets {
    public static String[] subsets(String[] nums, int start, int len){
        if(start == nums.length-1){
            return new String[]{"", nums[start]};
        }

        String[] prev = subsets(nums, start+1, len);
        String[] ans = new String[prev.length*2];
        System.arraycopy(prev, 0, ans, 0, prev.length);
        System.arraycopy(prev, 0, ans, prev.length, prev.length);
        for(int i =prev.length; i < ans.length; i++){
            ans[i] = nums[start] + ans[i];
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
        int size = s.nextInt();
        String[] ans = subsets(nums, 0, size);
        for(int i =1; i < ans.length; i ++){
            System.out.println(ans[i]);
        }
    }
}
