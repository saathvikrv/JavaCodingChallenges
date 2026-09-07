package org.usacoProbs;

import java.util.ArrayList;
import java.util.Scanner;

public class problem7 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        overlaps(s.nextLine());
    }

    public static void overlaps(String cowOrder){
//        StringBuilder cows = new StringBuilder(cowOrder);
//        char a;
//        char b;
//
//        for(int i = 0; i < cows.length()-1; i++){
//            a = cows.charAt(i);
//            b = cows.charAt(i+1);
//
//            if(a==b){
//                cows.deleteCharAt(i);
//                cows.deleteCharAt(i);
//                i-=1;
//            }
//
//        }
//
//
//
//
//
//        System.out.println(cows.toString());


        //String simplifiedOrder = cows.toString();

        int count = 0;
        char l1;
        char l2;
        ArrayList<Integer> locations1 = new ArrayList();
        ArrayList<Integer> locations2 = new ArrayList();

        for(int i =0; i < 26; i++){
            for(int j = i+1; j < 26; j++){
                l1 = (char) (i+65);
                l2 = (char) (j+65);

                locations1 = new ArrayList<>();
                locations2 = new ArrayList<>();

                for(int k = 0; k < 52; k++){
                    if(cowOrder.charAt(k) == l1){
                        locations1.add(k);
                    }
                    if(cowOrder.charAt(k) == l2){
                        locations2.add(k);
                    }
                }
                if(locations1.get(0) < locations2.get(0) && locations2.get(0) < locations1.get(1) && locations1.get(1) < locations2.get(1)){
                    count += 1;
                }
                if(locations2.get(0) < locations1.get(0) && locations1.get(0) < locations2.get(1) && locations2.get(1) < locations1.get(1)){
                    count += 1;
                }
            }
        }
        System.out.println(count);



    }

}
