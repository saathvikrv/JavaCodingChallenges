package org.usacoProbs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class UnfriendlyFriends {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int friends = s.nextInt();
        int bad = s.nextInt();
        int a;
        int b;

        ArrayList<int[]> badPairs = new ArrayList<>();

        for(int i =0; i < bad; i++){
            a = s.nextInt();
            b = s.nextInt();
            badPairs.add(new int[]{Math.min(a, b), Math.max(a, b)});
        }

        badPairs.sort(Comparator.comparingInt(q -> q[1]));

        int currPos = 0;
        int count = 0;
        while(!badPairs.isEmpty()){
            currPos = badPairs.getFirst()[1] - 1;
            int finalCurrPos = currPos;
            badPairs.removeIf(item -> item[0] <= finalCurrPos);
            count++;
        }

        System.out.println(count + 1);
    }
}
