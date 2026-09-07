package org.usacoProbs;

import java.util.Scanner;

public class problem46 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        String s = sc.nextLine();

        int min = 0;
        int max = 0;
        int[] res;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'F'){
                res = findMinMax(s, i);
                min += res[0];
                max += res[1];
                i += res[2] - 1;
            } else if(i < s.length()-1 && s.charAt(i) == s.charAt(i+1)){
                min++;
                max++;
            }
        }

        if(s.charAt(0) == 'F' || s.charAt(s.length()-1) == 'F'){
            System.out.println(max - min + 1);
            for(int i = min; i <= max; i+=1){
                System.out.println(i);
            }
        } else {
            System.out.println((max - min)/2 + 1);
            for(int i = min; i <= max; i+=2){
                System.out.println(i);
            }
        }
    }

    public static int[] findMinMax(String s, int i){
        int len = 0;
        while(i+len < s.length() && s.charAt(i+len) == 'F'){
            len++;
        }
        if(len == s.length()){
            return new int[]{0, len -1, len};
        } else if(i == 0 || i+len == s.length()){
            return new int[]{0, len, len};
        } else if(s.charAt(i-1) == s.charAt(i+len)){
            return new int[]{(len + 1) % 2, len+1, len};
        } else if(s.charAt(i-1) != s.charAt(i+len)){
            return new int[]{(len) % 2, len, len};
        } else {
            return new int[]{-1};
        }
    }
}
