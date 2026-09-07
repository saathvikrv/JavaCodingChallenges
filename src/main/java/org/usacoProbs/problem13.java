package org.usacoProbs;

import java.util.Arrays;
import java.util.Scanner;

public class problem13 {
    public static void main(String[] args){
        System.out.println(Arrays.toString(pour(10, 16, 23)));

    }


    public static void hundredPours(){
        Scanner s = new Scanner(System.in);
        final int cap_a, cap_b, cap_c;
        int water_a, water_b, water_c;

        cap_a = s.nextInt();
        water_a = s.nextInt();
        cap_b = s.nextInt();
        water_b = s.nextInt();
        cap_c = s.nextInt();
        water_c = s.nextInt();
        int[] poured = new int[2];

        for(int i =0; i < 33; i++){
            poured = pour(water_a, water_b, cap_b);
            water_a = poured[0];
            water_b = poured[1];
            poured = pour(water_b, water_c, cap_c);
            water_b = poured[0];
            water_c = poured[1];
            poured = pour(water_c, water_a, cap_a);
            water_c = poured[0];
            water_a = poured[1];
        }
        poured = pour(water_a, water_b, cap_b);
        water_a = poured[0];
        water_b = poured[1];

        System.out.println(water_a);
        System.out.println(water_b);
        System.out.println(water_c);
    }

    public static int[] pour(int a, int b, int b_max){
        int poured_a = a;
        int poured_b = b;

        while(poured_a > 0 && poured_b < b_max){
            poured_a-=1;
            poured_b+=1;
        }

        return new int[]{poured_a, poured_b};
    }
 }
