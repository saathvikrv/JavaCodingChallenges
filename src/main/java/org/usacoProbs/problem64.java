package org.usacoProbs;

import java.util.Scanner;


public class problem64 {
    public static void func(String seq, int range){
        StringBuilder stations = new StringBuilder();
        stations.append(".".repeat(seq.length()));
        int rangeEnd;
        int rangeStart;
        boolean alreadyCovered;
        int j;
        int count = 0;
        int recentG = -10000;
        int recentH = -10000;

        for(int i =0; i < seq.length(); i++){
            alreadyCovered = false;
            rangeEnd = Math.min(stations.length()-1, i+range);
            rangeStart = Math.max(0, i-range);
            j = rangeStart;
            if(seq.charAt(i) == 'H' && recentH <= rangeEnd && recentH >= rangeStart){
                alreadyCovered = true;
            }
            if(seq.charAt(i) == 'G' && recentG <= rangeEnd && recentG >= rangeStart){
                alreadyCovered = true;
            }
            if(!alreadyCovered){
                while(stations.charAt(rangeEnd) != '.'){
                    rangeEnd--;
                }
                stations.setCharAt(rangeEnd, seq.charAt(i));
                if(seq.charAt(i) == 'H'){
                    recentH = rangeEnd;
                } else {
                    recentG = rangeEnd;
                }
                count++;
            }
        }
        System.out.println(count);
        System.out.println(stations);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int tests = s.nextInt();
        int range;
        String sequence;
        for(int t = 0; t < tests; t++){
            s.nextInt();
            range = s.nextInt();
            sequence = s.next();
            func(sequence, range);
        }
    }
}
