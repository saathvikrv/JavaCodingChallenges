package org.usacoProbs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Midterm_8 {
    public static void main(String[] args){
        Scanner s= new Scanner(System.in);
        int start = s.nextInt();
        int end = s.nextInt();

        int[] steps = new int[100001];
        Arrays.fill(steps, -1);

        steps[start] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(start);// add the starting index

        while(!q.isEmpty()) {
            int x = q.poll();

            if(x == end) {
                System.out.println(steps[x]);
                break;
            }

            int[] moves = {x - 1, x * 2, x + 1};
            for(int nextIndex : moves) {
                if(nextIndex >= 0 && nextIndex <= 100000 && steps[nextIndex] == -1){
                    steps[nextIndex] = steps[x] + 1;
                    q.add(nextIndex);
                    System.out.println("Added:" + nextIndex + " " + (steps[x]+ 1));
                }
            }
        }
    }
}
