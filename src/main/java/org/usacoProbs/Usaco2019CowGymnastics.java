package org.usacoProbs;

import java.io.*;
import java.util.Scanner;

public class Usaco2019CowGymnastics {
    public static void main(String[] args) throws IOException {
        String in = "gymnastics.in";
        String out = "gymnastics.out";


//        Scanner s = new Scanner(new FileReader(in));
        Scanner s = new Scanner(System.in);
        int numSessions = s.nextInt();
        int cows = s.nextInt();

        int[][] sessions = new int[numSessions][cows];

        for(int i = 0; i < numSessions; i++){
            for(int j = 0; j < cows; j++){
                sessions[i][j] = s.nextInt();
            }
        }

        int count = 0;
        boolean cons1;
        boolean cons2;

        for(int cow1 = 1; cow1 <= cows; cow1++){
            for(int cow2 = cow1 + 1; cow2 <= cows; cow2++){
                cons1 = true;
                cons2 = true;
                for(int[] session : sessions){
                    if(indexOf(session, cow1) <= indexOf(session, cow2)){
                        cons1 = false;
                    } else if(indexOf(session, cow1) >= indexOf(session, cow2)){
                        cons2 = false;
                    }
                }
                if(cons1){count++;}
                if(cons2){count++;}
            }
        }

//        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(out)));
//        pw.println(count);
//        pw.close();
        System.out.println(count);
    }

    public static int indexOf(int[] arr, int num){
        int i = 0;
        while(i < arr.length && arr[i] != num){
            i++;
        }
        return i;
    }
}
