package org.usacoProbs;

import java.util.Arrays;
import java.util.Scanner;

public class HW4 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int cows = s.nextInt();
        int interactionCount = s.nextInt();
        s.nextLine();
        String misinformation = s.nextLine();
        int[][] interactions = new int[interactionCount][3];
        for(int i = 0; i < interactionCount; i++){
            interactions[i][0] = s.nextInt();
            interactions[i][1] = s.nextInt();
            interactions[i][2] = s.nextInt();
        }

        s.close();

        interactions = mergeSort(interactions);

        int[][] cowStats = new int[cows+1][3];

        for(int[] cow : cowStats){
            Arrays.fill(cow,0);
        }

        int q = Math.max(interactionCount, cows);

        int[] kVals = new int[q+1];
        Arrays.fill(kVals, 0);


        for(int k = 0; k <= q; k++) {
            simulate(interactions, k, misinformation, cows, interactionCount, cowStats);
            if(cowStats[0][2] == 1){
                kVals[k] = 1;
            }
        }
        System.out.println(Arrays.toString(kVals));

        minMaxNum(kVals, cowStats);
    }

    public static int[][] mergeSort(int[][] arr){
        if(arr.length == 1){
            return arr;
        }

        int[][] startHalf = Arrays.copyOfRange(arr, 0, Math.ceilDiv(arr.length,2));
        int[][] endHalf = Arrays.copyOfRange(arr, Math.ceilDiv(arr.length,2), arr.length);

        startHalf = mergeSort(startHalf);
        endHalf = mergeSort(endHalf);

        return merge(startHalf, endHalf);
    }

    public static int[][] merge(int[][] arr1, int[][] arr2){
        int i = 0;
        int j = 0;
        int k = 0;
        int num1;
        int num2;
        Scanner s;

        int[][] result = new int[arr1.length+ arr2.length][3];


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

    public static int[][] simulate(int[][] interactions, int k, String result, int cows, int numInteractions, int[][] cowStats){

        cowStats[0][2] = 0;

        int[] cow1, cow2;
        int[][] placeholder;
        boolean works;

        for(int starterCow = 1; starterCow <= cows; starterCow++) {
            cowStats[starterCow][0] = 1;
            cowStats[starterCow][1] = 1;

            for (int[] meet : interactions) {
                cow1 = cowStats[meet[1]];
                cow2 = cowStats[meet[2]];
                placeholder = cowMeet(cow1, cow2, k);
                cowStats[meet[1]] = placeholder[0];
                cowStats[meet[2]] = placeholder[1];
            }
            works = true;

            for (int i = 0; i < cows; i++) {
                if(Integer.toString(cowStats[i + 1][0]).charAt(0) != result.charAt(i)) {
                    if(result.charAt(i) == '1' && cowStats[i+1][1] == 0) {
                        works = false;
                        break;
                    } else if(result.charAt(i) == '0' && cowStats[i+1][1] >= 1){
                        works = false;
                        break;
                    }
                } else if(result.charAt(i) == '0' && cowStats[i+1][0] == 0 && cowStats[i+1][1] > 0){
                    works = false;
                    break;
                }
            }
            if (works) {
                cowStats[starterCow][2] = 1;
                cowStats[0][2] = 1;
            }
            for (int[] cow : cowStats) {
                cow[0] = 0;
                cow[1] = 0;
            }
        }
        //System.out.println(Arrays.deepToString(cowStats));
        return cowStats;
    }

    public static int[][] cowMeet(int[] cow1, int[] cow2, int k){

        if(k < cow1[1]){
            cow1[0] = 0;

        }
        if(k < cow2[1]){
            cow2[0] = 0;
        }

        if(cow1[0] == 1 && cow2[0] == 0 && cow2[1] == 0) {
            cow1[1] += 1;
            cow2[1] += 1;
            cow2[0] = 1;
            cow1[0] = 1;

        } else if(cow2[0] == 1 && cow1[0] == 0 && cow1[1] == 0){
            cow1[1] += 1;
            cow2[1] += 1;
            cow2[0] = 1;
            cow1[0] = 1;

        } else if(cow2[0] == 1 && cow1[0] == 1){
            cow1[1] += 1;
            cow2[1] += 1;
            cow2[0] = 1;
            cow1[0] = 1;

        } else if(cow1[0] == 1 && cow2[0] == 0 && cow2[1] > 0){
            cow1[1] += 1;

        } else if(cow2[0] == 1 && cow1[0] == 0 && cow1[1] > 0){
            cow2[1] += 1;

        }

        if(k < cow1[1]){
            cow1[0] = 0;

        }
        if(k < cow2[1]){
            cow2[0] = 0;
        }
        return new int[][]{cow1, cow2};
    }

    public static void minMaxNum(int[] kVals, int[][] cowStats){
        int min = 0;

        int num = 0;

        for(int[] i : cowStats){
            if(i[2] == 1){
                num += 1;
            }
        }

        if(cowStats[0][2] == 1){
            num -= 1;
        }

        System.out.print(num + " ");

        while(kVals[min] != 1){
            min++;
        }

        System.out.print(min + " ");

        if(kVals[kVals.length-1] == 0){
            int max = kVals.length-1;
            while(kVals[max] != 1){
                max--;
            }
            System.out.print(max);
        } else {
            System.out.print("Infinity");
        }
    }
}

