package org.usacoProbs;

import java.util.HashMap;
import java.util.Scanner;

public class Midterm_3 {
    public static void main(String[] args){
        HashMap<Integer, Integer> bitPos = new HashMap<>();
        Scanner s = new Scanner(System.in);
        int records = s.nextInt();
        int a;
        int b;
        int switches = 0;
        for(int i = 0; i < records; i++){
            a = s.nextInt();
            b = s.nextInt();
            if(!bitPos.containsKey(a)){
                bitPos.put(a, b);
            } else if(bitPos.get(a) != b){
                switches++;
                bitPos.put(a, b);
            }

        }
        System.out.println(switches);
    }
}
