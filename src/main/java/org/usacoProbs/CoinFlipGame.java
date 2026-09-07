package org.usacoProbs;

import java.util.Scanner;

public class CoinFlipGame {
    public static void main(String[] args){
        String[] ans = lines(new Scanner(System.in).nextInt());
        for(String line : ans){
            System.out.println(line);
        }
    }

    public static String[] lines(int num){
        if(num == 1){
            return new String[]{"0", "1"};
        }

        String[] prev = lines(num-1);
        String[] ans = new String[prev.length*2];
        System.arraycopy(prev, 0, ans, 0, prev.length);
        System.arraycopy(prev, 0, ans, prev.length, prev.length);
        for(int i =0; i < prev.length; i++){
            ans[i] = "0 " + ans[i];
        }
        for(int i =prev.length; i < ans.length; i++){
            ans[i] = "1 " + ans[i];
        }

        return ans;
    }
}
