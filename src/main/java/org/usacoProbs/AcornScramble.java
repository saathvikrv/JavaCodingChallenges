package org.usacoProbs;

import java.util.Scanner;

public class AcornScramble {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int nums = s.nextInt();
        int[] currPos = new int[nums];
        int[] finalPos = new int[nums];
        boolean[] moved = new boolean[nums];

        for(int i =0; i < nums; i++){
            currPos[i] = s.nextInt()-1;
        }

        for(int i =0; i < nums; i++){
            finalPos[s.nextInt()-1] = i;
        }

        int nextPos;
        int currNum;
        int nextNum;
        int cycleSize;
        int maxCycleSize = 0;
        int cycles = 0;

        for(int i =0; i < nums; i++){
            if(!moved[i]) {
                System.out.print((currPos[i]+1) + " ");
                moved[i] = true;
                cycles++;
                cycleSize = 1;
                nextPos = finalPos[currPos[i]];
                currNum = currPos[i];
                currPos[i] = -1;
                while(currPos[nextPos] != -1) {
                    nextNum = currPos[nextPos];
                    moved[nextPos] = true;
                    System.out.print((currPos[nextPos]+1) + " ");
                    currPos[nextPos] = currNum;
                    currNum = nextNum;
                    nextPos = finalPos[currNum];
                    cycleSize++;
                }
                currPos[i] = currNum;
                if(cycleSize == 1){
                    cycles--;
                }
                maxCycleSize = Math.max(cycleSize, maxCycleSize);
                System.out.println();
                System.out.println(cycleSize);
            }
        }

        System.out.println(cycles + " " + maxCycleSize);
    }
}

/*

60
9 45 27 37 28 54 21 55 4 5 30 20 53 47 39 22 15 46 16 19 10 40 3 12 51 49 34 1 7 14 25 58 38 11 17 32 42 24 41 59 8 52 44 29 18 2 36 60 57 43 31 33 35 6 23 50 13 26 56 48
8 17 15 49 23 3 41 53 30 18 7 38 46 54 11 40 55 20 16 42 31 6 59 1 33 10 51 50 9 34 4 26 44 58 28 21 14 60 25 36 39 52 12 56 57 43 27 13 19 47 48 45 32 24 22 29 5 35 37 2

20
6 16 11 2 14 8 1 13 18 20 15 4 5 3 17 19 10 9 12 7
1 11 17 13 12 5 6 18 15 2 4 3 9 19 20 10 8 16 7 14

100
15 74 68 9 28 17 88 80 69 75 42 31 95 10 35 48 58 44 21 47 97 49 43 92 61 64 45 62 53 87 55 78 54 93 24 59 99 22 37 50 34 94 39 81 27 56 76 32 96 36 70 4 73 79 29 41 91 40 84 46 23 82 3 33 98 38 63 1 6 30 85 90 65 77 7 2 5 26 20 14 60 100 12 25 16 19 72 71 57 83 11 86 66 67 8 51 18 89 52 13
34 36 93 64 14 99 70 81 26 49 33 87 76 2 74 75 27 40 57 24 80 31 42 58 83 66 95 62 23 59 28 32 100 60 78 41 13 38 22 79 90 89 4 16 12 6 91 92 67 61 73 98 97 20 63 18 71 19 43 17 84 77 94 69 29 65 11 8 7 53 54 52 44 39 96 1 88 55 21 68 3 37 72 51 9 48 50 86 56 5 47 45 85 25 82 46 30 10 35 15

 */
