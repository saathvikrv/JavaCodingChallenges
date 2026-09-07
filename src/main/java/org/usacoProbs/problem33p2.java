package org.usacoProbs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class problem33p2 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int len = s.nextInt();
        int onlineAmount = s.nextInt();
        int time = s.nextInt();
        int[] online = new int[onlineAmount];
        for(int i = 0; i < onlineAmount; i++){
            online[i] = s.nextInt();
        }

        findStartingStackHeight(online, time+1, len);
    }

    public static void findStartingStackHeight(int[] online, int time, int listLen){
        HashMap<Integer, Integer[]> startStacks = new HashMap<>();
        int i = online[0];
        int startHeight = 0;
        for(int pos = 0; pos < online.length; pos++){
           while(i < online[pos]){
               i++;
               startHeight++;
               startStacks.put(i-1, new Integer[]{startHeight, pos});
           }
           startHeight = 0;
        }
        i = online[online.length-1];
        while(i < listLen){
            i++;
            startHeight++;
            startStacks.put(i-1, new Integer[]{startHeight, 0});
        }
        i = 0;
        while(i < online[0]){
            i++;
            startHeight++;
            startStacks.put(i-1, new Integer[]{startHeight, 0});
        }

        for (Map.Entry<Integer, Integer[]> entry : startStacks.entrySet()) {
            Integer key = entry.getKey();
            Integer[] value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + Arrays.toString(value));
        }
        int[] endPos = new int[listLen];
        int height;
        int distLeft;
        int hDist;
        for(int index  = 0; index < listLen; index++){
            startHeight = startStacks.get(index)[0];
            height = startStacks.get(index)[1];
            if(height == 0){
                height = listLen- online[online.length-1] + online[0];
            } else {
                height = online[height] - online[height-1];
            }
            distLeft = time - startHeight;
            hDist = (Math.ceilDiv(distLeft, height)* height+index) % listLen;
            endPos[hDist] = index;
        }
        System.out.println(Arrays.toString(endPos));

//        int q = Integer.MAX_VALUE;
//        for(int i = 0 ; i < online.length; i++){
//            q = online[i];
//            if(q - index > 0){
//                q = i;
//                break;
//            }
//        }
//
//        if(q == Integer.MAX_VALUE){
//            q = 0;
//        }
//
//        int stackHeight =0;
//
//        if(q != 0){
//           stackHeight = online[q] - online[q-1];
//            int n = stackHeight+1;
//            int i = online[q];
//            while(i > index){
//                i--;
//                n--;
//            }
//        } else {
//           stackHeight = listLen - online[online.length-1] + online[0];
//           int n = stackHeight+1;
//           int i = online[q];
//           while(){
//
//           }
//        }

    }
}
