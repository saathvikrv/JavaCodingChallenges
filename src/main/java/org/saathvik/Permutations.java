package org.saathvik;
import java.util.Arrays;

public class Permutations {

    public static void generate(int[] nums, int startPos) {

        if(startPos == nums.length) {
            System.out.println(Arrays.toString(nums));
        }

        for(int i=startPos; i<nums.length; i++) {

            swap(nums, startPos, i);
            generate(nums, startPos+1);
            swap(nums, startPos, i);
        }

    }

    static void swap(int[] arr, int indexOne, int indexTwo){
        int n = arr[indexOne];
        arr[indexOne] = arr[indexTwo];
        arr[indexTwo] = n;
    }
}