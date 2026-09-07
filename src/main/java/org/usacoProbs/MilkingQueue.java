package org.usacoProbs;

import java.util.*;
import java.io.*;

public class MilkingQueue {
    public static int count = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(r.readLine());

        int len = Integer.parseInt(st.nextToken());
        int[] nums = new int[len];
        HashMap<Integer, int[]> posDiffs = new HashMap<>();
        st = new StringTokenizer(r.readLine());
        for(int i = 0; i < len; i++){
            nums[i] = Integer.parseInt(st.nextToken());
            posDiffs.put(nums[i], new int[]{i, 0});
        }

        Arrays.sort(nums);

        for(int i = 0; i < len; i++){
            posDiffs.get(nums[i])[1] = i;
        }

        Iterator<Map.Entry<Integer, int[]>> i = posDiffs.entrySet().iterator();

        while(i.hasNext()){
            int[] j = i.next().getValue();
            if(j[0] != j[1]){
                count++;
            }
        }

        System.out.println(count);
    }

}

