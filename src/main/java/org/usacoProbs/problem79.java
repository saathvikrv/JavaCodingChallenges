package org.usacoProbs;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class problem79 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(r.readLine());
        PrintWriter pw = new PrintWriter(System.out);


        int numAcorns = Integer.parseInt(st.nextToken());
        int numQueries = Integer.parseInt(st.nextToken());

        ArrayList<Integer> acornPos = new ArrayList<>();
        st = new StringTokenizer(r.readLine());

        for(int i =0;i < numAcorns; i++){
            acornPos.add(Integer.parseInt(st.nextToken()));
        }

        int[][] queries = new int[numQueries][2];

        for(int i =0; i< numQueries; i++){
            st = new StringTokenizer(r.readLine());
            for(int j = 0; j < 2; j++){
                queries[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Collections.sort(acornPos);
        for(int[] query : queries){
            int start = greaterThan(query[0], acornPos);
            int end = smallerThan(query[1], acornPos);
            if(query[0] < acornPos.getLast() && query[1] > 0) {
                pw.println(end - start + 1);
            } else {
                pw.println(0);
            }
        }
    }

    public static int smallerThan(int a, ArrayList<Integer> arr){
        int lo = 0;
        int hi = arr.size()-1;
        int mid;
        while(lo < hi){
            // System.out.println(arr[lo] + ", " + arr[hi]);
            mid = (lo+ hi +1)/2;
            if(arr.get(mid) < a){
                lo = mid;
            } else if(arr.get(mid) > a){
                hi = mid-1;
            } if(arr.get(mid) == a){
                return mid;
            }

        }
        return lo;
    }

    public static int greaterThan(int a, ArrayList<Integer> arr){
        int lo = 0;
        int hi = arr.size()-1;
        int mid;
        while(lo < hi){
            // System.out.println(arr[lo] + ", " + arr[hi]);
            mid = (lo+ hi)/2;
            if(arr.get(mid) < a){
                lo = mid+1;
            } else if(arr.get(mid) > a){
                hi = mid;
            } if(arr.get(mid) == a){
                return mid;
            }

        }
        return hi;
    }
}
