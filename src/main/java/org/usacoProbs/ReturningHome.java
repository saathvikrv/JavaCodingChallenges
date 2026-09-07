package org.usacoProbs;

import java.util.ArrayList;
import java.util.Scanner;

public class ReturningHome {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int roads = s.nextInt();
        int forks = s.nextInt();
        int house = s.nextInt();
        int[][] treeForks = new int[forks][3];
        ArrayList<Integer> path = new ArrayList<>();
        for(int i = 0; i < forks; i++){
            treeForks[i][0] = s.nextInt();
            treeForks[i][1] = s.nextInt();
            treeForks[i][2] = s.nextInt();
        }
        path.add(house);
        int currPt = house;
        while(currPt > 1) {
            for (int i = 0; i < forks; i++) {
                if (treeForks[i][1] == currPt || treeForks[i][2] == currPt) {
                    path.add(treeForks[i][0]);
                    currPt = treeForks[i][0];
                }
            }
        }
        System.out.println(path.size());
        for(int i =path.size()-1; i >= 0; i--){
            System.out.println(path.get(i));
        }
    }
}
