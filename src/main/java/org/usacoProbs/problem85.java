package org.usacoProbs;

import java.util.Arrays;
import java.util.Scanner;

public class problem85 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int words = s.nextInt();
        int queries = s.nextInt();
        stringAndInteger[] dictionary = new stringAndInteger[words];
        String[] queryWords = new String[queries];
        int[] queryOccurrenceSpots = new int[queries];
        for(int i = 0; i < words; i++){
            dictionary[i] = new stringAndInteger(s.next(), i);
        }
        Arrays.sort(dictionary);

        for(int i = 0; i < queries; i++){
            queryOccurrenceSpots[i] = s.nextInt();
            queryWords[i] = s.next();
        }

        int index;

        for(int queryNum = 0; queryNum < queries; queryNum++){
            index = smallerThan(queryWords[queryNum], dictionary);
            index -= (dictionary[index].s.startsWith(queryWords[queryNum]) ? 1 : 0);
            for(int i =0; i < queryOccurrenceSpots[queryNum]; i++){
                index++;
            }
            if(index < dictionary.length && dictionary[index].s.length() >= queryWords[queryNum].length() && dictionary[index].s.startsWith(queryWords[queryNum])){
                System.out.println(dictionary[index].a);
            } else {
                System.out.println(-1);
            }

        }
    }

    public static int smallerThan(String a, stringAndInteger[] arr){
        int lo = 0;
        int hi = arr.length-1;
        int mid;
        while(lo < hi){
            // System.out.println(arr[lo] + ", " + arr[hi]);
            mid = (lo+ hi +1)/2;
            if(arr[mid].s.compareTo(a) < 0){
                lo = mid;
            } else if(arr[mid].s.compareTo(a) > 0){
                hi = mid-1;
            } if(arr[mid].s.compareTo(a) == 0){
                return mid;
            }

        }
        return lo;
    }


    private static class stringAndInteger implements Comparable<stringAndInteger>{
        String s;
        int a;

        public stringAndInteger(String s, int a){
            this.s = s;
            this.a = a;
        }

        @Override
        public int compareTo(stringAndInteger o) {
            return s.compareTo(o.s);
        }
    }
}
