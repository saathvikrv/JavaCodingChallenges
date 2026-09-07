package org.usacoProbs;

import java.util.ArrayList;
import java.util.Scanner;

public class RectangularHoleV2 {
    public static ArrayList<ArrayList<Integer>> subsets(int[] nums, int start){
        if(start == nums.length-1){
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<>());
            ans.add(new ArrayList<>());
            ans.getFirst().add(nums[start]);
            return ans;
        }

        ArrayList<ArrayList<Integer>> prev = subsets(nums, start+1);
        int prevLen = prev.size();

        for(int i = 0; i < prevLen; i++){
            prev.add((ArrayList<Integer>) prev.get(i).clone());
            prev.get(i).add(nums[start]);
        }
        return prev;
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int len = s.nextInt();
        int depth = s.nextInt();
        int[] nums = new int[len];

        for(int i =0; i < nums.length; i ++){
            nums[i] = s.nextInt();
        }

        ArrayList<ArrayList<Integer>> ans = subsets(nums, 0);
        int min  = Integer.MAX_VALUE;
        int acc;

        for(ArrayList<Integer> n : ans){
            acc = 0;
            for (Integer integer : n) {
                acc += integer;
            }
            if(acc > depth){
                min = Math.min(min, acc - depth);
            }
        }

        System.out.println(min);
    }
}
