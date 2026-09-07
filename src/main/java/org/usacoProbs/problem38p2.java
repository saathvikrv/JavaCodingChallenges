package org.usacoProbs;

import java.util.Scanner;


public class problem38p2 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int len = s.nextInt();

        int[] start = new int[len];
        int[] end = new int[len];

        for(int i =0; i < start.length; i++){
            start[i] = s.nextInt();
            end[i] = s.nextInt();
        }

        int[] sitters = new int[1001];

        for(int i = 0; i < start.length; i++){
            for(int time = start[i]; time < end[i]; time++){
                sitters[time]++;
            }
        }
        int covered = 0;
        for(int time = 0; time <= 1000; time++){
            if (sitters[time] > 0) {
                covered++;
            }
        }
        int minLoss = 1001;
        int loss;
        for(int i = 0; i < start.length; i++){
            loss = 0;
            for(int time = start[i]; time < end[i]; time++){
                if(sitters[time] == 1){
                    loss++;
                }
            }
            minLoss = Math.min(minLoss, loss);
        }
        System.out.println(covered-minLoss);

    }
}
