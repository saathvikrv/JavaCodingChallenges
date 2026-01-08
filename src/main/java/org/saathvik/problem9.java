package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class problem9 {
    public static void main(String[] args){
        calcLeaderChanges();
    }

    public static void calcLeaderChanges() {
        Scanner s = new Scanner(System.in);
        int lineNum = s.nextInt();
        s.nextLine();
        String[] lines = new String[lineNum];
        for(int i = 0; i < lineNum; i++){
            lines[i] = s.nextLine();
        }

        lines = mergeSort(lines);

        String[] cowNames = new String[lineNum];
        String[] scores = new String[lineNum];

        for(int i = 0; i < lineNum; i++){
            s = new Scanner(lines[i]);
            s.next();
            cowNames[i] = s.next();
            scores[i] = s.next();
        }

        HashMap<String, Integer> cowScores = new HashMap<>();
        for(String cow : cowNames){
            if(!cowScores.containsKey(cow)){
                cowScores.put(cow, 7);
            }
        }

        int leader = 0;
        int leaderChanges =0;
        String leaderCow = "";
        int currentCowScore;
        int cowScoreIncrease;

        for(int i = 0; i < lineNum; i++){
            currentCowScore = cowScores.get(cowNames[i]);
            cowScoreIncrease = Integer.parseInt(scores[i].substring(1));

            if(scores[i].charAt(0) == '+'){
                currentCowScore += cowScoreIncrease;
            } else {
                currentCowScore -= cowScoreIncrease;
            }

            cowScores.put(cowNames[i], currentCowScore);

            if(leaderCow.length() != getLeader(cowScores)[1].length()){
                leader = Integer.parseInt(getLeader(cowScores)[0]);
                leaderCow = getLeader(cowScores)[1];
                leaderChanges += 1;
            }
        }




        System.out.println(leaderChanges);


    }

    public static String[] getLeader(HashMap<String, Integer> cows){
        int max = 0;
        String maxCow = "";

        for(Object cow : cows.keySet().toArray()){
            if(cows.get((String) cow) > max){
                max = cows.get((String) cow);
                maxCow = (String) cow;
            } else if(cows.get((String) cow) == max){
                maxCow += " " + cow;
            }
        }
        return new String[]{Integer.toString(max), maxCow};
    }

    public static String[] mergeSort(String[] arr){
        if(arr.length == 1){
            return arr;
        }

        String[] startHalf = Arrays.copyOfRange(arr, 0, Math.ceilDiv(arr.length,2));
        String[] endHalf = Arrays.copyOfRange(arr, Math.ceilDiv(arr.length,2), arr.length);

        startHalf = mergeSort(startHalf);
        endHalf = mergeSort(endHalf);

        return merge(startHalf, endHalf);
    }

    public static String[] merge(String[] arr1, String[] arr2){
        int i = 0;
        int j = 0;
        int k = 0;
        int num1;
        int num2;
        Scanner s;

        String[] result = new String[arr1.length+ arr2.length];


        while(i < arr1.length && j < arr2.length){
            s = new Scanner(arr1[i]);
            num1 = s.nextInt();
            s = new Scanner(arr2[j]);
            num2 = s.nextInt();

            if(num1 > num2){
                result[k] = arr2[j];
                j+=1;
            } else{
                result[k] = arr1[i];
                i+=1;
            }

            k+=1;
        }

        while(i < arr1.length){
                result[k] = arr1[i];
                i +=1;
                k +=1;
        }

        while(j < arr2.length){
            result[k] = arr2[j];
            j +=1;
            k +=1;
        }



        return result;
    }
}
