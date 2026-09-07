package org.usacoProbs;

import java.util.Arrays;
import java.util.Scanner;

public class TradingCards2 {
    public static void main(String[] args){
        /*
        r ≤ N

        The total number of upgraders needed for the top r cards is at most K·L

        Each of the top r cards has rarity at least r - K
         */
        Scanner s = new Scanner(System.in);
        int amtNums = s.nextInt();
        int amtUpgrades = s.nextInt();
        int upgradeSize = s.nextInt();

        int[] arr = new int[amtNums];

        for(int i = 0; i < amtNums; i++){
            arr[i] = s.nextInt();
        }

        Arrays.sort(arr);


        int lo = 0;
        int hi = arr.length-1;
        int mid;
        while(lo < hi){
            // System.out.println(arr[lo] + ", " + arr[hi]);
            mid = (lo+ hi +1)/2;
            boolean result = check(mid, arr, amtUpgrades, upgradeSize);

            if(result){
                lo = mid;
            } else {
                hi = mid - 1;
            }

        }

        System.out.println(lo);

    }

    public static boolean check(int r, int[] nums, int upgrades, int size){
        if(r > nums.length) return false;
        int count = 0;

        for(int i = nums.length-1; i >= nums.length - r; i--){
            count += Math.max(r - nums[i], 0);
            if(count > upgrades * size || nums[i] < r - upgrades) return false;
        }

        return true;
    }

}
