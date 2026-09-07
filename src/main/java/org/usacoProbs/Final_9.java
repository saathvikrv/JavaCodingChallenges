package org.usacoProbs;
import java.util.Scanner;

public class Final_9 {
    public static int count;

    public static void subsets(String[] nums, boolean[] removed,  int removedSoFar, int targetLength, int start){
        if(nums.length - removedSoFar == targetLength){
            for(int i =0; i < nums.length; i++){
                if(removed[i]){
                    System.out.print(nums[i]);
                }
            }
            count++;
            System.out.println();
            return;
        }

        for(int i = start; i < removed.length; i++){
            if(!removed[i]){
                removed[i] = true;
                subsets(nums, removed, removedSoFar+1, targetLength, start + 1);
                removed[i] = false;
                subsets(nums, removed, removedSoFar, targetLength, start + 1);
                break;
            }
        }
        //4
        //9 2 1 7
        //1
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int len = s.nextInt();
        String[] nums = new String[len];
        for(int i =0; i < nums.length; i ++){
            nums[i] = s.next();
        }
        int size = len - s.nextInt();
        count = 0;
        boolean[] removed = new boolean[len];
        subsets(nums, removed, 0, size, 0);
        // System.out.println(count);
    }
}
