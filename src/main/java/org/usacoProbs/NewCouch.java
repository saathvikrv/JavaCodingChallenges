package org.usacoProbs;

import java.util.Arrays;
import java.util.Scanner;

public class NewCouch {
    public static int max;

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int len = s.nextInt();
        int[] nums = new int[len];

        for(int i =0; i < nums.length; i ++){
            nums[i] = s.nextInt();
        }

        boolean[] used = new boolean[nums.length];

        generate(0, used, nums, 0);
        System.out.println(max);
    }

    public static int findPlace(int num, double place){
        return (int) (num/(place)) % 10;
    }

    public static void generate(int start, boolean[] used, int[] nums, int amtUsed){
        if(start == used.length){
            process(used, nums, amtUsed);
        } else {
            generate(start + 1, used, nums, amtUsed);
            used[start] = true;
            generate(start + 1, used, nums, amtUsed+1);
            used[start] = false;
        }
    }

    public static void process(boolean[] used, int[] nums, int amtUsed){
        int[] places = new int[9];
        boolean works;

        Arrays.fill(places, 0);
        works = true;
        for (int j = 0; j < nums.length; j++) {
            if(used[j]) {
                for (int i = 0; i < 9; i++) {
                    places[i] += findPlace(nums[j], Math.pow(10, i));
                    if (places[i] >= 10) {
                        works = false;
                        break;
                    }
                }
                if (!works) {
                    break;
                }
            }
        }
        if(works){
            max = Math.max(max, amtUsed);
        }
    }
}

/*
238493490
find digit at 5

23849


 */
