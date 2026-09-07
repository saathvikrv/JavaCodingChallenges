package org.usacoProbs;

import java.util.Scanner;

public class problem48 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int numPts = s.nextInt();
        int size = s.nextInt();
        int[][] pts = new int[2][numPts];
        for(int i =0; i< pts[0].length; i++){
            pts[0][i] = s.nextInt();
            pts[1][i] = s.nextInt();
        }

        int[] ptx = pts[0].clone();
        int[] pty = pts[1].clone();

        int res = Integer.MAX_VALUE;

        for(int pt1 : ptx){
            for(int pt2 : pty){
                res = Math.min(count(pts, pt1, pt2), res);
            }
        }
        System.out.println(res);
    }

    public static int count(int[][] pts, int threshX, int threshY){
        int Q1 = 0;
        int Q2 = 0;
        int Q3 = 0;
        int Q4 = 0;

        for(int i = 0; i< pts[0].length; i++){
            if(pts[0][i] > threshX){
                if(pts[1][i] > threshY){
                    Q1++;
                } else {
                    Q2++;
                }
            } else {
                if(pts[1][i] > threshY){
                    Q3++;
                } else {
                    Q4++;
                }
            }
        }

        return Math.max(Math.max(Q1, Q2), Math.max(Q3, Q4));
    }
}
