package org.usacoProbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FarmerJohnsFencingDilemma {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(r.readLine());
        PrintWriter pw = new PrintWriter(System.out);

        int[] sections = new int[Integer.parseInt(st.nextToken())];
        int queries = Integer.parseInt(st.nextToken());
        for(int i =0; i < sections.length; i++){
            st = new StringTokenizer(r.readLine());
            sections[i] = Integer.parseInt(st.nextToken());
        }

        int[][] sectionPrefixSums = new int[sections.length][3];
        sectionPrefixSums[0][0] = 0;
        sectionPrefixSums[0][1] = 0;
        sectionPrefixSums[0][2] = 0;
        sectionPrefixSums[0][sections[0]-1]++;

        for(int i = 1; i < sections.length; i++){
            sectionPrefixSums[i][0] = sectionPrefixSums[i-1][0];
            sectionPrefixSums[i][1] = sectionPrefixSums[i-1][1];
            sectionPrefixSums[i][2] = sectionPrefixSums[i-1][2];
            sectionPrefixSums[i][sections[i]-1]++;
        }

        int[] query = new int[2];

        for(int q = 0; q < queries; q++){
            st = new StringTokenizer(r.readLine());
            query[0] = Integer.parseInt(st.nextToken());
            query[1] = Integer.parseInt(st.nextToken());
            if(query[0] == 1){
                pw.println(sectionPrefixSums[query[1]-1][0] + " " +
                                   sectionPrefixSums[query[1]-1][1] + " " +
                                   sectionPrefixSums[query[1]-1][2]);
            } else {
                pw.println((sectionPrefixSums[query[1]-1][0] - sectionPrefixSums[query[0]-2][0]) + " " +
                                   (sectionPrefixSums[query[1]-1][1] - sectionPrefixSums[query[0]-2][1]) + " " +
                                   (sectionPrefixSums[query[1]-1][2] - sectionPrefixSums[query[0]-2][2]));
            }
        }
        r.close();
        pw.close();
    }
}
