package org.usacoProbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class GrassPasture {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> cowOrder = new PriorityQueue<>();
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(r.readLine());

        int amtCows = Integer.parseInt(st.nextToken());
        int maxT = Integer.parseInt(st.nextToken());
        int[] cows = new int[amtCows];

        for(int i =0; i < amtCows; i++){
            st = new StringTokenizer(r.readLine());
            cows[i] = Integer.parseInt(st.nextToken());
        }

        int lo = 1;
        int hi = amtCows;
        int mid;
        while(lo < hi){
            mid = (lo+ hi +1)/2;
            cowOrder.clear();
            int result = simulate(cowOrder, mid, cows);

            if(result > maxT){
                lo = mid;
            } else if(result < maxT){
                hi = mid-1;
            } else {
                lo = mid;
                break;
            }

        }
        System.out.println(lo);
    }

    public static int simulate(PriorityQueue<Integer> order, int K, int[] cows){
        int time = 0;
        int toAdd = 0;
        while(order.size() < K && toAdd < cows.length){
            order.add(cows[toAdd]);
            toAdd++;
        }
        while(!order.isEmpty()){
            while(!order.isEmpty() && order.peek() <= time){
                order.poll();
            }
            while(order.size() < K && toAdd < cows.length){
                order.add(cows[toAdd] + time);
                toAdd++;
            }
            time++;
        }

        return time-1;
    }
}
