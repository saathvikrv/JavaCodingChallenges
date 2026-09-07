package org.usacoProbs;

import java.util.Scanner;


public class problem32 {
    public static void main(String[] args){
        Scanner s= new Scanner(System.in);
        s.nextLine();
        String sequence = s.nextLine();
        long awkward = 0;
        for(int i = 0; i < sequence.length(); i++){
            awkward += awkwardForChar(sequence, i);
        }
        System.out.println(awkward);

//        int awkward = 0;
//
//        int blue = 0;
//        int red = 0;
//
//        for(int i = 0; i < sequence.length()- 2; i++){
//            if(sequence.charAt(i) == 'R'){
//                red = 1;
//                blue = 0;
//            } else {
//                blue = 1;
//                red = 0;
//            }
//
//            if(sequence.charAt(i+1) == 'R'){
//                red++;
//            } else {
//                blue++;
//            }
//            for(int j = i+3; j < sequence.length()+1; j++){
//                if(sequence.charAt(j-1) == 'R'){
//                    red++;
//                } else {
//                    blue++;
//                }
//
//                if(red == 1 || blue == 1){
//                    awkward++;
//                }
//            }
//        }
//
//        System.out.println(awkward);
    }


//    public static boolean isAwkward(String seq){
//        int blue =0;
//        int red =0;
//
//        for(int i =0; i < seq.length(); i++){
//            if(seq.charAt(i) == 'B'){
//                blue ++;
//
//            } else {
//                red ++;
//            }
//        }
//
//        return blue == 1 || red == 1;
//    }
    public static int awkwardForChar(String seq, int index){
        char surround;

        if(seq.charAt(index) == 'B'){
            surround = 'R';
        } else {
            surround = 'B';
        }

        int i = index+1;
        int after = 0;
        if(i < seq.length()-1){
            while(i < seq.length() && seq.charAt(i) == surround){
                i++;
                after++;
            }

        }
        i = index-1;
        int before = 0;
        if(i >= 0){
            while(i >= 0 && seq.charAt(i) == surround){
                i--;
                before++;
            }

        }

        int res = before*after+Math.max(before-1, 0)+Math.max(after-1, 0);

        return Math.max(res, 0);
    }


}


