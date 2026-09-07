package org.usacoProbs;

import java.util.Arrays;
import java.util.Scanner;

public class problem47 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int[][] rocks = new int[s.nextInt()][2];
        for(int i = 0; i < rocks.length; i++){
            rocks[i][0] = s.nextInt();
            rocks[i][1] = s.nextInt();
        }


        int area = 0;
        for(int[] rock1 : rocks){
            for(int[] rock2 : rocks){
                if(rock1[0] != rock2[0] && rock1[1] != rock2[1]){
                    for(int[] rock3 : rocks){
                        if(Arrays.equals(rock3, new int[]{rock1[0], rock2[1]}) || Arrays.equals(rock3, new int[]{rock2[0], rock1[1]})){
                            area = Math.max(area, Math.abs(rock1[0]-rock2[0])* Math.abs(rock1[1]-rock2[1]));
                        }
                    }
                }
            }
        }
        System.out.println(area);
    }
}
