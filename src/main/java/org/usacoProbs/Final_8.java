package org.usacoProbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Final_8 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(r.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        for(int i =0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[][] next = nextAndPrevGreater(A, N);
        long count = 0;

        for(int i =1; i <= N; i++){
            if(next[i-1][0] != 0) {
                count += next[i-1][0] - i + 1;
            }
            if(next[i-1][1] != 0) {
                count += i - next[i-1][1] + 1;
            }
        }
        System.out.println(count);
    }

    public static int[][] nextAndPrevGreater(int[] A, int N){
        int[][] NGE = new int[N][2];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++) {
            while (!stack.isEmpty() && A[i] > A[stack.peek()]){
                NGE[stack.pop()][0] = i+1;
            }
            stack.push(i);
        }

        stack.clear();

        for(int i = N-1; i >= 0; i--) {
            while (!stack.isEmpty() && A[i] > A[stack.peek()]){
                NGE[stack.pop()][1] = i+1;
            }
            stack.push(i);
        }


        return NGE;
    }
}

/*
6 2 8 4 7 3 5

3 3 0 5 0 7 0
0 1 0 3 3 5 5


 */
