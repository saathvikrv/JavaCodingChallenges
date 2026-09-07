package org.usacoProbs;

import java.util.Arrays;
import java.util.Scanner;

public class problem40 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        final long a = s.nextLong();
        final long b = s.nextLong();
        final long c = s.nextLong();
        long[] nums = {a, b, c};
        Arrays.sort(nums);
        long max = Math.max(nums[1]-nums[0], nums[2]-nums[1]);
        long min;
        if(nums[2]-nums[1] == 1 && nums[1]-nums[0] == 1){
            min = 0;
        } else if(nums[2]-nums[1] == 2 || nums[1]-nums[0] == 2){
            min = 1;
        } else {
            min = 2;
        }
        System.out.println(min);
        System.out.println(max);
    }
}
