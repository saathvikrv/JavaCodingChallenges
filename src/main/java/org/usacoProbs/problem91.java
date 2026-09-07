package org.usacoProbs;

import java.util.Arrays;
import java.util.Scanner;

public class problem91 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int[] distances = new int[s.nextInt()+1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[1] = 0;
        distances[0] = -1;
        update(distances, 1);
        System.out.println(distances[distances.length-1]);
    }

    public static void update(int[] distances, int toUpdate){
        int value = distances[toUpdate]+1;
        if(toUpdate == 1){
            distances[toUpdate+1] = Math.min(value, distances[toUpdate+1]);

            if(toUpdate * 3 < distances.length){
                distances[toUpdate*3] = Math.min(value, distances[toUpdate*3]);
                if(distances[toUpdate*3] == value) {
                    update(distances, toUpdate * 3);
                }
            }
            if(distances[toUpdate+1] == value) {
                update(distances, toUpdate+1);
            }

        } else if(toUpdate == distances.length-1){
            distances[toUpdate-1] = Math.min(value, distances[toUpdate-1]);
            if(distances[toUpdate-1] == value) {
                update(distances, toUpdate-1);
            }
        } else {
            distances[toUpdate+1] = Math.min(value, distances[toUpdate+1]);
            distances[toUpdate-1] = Math.min(value, distances[toUpdate-1]);
            if((toUpdate+1) * 3 < distances.length){
                distances[toUpdate*3] = Math.min(value, distances[toUpdate*3]);
                if(distances[toUpdate*3] == value) {
                    update(distances, toUpdate * 3);
                }
            }
            if(distances[toUpdate+1] == value) {
                update(distances, toUpdate+1);
            }
            if(distances[toUpdate-1] == value) {
                update(distances, toUpdate-1);
            }


        }
    }
}
