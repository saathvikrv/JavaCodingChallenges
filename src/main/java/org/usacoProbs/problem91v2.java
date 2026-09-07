package org.usacoProbs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.function.Function;

public class problem91v2 {
    static int[] colourList;
    static int maxValue;

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int start = s.nextInt();
        int end = s.nextInt();
        colourList = new int[s.nextInt()];
        maxValue = s.nextInt();
        for(int i = 0; i < colourList.length; i++){
            colourList[i] = s.nextInt();
        }

        Function<Integer, Integer[]> options = a -> mixingOptions(a);

        System.out.println(BFS(options, maxValue, start, end));
    }

    public static Integer[] mixingOptions(Integer a){
        Integer[] ans = new Integer[problem91v2.colourList.length];
        int count = 0;
        for(int colour : problem91v2.colourList){
            ans[count] = (a * colour) % maxValue;
            count++;
        }
        return ans;
    }

    public static int BFS(Function<Integer, Integer[]> moveOptions, int len, int startVal, int endVal){
        int[] steps = new int[len];
        Arrays.fill(steps, -1);
        steps[startVal] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(startVal);          // add the starting index
        while(!q.isEmpty()) {
            // search the elements for the current step
            int x = q.poll();
            // if reached to N th element, write the answer and exit the program
            if(x == endVal) {
                return steps[x];
            }

            // make the moves, and update the valid and not visited elements
            Integer[] moves = moveOptions.apply(x);
            for(int nextIndex : moves) {
                if(nextIndex > 0 && nextIndex < steps.length && steps[nextIndex] == -1){
                    steps[nextIndex] = steps[x] + 1;
                    q.add(nextIndex);
                }
            }
        }
        return -1;
    }
}