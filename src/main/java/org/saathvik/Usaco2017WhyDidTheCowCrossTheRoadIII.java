package org.saathvik;

import java.io.*;
import java.util.*;

public class Usaco2017WhyDidTheCowCrossTheRoadIII {
    public static void main(String[] args) throws IOException{

        String in = "cowqueue.in";
        String out = "cowqueue.out";

        BufferedReader r = new BufferedReader(new FileReader(in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(out)));

        StringTokenizer st = new StringTokenizer(r.readLine());

        final int amountCows = Integer.parseInt(st.nextToken());
        Integer[][] cows = new Integer[amountCows][2];
        for(int i =0; i< amountCows; i++){
            st = new StringTokenizer(r.readLine());
            cows[i][0] = Integer.parseInt(st.nextToken());
            cows[i][1] = Integer.parseInt(st.nextToken());
        }
        r.close();

        int time = 0;

        cows = mergeSort(cows);
        System.out.println(Arrays.deepToString(cows));
        Deque<Integer[]> cowsWaiting = new ArrayDeque<>();
        Integer[] currCow;

        for(int i = 0; i < cows.length;){

            time = cows[i][0];
            cowsWaiting.add(cows[i]);
            System.out.println("Added: " + Arrays.deepToString(cows[i]));
            i++;

            while(!cowsWaiting.isEmpty()) {
                currCow = cowsWaiting.pop();
                time += currCow[1];
                while(i < cows.length && cows[i][0] < time){
                    cowsWaiting.add(cows[i]);
                    System.out.println("Added V2: " + Arrays.deepToString(cows[i]));
                    i++;
                }
            }
        }
        pw.println(time);
        pw.close();
    }

    public static Integer[][] mergeSort(Integer[][] arr){
        if(arr.length == 1){
            return arr;
        }

        Integer[][] startHalf = Arrays.copyOfRange(arr, 0, ceilDiv(arr.length,2));
        Integer[][] endHalf = Arrays.copyOfRange(arr, ceilDiv(arr.length,2), arr.length);

        startHalf = mergeSort(startHalf);
        endHalf = mergeSort(endHalf);

        return merge(startHalf, endHalf);
    }

    public static Integer[][] merge(Integer[][] arr1, Integer[][] arr2){
        int i = 0;
        int j = 0;
        int k = 0;
        int num1;
        int num2;
        Scanner s;

        Integer[][] result = new Integer[arr1.length+ arr2.length][3];


        while(i < arr1.length && j < arr2.length){

            num1 = arr1[i][0];

            num2 = arr2[j][0];

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

    public static int ceilDiv(int a, int b){
        return (int) Math.ceil((double) a / b);
    }
}
