package org.usacoProbs;

import java.util.ArrayList;
import java.util.Scanner;

public class Midterm_6 {
    public static void main(String[] args){
        ArrayList<Integer> order = new ArrayList<>();
        ArrayList<Integer> target = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        for(int i =0; i < size; i++){
            order.add(s.nextInt());
            target.add(i+1);
        }
        int currNum;
        int i;
        int count = 0;
        while(!order.equals(target)){
            currNum = order.getFirst();
            i = order.size();
            while(currNum < order.get(i-1)){
                if(i != order.size() && order.get(i) < order.get(i-1)){
                    break;
                }
                i--;
            }
            order.add(i, currNum);
            order.removeFirst();
            count++;
        }
        System.out.println(count);
    }
}
