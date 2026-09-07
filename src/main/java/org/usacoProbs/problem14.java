package org.usacoProbs;

import java.util.Scanner;

public class problem14 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int tasks = s.nextInt();
        int queries = s.nextInt();
        int[] taskTimes = new int[tasks];
        int[] questions = new int[queries];
        int totalTime =0;


        for(int i = 0; i < tasks; i++){
            taskTimes[i] = s.nextInt();
            totalTime += taskTimes[i];
        }
        for(int i = 0; i < queries; i++){
            questions[i] = s.nextInt();
        }

        int[] timeToTask = new int[totalTime];
        int currentTaskTime;
        int currentMin = 0;

        for(int i = 0; i < tasks; i++){
            currentTaskTime = taskTimes[i];
            for(int j = 0; j < currentTaskTime; j++){
                timeToTask[currentMin] = i+1;
                currentMin+=1;
            }
        }

        for(int i : questions){
            System.out.println(timeToTask[i]);
        }


    }
}
