package org.usacoProbs;

import java.util.Objects;
import java.util.Scanner;

public class problem49 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int len = s.nextInt();
        int currNum;
        String currChar;

        int[][] somebig = {{0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}};

        for(int i = 0; i < len; i++){
            currChar = s.next();
            currNum = s.nextInt();
            if(Math.abs(currNum % 2) == 0){
                if(Objects.equals(currChar, "S")){
                    somebig[0][0]++;
                }else if(Objects.equals(currChar, "O")){
                    somebig[1][0]++;
                }else if(Objects.equals(currChar, "M")){
                    somebig[2][0]++;
                }else if(Objects.equals(currChar, "E")){
                    somebig[3][0]++;
                }else if(Objects.equals(currChar, "B")){
                    somebig[4][0]++;
                }else if(Objects.equals(currChar, "I")){
                    somebig[5][0]++;
                }else if(Objects.equals(currChar, "G")){
                    somebig[6][0]++;
                }
            }
            if(Math.abs(currNum % 2) == 1){
                if(Objects.equals(currChar, "S")){
                    somebig[0][1]++;
                }else if(Objects.equals(currChar, "O")){
                    somebig[1][1]++;
                }else if(Objects.equals(currChar, "M")){
                    somebig[2][1]++;
                }else if(Objects.equals(currChar, "E")){
                    somebig[3][1]++;
                }else if(Objects.equals(currChar, "B")){
                    somebig[4][1]++;
                }else if(Objects.equals(currChar, "I")){
                    somebig[5][1]++;
                }else if(Objects.equals(currChar, "G")){
                    somebig[6][1]++;
                }
            }
        }





        double ib = 0;
        double egos = 0;
        double m = somebig[2][0];
        double egosPoss = (somebig[3][0]+somebig[3][1]) * (somebig[6][0]+somebig[6][1]) * (somebig[1][0]+somebig[1][1]) * (somebig[0][0]+somebig[0][1]);
        double ibPoss = (somebig[4][0]+somebig[4][1]) * (somebig[5][0]+somebig[5][1]);
        double mPoss = somebig[2][0]+somebig[2][1];


        if(somebig[4][0] > 0 && somebig[5][0] > 0){
            ib+=somebig[4][0] * somebig[5][0];
        }
        if(somebig[4][1] > 0 && somebig[5][1] > 0){
            ib+=somebig[4][1] * somebig[5][1];
        }

        if(somebig[3][0] > 0 && somebig[6][0] > 0 && somebig[1][0] > 0 && somebig[0][0] > 0){
            egos += somebig[3][0] * somebig[6][0] * somebig[1][0] * somebig[0][0];
        }
        if(somebig[3][1] > 0 && somebig[6][1] > 0 && somebig[1][1] > 0 && somebig[0][1] > 0){
            egos += somebig[3][1] * somebig[6][1] * somebig[1][1] * somebig[0][1];
        }
        if(somebig[3][0] > 0 && somebig[6][1] > 0 && somebig[1][0] > 0 && somebig[0][1] > 0){
            egos += somebig[3][0] * somebig[6][1] * somebig[1][0] * somebig[0][1];
        }
        if(somebig[3][1] > 0 && somebig[6][0] > 0 && somebig[1][1] > 0 && somebig[0][0] > 0){
            egos += somebig[3][1] * somebig[6][0] * somebig[1][1] * somebig[0][0];
        }
        if(somebig[3][1] > 0 && somebig[6][1] > 0 && somebig[1][0] > 0 && somebig[0][0] > 0){
            egos += somebig[3][1] * somebig[6][1] * somebig[1][0] * somebig[0][0];
        }
        if(somebig[3][0] > 0 && somebig[6][0] > 0 && somebig[1][1] > 0 && somebig[0][1] > 0){
            egos += somebig[3][0] * somebig[6][0] * somebig[1][1] * somebig[0][1];
        }
        if(somebig[3][0] > 0 && somebig[6][1] > 0 && somebig[1][1] > 0 && somebig[0][0] > 0){
            egos += somebig[3][0] * somebig[6][1] * somebig[1][1] * somebig[0][0];
        }
        if(somebig[3][1] > 0 && somebig[6][0] > 0 && somebig[1][0] > 0 && somebig[0][1] > 0){
            egos += somebig[3][1] * somebig[6][0] * somebig[1][0] * somebig[0][1];
        }

//        egos = adj1(egos, somebig[3]);
//        egos = adj1(egos, somebig[6]);
//        egos = adj1(egos, somebig[1]);
//        egos = adj1(egos, somebig[0]);
//
//        if(egos < 1){
//            if(somebig[3][0] == 0){
//                if(somebig[6][0] == 0){
//                    if(somebig[1][0] == 0){
//                        if(somebig[0][0] == 0){
//                            egos = 1;
//                        } else {
//                            egos = 0;
//                        }
//                    } else {
//                        if(somebig[0][0] == 0){
//                            egos = 0;
//                        } else {
//                            egos = 1;
//                        }
//                    }
//                } else {
//                    if(somebig[1][0] == 0){
//                        if(somebig[0][0] == 0){
//                            egos = 0;
//                        } else {
//                            egos = 1;
//                        }
//                    } else {
//                        if(somebig[0][0] == 0){
//                            egos = 1;
//                        } else {
//                            egos = 0;
//                        }
//                    }
//                }
//            } else {
//                if(somebig[6][0] == 0){
//                    if(somebig[1][0] == 0){
//                        if(somebig[0][0] == 0){
//                            egos = 0;
//                        } else {
//                            egos = 1;
//                        }
//                    } else {
//                        if(somebig[0][0] == 0){
//                            egos = 1;
//                        } else {
//                            egos = 0;
//                        }
//                    }
//                } else {
//                    if(somebig[1][0] == 0){
//                        if(somebig[0][0] == 0){
//                            egos = 1;
//                        } else {
//                            egos = 0;
//                        }
//                    } else {
//                        if(somebig[0][0] == 0){
//                            egos = 0;
//                        } else {
//                            egos = 1;
//                        }
//                    }
//                }
//            }
//        }
//
//        egos = adj2(egos, somebig[3]);
//        egos = adj2(egos, somebig[6]);
//        egos = adj2(egos, somebig[1]);
//        egos = adj2(egos, somebig[0]);
        double main = ib * egosPoss * mPoss + ibPoss * egos * mPoss + ibPoss * egosPoss * m;
        double overlap = ib * egos * mPoss + ibPoss * egos * m + ib * egosPoss * m;
        double overlap2 = ib * egos * m;

        System.out.println((int) (main - overlap + overlap2));
    }

    public static double adj1(double currVal, int[] letterFreq){
        if(letterFreq[0] == 0){
            currVal /= 2;
        }
        if(letterFreq[1] == 0){
            currVal /= 2;
        }
        return currVal;
    }

    public static double adj2(double currVal, int[] letterFreq){
        if(letterFreq[0] != 0){
            currVal *= letterFreq[0];
        }

        if(letterFreq[1] != 0){
            currVal *= letterFreq[1];
        }
        return currVal;
    }
}


