package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Final_3 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int cows = s.nextInt();
        int len = s.nextInt();
        s.nextLine();
        String[] blkCows = new String[cows];
        for(int i =0; i < blkCows.length; i++){
            blkCows[i] = s.nextLine();
        }
        String[] brnCows = new String[cows];
        for(int i =0; i < brnCows.length; i++){
            brnCows[i] = s.nextLine();
        }
        boolean[] baseOccBrn = new boolean[4];
        boolean[] baseOccBlk = new boolean[4];

        int count =0;
        for(int i = 0; i < len; i++){
            Arrays.fill(baseOccBrn, false);
            Arrays.fill(baseOccBlk, false);
            for(String cow : brnCows){
                if(cow.charAt(i) == 'A'){
                    baseOccBrn[0] = true;
                } else if(cow.charAt(i) == 'T'){
                    baseOccBrn[1] = true;
                } else if(cow.charAt(i) == 'G'){
                    baseOccBrn[2] = true;
                } else if(cow.charAt(i) == 'C'){
                    baseOccBrn[3] = true;
                }

            }
            for(String cow : blkCows){
                if(cow.charAt(i) == 'A'){
                    baseOccBlk[0] = true;
                } else if(cow.charAt(i) == 'T'){
                    baseOccBlk[1] = true;
                } else if(cow.charAt(i) == 'G'){
                    baseOccBlk[2] = true;
                } else if(cow.charAt(i) == 'C'){
                    baseOccBlk[3] = true;
                }

            }
            boolean diff = true;

            for(int n =0; n < 4; n++){
                if(baseOccBrn[n] && baseOccBlk[n]){
                    diff = false;
                    break;
                }
            }
            if(diff){
                count++;

            }
        }

        System.out.println(count);
    }
}
