package org.saathvik;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * While the age-old question of why chickens cross roads has been addressed in great depth by the scientific community, surprisingly little has been published in the research literature on the related subject of cow crossings. Farmer John, well-aware of the importance of this issue, is thrilled when he is contacted by a local university asking for his assistance in conducting a scientific study of why cows cross roads. He eagerly volunteers to help.
 * As part of the study, Farmer John has been asked to document the number of times each of his cows crosses the road. He carefully logs data about his cows' locations, making a series of N observations over the course of a single day. Each observation records the ID number of a cow (an integer in the range 1…10, since Farmer John has 10 cows), as well as which side of the road the cow is on.
 *
 * Based on the data recorded by Farmer John, please help him count the total number of confirmed crossings. A confirmed crossing occurs when a consecutive sightings of a cow place it on different sides of the road.
 */

public class Usaco2017WhyDidTheCowCrossTheRoad {

    public static void main(String[] args) throws IOException{
        String in = "data/Usaco2017WhyDidTheCowCrossTheRoad/crossroad.in";
        String out = "data/Usaco2017WhyDidTheCowCrossTheRoad/crossroad.out";

        BufferedReader r = new BufferedReader(new FileReader(in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(out)));

        final int n = Integer.parseInt(r.readLine());

        int[] cowids = new int[n];
        int[] cowsides = new int[n];

        for(int i = 0; i<n; i++) {

            StringTokenizer st = new StringTokenizer(r.readLine());
            cowids[i] = Integer.parseInt(st.nextToken());
            cowsides[i] = Integer.parseInt(st.nextToken());
        }

        r.close();

        pw.println(whyDidTheCowCrossTheRoad(n, cowids, cowsides));

        pw.close();






    }

    public static int whyDidTheCowCrossTheRoad(int n, int[] ids, int[] sides) {
        HashMap<Integer, Integer> crossings = new HashMap<Integer, Integer>();

        int confirmedCrossings = 0;

        int val;

        for(int i = 0; i < n; i++) {

            if(crossings.containsKey(ids[i]) == true) {

                val = crossings.put(ids[i], crossings.get(ids[i])+1);
                confirmedCrossings+=1;

            } else {

                crossings.put(ids[i], 0);

            }
        }

        

        return confirmedCrossings;
    }
}
