package org.usacoProbs;

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



    public static int bucketListV2(int n, int[] buckets, int[] start, int[] end) {
        List<Event> events = new ArrayList<>();
        for (int i=0; i< start.length; i++) {
            events.add(new Event(start[i], buckets[i]));
            events.add(new Event(end[i], -buckets[i]));
        }
        events.sort(Comparator.comparingInt(o -> o.time));
        int currentBuckets = 0;
        int maxBuckets = 0;
        for (Event event : events) {
            currentBuckets += event.capacityChange;
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

