package org.usacoProbs;

import java.util.Scanner;

public class HW1 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int numTestCases = s.nextInt();
        int[][] ballA = new int[numTestCases][4];
        int[][] ballB = new int[numTestCases][4];

        for(int j = 0; j < numTestCases; j++  ) {
            for (int i = 0; i < 4; i++) {
                ballA[j][i] = s.nextInt();
            }
            for (int i = 0; i < 4; i++) {
                ballB[j][i] = s.nextInt();
            }
        }
        s.close();



        boolean yes = false;
        boolean aWins = true;

        int[] arr = new int[4];

        for(int m = 0; m < numTestCases; m++) {
            if(whoWins(ballA[m], ballB[m]) == 'a'){
                aWins = true;
            } else {
                aWins = false;
            }
            yes = false;

            for (int i = 1; i < 11; i++) {
                for (int j = 1; j < 11; j++) {
                    for (int k = 1; k < 11; k++) {
                        for (int l = 1; l < 11; l++) {
                            arr[0] = i;
                            arr[1] = j;
                            arr[2] = k;
                            arr[3] = l;

                            if(aWins) {

                                if (whoWins(arr, ballB[m]) == 'b' && whoWins(arr, ballA[m]) == 'a') {
                                    System.out.println("yes");
                                    yes = true;
                                    break;
                                }
                            } else {
                                if (whoWins(arr, ballB[m]) == 'a' && whoWins(arr, ballA[m]) == 'b') {
                                    System.out.println("yes");
                                    yes = true;
                                    break;
                                }

                            }
                        }
                        if (yes){
                            break;
                        }
                    }
                    if (yes){
                        break;
                    }
                }
                if (yes){
                    break;
                }
            }
            if (!yes){
                System.out.println("no");
            }
        }
    }

    public static char whoWins(int[] a, int[] b) {
        int aScore = 0;
        int bScore = 0;

        for(int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                if (a[i] > b[j]) {
                    aScore += 1;
                } else if (a[i] < b[j]) {
                    bScore += 1;
                }
            }
        }
        //System.out.println(aScore);
        //System.out.println(bScore);
        //System.out.println(nScore);


        if(aScore > bScore){
            //System.out.println('a');
            return 'a';
        } else if(aScore < bScore){
            //System.out.println('b');
            return 'b';
        } else {
            //System.out.println('-');
            return '-';
        }
    }
}
