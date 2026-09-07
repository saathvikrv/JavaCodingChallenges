package org.usacoProbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AcornCollection {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(r.readLine());
        int lines = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()) - 1;
        int adjectives = 0;
        String firstLine = r.readLine();
        st = new StringTokenizer(firstLine);
        while(!st.nextToken().equals("acorn.")){
            adjectives++;
        }
        adjectives -= 4;
        String[][] harryDoesntHave = new String[lines][adjectives];

        st = new StringTokenizer(firstLine);
        st.nextToken();
        st.nextToken();
        st.nextToken();
        st.nextToken();
        for(int j = 0; j < adjectives; j++){
            harryDoesntHave[0][j] = st.nextToken();
        }
        st.nextToken();



        for(int i =1; i < lines; i++){
            st = new StringTokenizer(r.readLine());
            st.nextToken();
            st.nextToken();
            st.nextToken();
            st.nextToken();
            for(int j = 0; j < adjectives; j++){
                harryDoesntHave[i][j] = st.nextToken();
            }
            st.nextToken();
        }

        ArrayList<String>[] options  = new ArrayList[adjectives];

        HashSet<String> opts = new HashSet<>();

        for(int i = 0; i < adjectives; i++){
            for(int j = 0; j < lines; j++) {
                opts.add(harryDoesntHave[j][i]);
            }
            options[i] = new ArrayList<>(opts);
            Collections.sort(options[i]);
            opts.clear();
        }

        int[] values = new int[lines];
        int[] multAcc = new int[adjectives];
        int acc = 1;

        for(int i = adjectives-1; i >= 0; i--){
            multAcc[i] = acc;
            acc *= options[i].size();
        }

        int n = 0;

        for(String[] line : harryDoesntHave){
            acc = 0;
            int i = 0;
            for(String adj : line){
                acc += options[i].indexOf(adj) * multAcc[i];
                i++;
            }
            values[n] = acc;
            n++;
        }

        for(int value : values){
            if(value < K){
                K++;
            }
        }

        String[] result = new String[adjectives];

        acc = 0;
        for(int value : multAcc){
            n = K / value;
            System.out.print(options[acc].get(n));
            K %= value;
            if(acc < adjectives-1){
                System.out.print(" ");
            }
            acc++;
        }


    }

}

/*
small green smooth
big brown smooth
big red shiny
small brown shiny

big, small - 2
brown, green, red - 3
shiny, smooth, 2

b b sh - 0 0 0 = 0
b b sm - 0 0 1 = 1 X
b g sh - 0 1 0 = 2
b g sm - 0 1 1 = 3
b r sh - 0 2 0 = 4 X
b r sm - 0 2 1 = 5
s b sh - 1 0 0 = 6 X
s b sm - 1 0 1 = 7
s g sh - 1 1 0 = 8
s g sm - 1 1 1 = 9 X
s r sh - 1 2 0 = 10
s r sm - 1 2 1 = 11

*/
