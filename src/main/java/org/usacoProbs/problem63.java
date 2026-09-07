package org.usacoProbs;

import java.util.Scanner;

public class problem63 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int[] log = new int[s.nextInt()];
        for(int i = 0; i < log.length; i++){
            log[i] = s.nextInt();
        }


        for(int i = log.length-1; i > 0; i--){
            if(log[i] > 0){
                if(log[i-1] != -1 || log[i-1] != log[i]-1){
                    System.out.println(-1);
                    System.exit(0);
                }

                log[i-1] = log[i]-1;
            }
        }

        int zeros = 0;
        int unknowns = 0;

        for(int i =0; i < log.length; i++){
            if(log[i] == 0){
                zeros++;
            }
            if(log[i] == -1){
                unknowns++;
            }
        }
        int min = zeros;
        int max = zeros + unknowns;
        System.out.println(min + " " + max);
    }
}
