package org.usacoProbs;

import java.util.Scanner;

public class problem60 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        s.nextLine();
        String order = s.nextLine();
        String target = s.nextLine();
        int count = 0;
        for(int i = 1; i < order.length(); i++){
            if(order.charAt(i) == target.charAt(i) && order.charAt(i-1) != target.charAt(i-1)) {
                count++;
            }
        }
        if(order.charAt(order.length()-1) != target.charAt(order.length()-1)){
            count++;
        }
        System.out.println(count);
    }
}
