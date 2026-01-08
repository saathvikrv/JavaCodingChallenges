package org.saathvik;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Usaco2020SocialDistancing1 {

    public static void main(String[] args) throws IOException{
        String in = "socdist1.in";
        String out = "socdist1.out";

        BufferedReader r = new BufferedReader(new FileReader(in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(out)));

        int l1 = Integer.parseInt(r.readLine());
        String l2 = r.readLine();

        r.close();

        pw.println(socialDistancing(l1, l2));

        pw.close();
    }

    int findLargestGap(String stalls){
        List<Integer> gaps = new ArrayList<>();
        int currentGap = 0;
        for(int i = 0; i < stalls.length(); i++){
            if(stalls.charAt(i) == '0'){
                currentGap += 1;
            } else {
                gaps.add(currentGap);
                currentGap = 0;
            }
        }
        int max = -1;
        for(int i = 0; i < gaps.size(); i++){
            max = Math.max(max, gaps.get(i));
        }

        return max;
    }

    public static int[] checkFirstLast(int stallNum, String stalls){
        int[] firstLast =  new int[2];
        int i = 0;

        while(i < stallNum && stalls.charAt(i) == '0'){
            i++;
        }

        System.out.println(i);
        firstLast[0] = i;
        i = stallNum - 1;

        while(i >= 0 && stalls.charAt(i) == '0'){
            i--;
        }


        System.out.println(stallNum - 1- i);
        firstLast[1] = stallNum - 1 - i;



        return firstLast;
    }
















    public static int socialDistancing(int stallNum, String stalls){
        int max1 = 0;
        int max2 = 0;
        int currentGap = 0;
        int min = -1;
        boolean oneGap = true;
        int firstGap = checkFirstLast(stallNum, stalls)[0];
        int lastGap = checkFirstLast(stallNum, stalls)[1];

        if(firstGap == stallNum){
            return stallNum - 1;
        }

        for(int i = 0; i < stallNum; i++){
            if(stalls.charAt(i) == '0'){
                currentGap ++;
            } else {
                if(min == -1 || min > currentGap){
                    if(i > 0) {
                        min = currentGap;
                        oneGap = false;
                    }
                }
                currentGap = 0;
            }
            if(currentGap >= max1){
                if(!oneGap) {
                    max2 = max1;
                }
                max1 = currentGap;
            }
        }

        System.out.println("max1");
        System.out.println(max1);
        System.out.println("max2");
        System.out.println(max2);
        System.out.println("min");
        System.out.println(min);

        int gap;

        if(min == -1){
            min = 2000000000;
        }

        int otherGaps = Math.max(Math.min(firstGap, lastGap), Math.floorDiv(Math.max(firstGap, lastGap), 2));

        if(max1 > 2 * max2 || max2 == 0){
            gap = Math.floorDiv(max1-2, 3);
        } else {
            gap = Math.floorDiv(max2, 2);
        }

        gap = Math.max(gap, otherGaps-1);

        return Math.min(min, gap) + 1;
    }


}
