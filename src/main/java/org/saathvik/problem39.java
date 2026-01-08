package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class problem39 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int[] recipeLikes = new int[s.nextInt()];
        int likes = s.nextInt();

        for(int i =0; i < recipeLikes.length; i++){
            recipeLikes[i] = s.nextInt();
        }

        Arrays.sort(recipeLikes);
        int rIndex = findRIndex(recipeLikes);

        int i = 0;
        while(recipeLikes[i] < rIndex) {
            i++;
        }
        boolean enoughStacks = recipeLikes.length-i > rIndex;

        while(i < recipeLikes.length && recipeLikes[i] == rIndex) {
            i++;
        }
        int addedStacks = recipeLikes.length-i;
        if(likes+addedStacks >= rIndex+1 && enoughStacks){
            System.out.println(findRIndex(recipeLikes)+1);
        } else {
            System.out.println(findRIndex(recipeLikes));
        }





    }

    public static int findRIndex(int[] likes){
        int currRIndex = 0;

        for(int i = 1; i <= likes.length; i++){
            currRIndex = Math.max(currRIndex, Math.min(i, likes[likes.length-i]));
            if(likes[likes.length-i] <= i && likes[likes.length-i] > currRIndex){
                return likes[likes.length-i];
            }
        }
        return currRIndex;
    }
}

