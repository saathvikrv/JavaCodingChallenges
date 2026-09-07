//package org.saathvik;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Usaco2019MilkFactory {
    public static void main(String[] args) throws IOException {
        String in = "factory.in";
        String out = "factory.out";

        Scanner s = new Scanner(new FileReader(in));
        int stations = s.nextInt();
        int[] startPts = new int[stations-1];
        int[] endPts = new int[stations-1];

        for(int i =0; i < stations-1; i++){
            startPts[i] = s.nextInt();
            endPts[i] = s.nextInt();
        }

        boolean[] leaveExists = new boolean[stations];
        Arrays.fill(leaveExists, false);

        for(int i = 0; i < stations-1; i++){
            leaveExists[startPts[i] - 1] = true;
        }
        boolean works = true;
        boolean works2 = true;
        int centre = -1;

        for(int station  = 0; station < leaveExists.length; station++){
            if(!leaveExists[station]){
                if(works) {
                    works = false;
                    centre = station + 1;
                } else {
                    works2 = false;
                    break;
                }
            }
        }

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(out)));

        if(works2){
            pw.println(centre);
        }
        if(!works2){
            pw.println(-1);
        }

        pw.close();
    }
}
