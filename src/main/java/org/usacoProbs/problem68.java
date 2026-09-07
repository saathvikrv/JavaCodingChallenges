package org.usacoProbs;

import java.util.Scanner;

public class problem68 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int[] farms = new int[s.nextInt()];
        int[][] pairs = new int[s.nextInt()][2];
        for(int i =0; i < pairs.length; i++){
            pairs[i][0] = s.nextInt();
            pairs[i][1] = s.nextInt();
        }


        boolean valid;
        for(int i =0; i < farms.length; i++){
            for(int j = 1; j <= 4; j++){
                farms[i] = j;
                valid = true;
                for(int[] pair : pairs){
                    if(pair[0] == i+1 || pair[1] == i+1){
                        if(farms[pair[0] - 1] == j && farms[pair[1] - 1] == j){
                            valid = false;
                            break;
                        }
                    }
                }
                if(valid){
                    break;
                }
            }
        }
        for(int i = 0; i < farms.length; i++){
            System.out.print(farms[i]);
        }
    }
}
