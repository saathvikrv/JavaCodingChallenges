package org.example;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class problem22 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int cows = s.nextInt();

        int[] lessThans = new int[cows];
        int[] greaterThans = new int[cows];

        int u = 0;
        int v = 0;

        String m;

        for(int i = 0; i < cows; i++){
            m = s.next();
            if(Objects.equals(m, "L")){
                lessThans[u] = s.nextInt();
                u++;
            } else if(Objects.equals(m, "G")){
                greaterThans[v] = s.nextInt();
                v++;
            }
        }

        //System.out.println(Arrays.toString(lessThans));
        //System.out.println(Arrays.toString(greaterThans));

        lessThans = Arrays.copyOfRange(lessThans, 0, u);
        greaterThans = Arrays.copyOfRange(greaterThans, 0, v);

        //System.out.println(Arrays.toString(lessThans));
        //System.out.println(Arrays.toString(greaterThans));


        Arrays.sort(lessThans);
        Arrays.sort(greaterThans);

        greaterThans = reverse(greaterThans);


        int elimLess = 0;
        int elimGreater = 0;

        int lessThanCandidate;
        int greaterThanCandidate;

        int contradictionsLess;
        int contradictionsGreater;

        while(true){
            contradictionsLess = 0;
            contradictionsGreater = 0;

            if(elimLess == lessThans.length || elimGreater == greaterThans.length){
                break;
            }

            lessThanCandidate = lessThans[elimLess];
            greaterThanCandidate = greaterThans[elimGreater];


            for(int num = elimLess; num <  lessThans.length; num++){
                if(lessThans[num] < greaterThanCandidate){
                    contradictionsGreater++;
                } else {
                    break;
                }
            }

            for(int num = elimGreater; num <  greaterThans.length; num++){
                if(greaterThans[num] > lessThanCandidate){
                    contradictionsLess++;
                } else {
                    break;
                }
            }

            if(contradictionsLess+ contradictionsGreater == 0){
                break;
            }

            if(contradictionsLess < contradictionsGreater){
                elimGreater++;
            } else {
                elimLess++;
            }
        }


        System.out.println(elimLess+elimGreater);
    }


    public static int[] reverse(int[] arr){
        int q;

        for(int i = 0; i < arr.length / 2; i++){
            q= arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = q;
        }

        return arr;



    }


}


