package org.usacoProbs;

import java.util.Scanner;

public class problem42 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int cows = s.nextInt();
        s.nextLine();
        String line = s.nextLine();
        int[] lens = new int[4];
        for(int i = 0; i < cows; i++){
            lens[i] = s.nextInt();
        }
        int gStart = -1;
        int hStart = -1;
        int gEnd = -1;
        int hEnd = -1;
        boolean gRep = false;
        boolean hRep = false;
        int count = 0;

        for(int i = 0; i < line.length(); i++){
            if(gStart == -1 && line.charAt(i) == 'G'){
                gStart = i;
            }
            if(hStart == -1 && line.charAt(i) == 'H'){
                hStart = i;
            }
            if(line.charAt(i) == 'H'){
                hEnd = i;
            }
            if(line.charAt(i) == 'G'){
                gEnd = i;
            }
        }

        if(lens[gStart]+gStart >= gEnd){
            gRep = true;

            for(int i = 0; i < gStart; i++){
                if(lens[i]+i > gStart && line.charAt(i) == 'H'){
                    count++;
                }
            }
        }

        if(lens[hStart]+hStart >= hEnd){
            hRep = true;

            for(int i = 0; i < hStart; i++){
                if(lens[i]+i > hStart && line.charAt(i) == 'G'){
                    count++;
                }
            }
        }
        if(gRep && hRep){
            count++;
        }

        System.out.println(count);



    }
}
