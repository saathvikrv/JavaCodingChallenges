package org.usacoProbs;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BarnscapeOutline {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int events = s.nextInt();
        s.nextInt();
        Set<Integer> currBarns = new HashSet<>();
        int count = 0;

        for(int i = 0; i < events; i++){
            s.nextInt();
            int yval = s.nextInt();
            currBarns.removeIf(n -> n > yval);
            if(!currBarns.contains(yval) && yval != 0){
                currBarns.add(yval);
                count++;
            }
        }

        System.out.println(count);
    }
}
