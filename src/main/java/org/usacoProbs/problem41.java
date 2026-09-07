package org.usacoProbs;

import java.util.Scanner;

public class problem41 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int[] bessie = {2, 3};
        int[] lake = {1, 8};
        int[] rattlesnake = {5, 5};
        String n;
        char m;
        for(int i =0; i < 10; i++){
            n = s.nextLine();
            for(int j = 0; j < 10; j++){
                m = n.charAt(j);
                if(m == 'B'){
                    bessie[0] = i;
                    bessie[1] = j;
                }
                if(m == 'L'){
                    lake[0] = i;
                    lake[1] = j;
                }
                if(m == 'R'){
                    rattlesnake[0] = i;
                    rattlesnake[1] = j;
                }

            }
        }

        int res = Math.abs(bessie[0]-lake[0] + bessie[1]-lake[1]) - 1;


        if(bessie[0] == lake[0] && lake[0] == rattlesnake[0]){

            if((bessie[1] > rattlesnake[1] && lake[1] < rattlesnake[1]) || (bessie[1] < rattlesnake[1] && lake[1] > rattlesnake[1])){
                res += 2;
            }
        } else if(bessie[1] == lake[1] && lake[1] == rattlesnake[1]){

            if((bessie[0] > rattlesnake[0] && lake[0] < rattlesnake[0]) || (bessie[0] < rattlesnake[0] && lake[0] > rattlesnake[0])){
                res += 2;
            }
        }

        System.out.println(res);
    }
}