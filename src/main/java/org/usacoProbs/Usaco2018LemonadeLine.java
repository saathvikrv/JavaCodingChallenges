//package org.saathvik;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Usaco2018LemonadeLine {
    public static void main(String[] args) throws IOException{
        String in = "lemonade.in";
        String out = "lemonade.out";

        BufferedReader r = new BufferedReader(new FileReader("lemonade.in"));

        int cows = Integer.parseInt(r.readLine());
        int[] cowWaitTimes = new int[cows];
        Scanner s = new Scanner(r.readLine());
        r.close();
        for(int i=0; i < cows; i++){
            cowWaitTimes[i] = s.nextInt();
        }
        minCows(cowWaitTimes);
        s.close();
    }

    public static void minCows(int[] waitTimes) throws IOException{
        // Ex [1, 1, 2, 3, 2, 5, 5, 4]
        Arrays.sort(waitTimes);
        ArrayList<Integer> order = new ArrayList<>();
        for(int i = waitTimes.length-1; i  >= 0; i-- ){
            if(order.size() <= waitTimes[i]){
                order.add(waitTimes[i]);
            }
        }
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lemonade.out")));
        pw.println(order.size());
        pw.close();
    }
}
