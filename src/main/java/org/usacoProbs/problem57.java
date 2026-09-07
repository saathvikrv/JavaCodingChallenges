package org.usacoProbs;

import java.util.Scanner;

public class problem57 {
    public static boolean canDecelerate(int speed, int distRem, int limit){
        if(limit >= speed){
            return true;
        } else if((speed - limit -1) * (speed + limit) / 2 <= distRem){
            return true;
        } else {
            return false;
        }
    }

    public static int func(int limit, int distRem){
        int speed = 0;
        int time = 0;

        while(distRem > 0){
            if(canDecelerate(speed+1, distRem-speed-1, limit)){
                speed++;
                distRem -= speed;
                time++;
            } else if(canDecelerate(speed, distRem-speed, limit)){
                distRem -= speed;
                time++;
            } else {
                speed--;
                distRem -= speed;
                time++;
            }
        }
        if(speed -1 == limit){
            time++;
        }
        return time;


    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int dist = s.nextInt();
        int limits = s.nextInt();
        for(int i = 0; i < limits; i++){
            System.out.println(func(s.nextInt(), dist));
        }
    }
}
