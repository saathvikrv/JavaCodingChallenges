package org.usacoProbs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class problem73 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int cows = s.nextInt();
        int fields = s.nextInt();
        int loglen = s.nextInt();
        int currSick = s.nextInt();
        int[][] fieldLog = new int[loglen][3];
        int[][] cowsSick = new int[currSick][2];
        for(int i =0; i < loglen; i++){
            fieldLog[i][0] = s.nextInt();
            fieldLog[i][1] = s.nextInt();
            fieldLog[i][2] = s.nextInt();
        }
        for(int i =0; i < currSick; i++){
            cowsSick[i][0] = s.nextInt();
            cowsSick[i][1] = s.nextInt();
        }


        HashSet<Integer> sickGrazed = new HashSet<>();
        HashSet<Integer> sickTotal = new HashSet<>();

        boolean[] possibleCulprits = new boolean[fields];
        Arrays.fill(possibleCulprits, false);



        for(int i =0; i < fields; i++){
            sickGrazed = new HashSet<>();
            for(int[] log : fieldLog){
                if(log[1] == i+1){
                    for(int[] sickCow : cowsSick){
                        if(sickCow[0] == log[0] && sickCow[1] > log[2]){
                            sickGrazed.add(log[0]);
                        }
                    }
                }
            if(sickGrazed.size() == cowsSick.length){
                possibleCulprits[i] = true;
            }
            }
        }
        for(int[] log : fieldLog){
            if(possibleCulprits[log[1]-1]){
                sickTotal.add(log[0]);
            }
        }
        System.out.println(sickTotal.size());
    }
}
