package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class problem17 {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int acorns = s.nextInt();
        int[] shuffle = new int[acorns];
        int[] ids = new int[acorns];
        for(int i = 0; i < acorns; i++){
            shuffle[i] = s.nextInt();
        }

        for(int i = 0; i < acorns; i++){
            ids[i] = s.nextInt();
        }

        int[] ans = shuffle(ids, shuffle, acorns);
        ans = shuffle(ans, shuffle, acorns);
        ans = shuffle(ans, shuffle, acorns);


        for(int i = 0; i < acorns; i++) {
            System.out.println(ans[i]);
        }
    }

    public static int[] shuffle(int[] ids, int[] shuffle, int len){
        int[] result = new int[len];
        for(int i =0; i < len; i++) {
            result[i] = ids[shuffle[i] - 1];
        }


        return result;
    }
}
