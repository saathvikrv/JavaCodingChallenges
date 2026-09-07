package org.usacoProbs;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class problem87 {
    public static void main(String[] args){
        Scanner s= new Scanner(System.in);
        int registers = s.nextInt();

        ArrayList<Integer>[] payed = new ArrayList[registers];
        for(int n = 0; n < payed.length; n++){
            payed[n] = new ArrayList<>();
        }
        Queue<Integer> line = new LinkedBlockingDeque<>();

        while(s.hasNext()){
            if(s.next().equals("C")){
                line.add(s.nextInt());
            } else {
                payed[s.nextInt()-1].add(line.remove());
            }
        }
        for(int i = 0; i < registers; i++){
            for(int j = 0; j < payed[i].size(); j++){
                if(j < payed[i].size()-1){
                    System.out.print(payed[i].get(j) + " ");
                } else {
                    System.out.println(payed[i].get(j));
                }
            }
        }
    }
    }
