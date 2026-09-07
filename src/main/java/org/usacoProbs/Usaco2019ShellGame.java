//package org.saathvik;

import java.io.*;
import java.util.StringTokenizer;

public class Usaco2019ShellGame {
    public static void main(String[] args) throws IOException{
        String in = "shell.in";
        String out = "shell.out";

        BufferedReader r = new BufferedReader(new FileReader(in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(out)));

        int switches = Integer.parseInt(r.readLine());

        int[] a = new int[switches];
        int[] b = new int[switches];
        int[] g = new int[switches];

        for(int i = 0; i < switches; i++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            g[i] = Integer.parseInt(st.nextToken());
        }
        r.close();

        pw.println(Math.max(Math.max(shellGame(a, b, g, 1), shellGame(a, b, g, 2)), shellGame(a, b, g, 3)));

        pw.close();
    }

    public static int shellGame(int[] a, int[] b, int[] g, int pebble){
        int score = 0;


        for(int i = 0; i < a.length; i++){
            pebble = shellSwitch(a[i], b[i], pebble);
            if(g[i] == pebble){
                score +=1;
            }
        }
        return score;
    }


    public static int shellSwitch(int a, int b, int pebbleLoc){
        if(pebbleLoc != a && pebbleLoc != b){
            return pebbleLoc;
        } else if(pebbleLoc == a){
            return b;
        } else {
            return a;
        }

    }
}
