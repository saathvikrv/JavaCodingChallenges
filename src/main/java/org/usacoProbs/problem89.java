package org.usacoProbs;


import java.util.LinkedList;
import java.util.Scanner;


public class problem89 {
    public static void main(String[] args){
        Scanner s= new Scanner(System.in);

        LinkedList<Integer> line = new LinkedList<>();
        int events = s.nextInt();
        int count = 1;
        for(int i =0; i< events; i++){
            if(s.next().equals("D")){
                if(s.next().equals("R")){
                    for(int n = s.nextInt() -1 ; n >= 0; n--){
                        line.removeLast();
                    }
                } else {
                    for(int n = s.nextInt() -1 ; n >= 0; n--){
                        line.removeFirst();
                    }
                }
            } else {
                if(s.next().equals("R")){
                    line.addLast(count);
                } else {
                    line.addFirst(count);
                }
                count++;
            }
        }
        for (Integer integer : line) {
            System.out.println(integer);
        }
    }


}
