package org.saathvik;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Usaco2016DiamondCollector {

    public static void main(String[] args) throws IOException{
        int[] stoneCollection = {84, 87, 78, 16, 94, 36, 87, 93, 50, 22, 63, 28, 91, 60, 64, 27, 41, 27, 73, 37};
        System.out.println(diamondCollector(stoneCollection, 20));
        /*
        String in = "diamond.in";
        String out = "diamond.out";

        BufferedReader r = new BufferedReader(new FileReader(in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(out)));

        StringTokenizer st = new StringTokenizer(r.readLine());

        final int n = Integer.parseInt(st.nextToken());
        int rockSizeTolerance = Integer.parseInt(st.nextToken());

        int[] rockSizes = new int[n];

        for(int i = 0; i < n; i++){
            rockSizes[i] = Integer.parseInt(r.readLine());
        }

        r.close();

        pw.println(diamondCollector(rockSizes, rockSizeTolerance));


        pw.close();

         */
    }

    public static int diamondCollector(int[] stones, int tolerance){
        Arrays.sort(stones);
        int i = 0;
        int j = stones.length - 1;
        while(stones[j] - stones[i] > tolerance){
            if(stones[i + 1] - stones[i] >= stones[j] - stones[j - 1]){
                i += 1;
            } else {
                j -= 1;
            }
        }

        return j - i + 1;
    }

}
