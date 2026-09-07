package org.usacoProbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Final_7 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(r.readLine());
        int lines = Integer.parseInt(st.nextToken());
        int[][] cows = new int[lines][2];
        for(int i =0; i < lines; i++){
            st = new StringTokenizer(r.readLine());
            cows[i][1] = Integer.parseInt(st.nextToken());
            cows[i][0] = Integer.parseInt(st.nextToken());
        }
        r.close();

        Arrays.sort(cows, Comparator.comparing((int[] q) -> q[0]));
        int max = 0;
        int backValLeft = cows[cows.length-1][1];
        int frontValLeft = cows[0][1];
        int currFrontVal = 0;
        int currBackVal = cows.length - 1;
        while(currBackVal > currFrontVal){
            if(backValLeft > frontValLeft) {
                backValLeft -= frontValLeft;
                currFrontVal++;
                frontValLeft = cows[currFrontVal][1];
            } else if(backValLeft < frontValLeft){
                frontValLeft -= backValLeft;
                currBackVal--;
                backValLeft = cows[currBackVal][1];
            } else {
                currBackVal--;
                backValLeft = cows[currBackVal][1];
                currFrontVal++;
                frontValLeft = cows[currFrontVal][1];
            }
            if(cows[currFrontVal][0] + cows[currBackVal][0] > max){
                max = cows[currFrontVal][0] + cows[currBackVal][0];
            } else {
                // break;
            }
        }

        System.out.println(max);
    }
}
