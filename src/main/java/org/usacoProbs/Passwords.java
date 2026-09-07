package org.usacoProbs;

import java.util.Scanner;

public class Passwords {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);


        StringBuilder n = new StringBuilder(s.next());
        int times = s.nextInt();

        generate(n, times);
    }

    public static void generate(StringBuilder s, int index){
        if(s.length() > index){
            System.out.println(s.charAt(index-1));
            // System.out.println(s);
        } else {
            s.append(s.charAt(s.length()-1));
            int len = s.length()-2;
            for(int i = 0; i < len; i++){
                s.append(s.charAt(i));
            }
            // System.out.println(s);
            generate(s, index);
        }
    }

}
