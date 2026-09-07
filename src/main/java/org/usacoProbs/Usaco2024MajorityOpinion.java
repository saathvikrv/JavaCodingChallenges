package org.usacoProbs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Usaco2024MajorityOpinion {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        int listLen;
        String ans;
        Object[] ansArray;
        String line;
        int[] hays;
        //System.out.println("");
        for(int i = 0; i < testCases; i++){
            listLen = Integer.parseInt(scanner.nextLine());
            hays = new int[listLen];
            for(int j = 0; j < listLen; j++){
                hays[j] = scanner.nextInt();
            }
            ansArray = majorityOpinion(hays).toArray();
            Arrays.sort(ansArray);
            ans = Arrays.toString(ansArray);
            ans = ans.replace("[", "");
            ans = ans.replace("]", "");
            ans = ans.replace(",", "");
            System.out.println(ans);
            scanner.nextLine();
        }
    }



    public static Set<Integer> majorityOpinion(int[] cowHays){

        Set<Integer> possibleHays = new HashSet<>();

        if(cowHays.length == 2 && cowHays[0] == cowHays[1]){
            possibleHays.add(cowHays[0]);
        } else if(cowHays.length == 2){
            possibleHays.add(-1);
        } else {
            for (int i = 0; i + 2 < cowHays.length; i++) {
                if (hasMajority(cowHays[i], cowHays[i + 1], cowHays[i + 2]) != -1) {

                    possibleHays.add(hasMajority(cowHays[i], cowHays[i + 1], cowHays[i + 2]));
                }
            }
            if(possibleHays.isEmpty()){
                possibleHays.add(-1);
            }

        }
        return possibleHays;
    }

    public static int hasMajority(int a, int b, int c){
        if(a == b || b == c || a == c){
            if(a == b){
                return b;
            } else {
                return c;
            }
        } else {
            return -1;
        }
    }




    /*public static int[] focusGroup(int[] cows){
        int maxFreq = 0;

        HashMap<Integer,Integer> hayFreq = new HashMap<>();
        int currentVal;
        for(int i = 0; i < cows.length; i++){
            if(hayFreq.containsKey(cows[i])) {
                currentVal = hayFreq.get(cows[i]);
                hayFreq.put(cows[i], currentVal + 1);
            } else {
                hayFreq.put(cows[i], 1);
            }
            if(hayFreq.get(cows[i])>maxFreq){
                maxFreq = i;
            }
        }

        if(hayFreq.get(cows[maxFreq]) > cows.length / 2 ){


            return Arrays.fill(cows, maxFreq);
        } else {
            return cows;
        }
    }*/


}
