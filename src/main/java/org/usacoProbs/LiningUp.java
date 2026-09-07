package org.usacoProbs;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class LiningUp {
    public static void main(String[] args){
        Scanner s= new Scanner(System.in);
        int N = s.nextInt();
        int[] A = new int[N];
        for(int i =0; i < N; i++){
            A[i] = s.nextInt();
        }


        int[] NGE = new int[N];
        Arrays.fill(NGE, 0);

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++) {
            while (!stack.isEmpty() && A[i] > A[stack.peek()]){
                NGE[stack.peek()] = i+1;
                stack.pop();
            }
            stack.push(i);
        }
        for(int x : NGE){
            System.out.println(x);
        }
    }
}
