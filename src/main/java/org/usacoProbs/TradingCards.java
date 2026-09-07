package org.usacoProbs;

import java.util.Arrays;
import java.util.Scanner;

public class TradingCards {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int amtNums = s.nextInt();
        int amtUpgrades = s.nextInt();
        int upgradeSize = s.nextInt();

        int[] nums = new int[amtNums];
        for(int i = 0; i < amtNums; i++){
            nums[i] = s.nextInt();
        }

        Arrays.sort(nums);
        for(int i = 0; i < amtUpgrades; i++){
            for(int j = 0; j < upgradeSize; j++){
                nums[j]++;
            }
            Arrays.sort(nums);
        }

        int i = nums.length-1;
        int n = 1;
        while(i >=0 && nums[i] >= n){
            n++;
            i--;
        }

        System.out.println(n-1);
    }
}
