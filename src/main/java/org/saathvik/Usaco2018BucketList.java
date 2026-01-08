//package org.saathvik;

/**
 * Farmer John is considering a change in how he allocates buckets for milking his cows. He thinks this will ultimately allow him to use a small number of total buckets, but he is not sure how many exactly. Please help him out!
 * Farmer John has N cows (1≤N≤100), conveniently numbered 1…N. The ith cow needs to be milked from time si to time ti, and requires bi buckets to be used during the milking process. Several cows might end up being milked at the same time; if so, they cannot use the same buckets. That is, a bucket assigned to cow i's milking cannot be used for any other cow's milking between time si and time ti. The bucket can be used for other cows outside this window of time, of course. To simplify his job, FJ has made sure that at any given moment in time, there is at most one cow whose milking is starting or ending (that is, the si's and ti's are all distinct).
 *
 * FJ has a storage room containing buckets that are sequentially numbered with labels 1, 2, 3, and so on. In his current milking strategy, whenever some cow (say, cow i) starts milking (at time si), FJ runs to the storage room and collects the bi buckets with the smallest available labels and allocates these for milking cow i.
 *
 * Please determine how many total buckets FJ would need to keep in his storage room in order to milk all the cows successfully.
 *
 *
 */

import java.io.*;
import java.util.*;


public class Usaco2018BucketList {
    public static void main(String[] args) throws IOException{
        String in = "blist.in";
        String out = "blist.out";

        BufferedReader r = new BufferedReader(new FileReader(in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(out)));

        final int n = Integer.parseInt(r.readLine());

        int[] Bi = new int[n];
        int[] Si = new int[n];
        int[] Ti = new int[n];

        for(int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            Si[i] = Integer.parseInt(st.nextToken());
            Ti[i] = Integer.parseInt(st.nextToken());
            Bi[i] = Integer.parseInt(st.nextToken());
        }

        r.close();

        pw.println(bucketListV2(n, Bi, Si, Ti));


        pw.close();
    }


    /*public static int bucketList(int n, int[] buckets, int[] start, int[] end) {
        int mostBuckets = 0;
        int currentBuckets = 0;
        for(int time=0; time<1000; time++) {
            for(int j = 0; j<start.length; j++) {
                if(start[j]==time) {
                    currentBuckets += buckets[j];
                }
                else if(end[j]==time) {
                    currentBuckets -= buckets[j];
                }
            }
            if(mostBuckets<currentBuckets) {
                mostBuckets = currentBuckets;
            }
        }





        return mostBuckets;
    }*/


    public static int bucketListV2(int n, int[] buckets, int[] start, int[] end) {
        List<Event> events = new ArrayList<>();
        for (int i=0; i< start.length; i++) {
            events.add(new Event(start[i], buckets[i]));
            events.add(new Event(end[i], -buckets[i]));
        }
        events.sort(Comparator.comparingInt(o -> o.time));
        int currentBuckets = 0;
        int maxBuckets = 0;
        for(int i=0; i<events.size();i++) {
            currentBuckets += events.get(i).capacityChange;
            maxBuckets = Math.max(maxBuckets, currentBuckets);
        }
        return maxBuckets;
    }
}


class Event {
    int time;
    int capacityChange;
    public Event(int t, int c) {
        time = t;
        capacityChange = c;
    }
}

