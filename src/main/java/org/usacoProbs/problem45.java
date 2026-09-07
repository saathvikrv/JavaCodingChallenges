package org.usacoProbs;

import java.util.Arrays;
import java.util.Scanner;

public class problem45 {
    public static void main(String[] args){
        Scanner s= new Scanner(System.in);
        int items = s.nextInt();
        int[] numTraits = new int[items];
        String[][] traits = new String[items][];
        for(int i =0; i < items; i ++){
            s.next();
            numTraits[i] = s.nextInt();

            traits[i] = new String[numTraits[i]];
            for(int j =0; j < numTraits[i]; j++){
                traits[i][j] = s.next();
            }

        }

        int maxShared = 0;
        int shared;
        for(int i =0; i < items; i++){
            for(int j = i+1; j < items; j++){
                shared = 0;
                for(String trait : traits[i]){
                    if(Arrays.asList(traits[j]).contains(trait)){
                        shared++;
                    }
                }
                maxShared = Math.max(shared, maxShared);
            }
        }
        System.out.println(maxShared+1);
    }

}
