package org.usacoProbs;

import java.util.Scanner;

public class Midterm_5 {
    public static void func(String seq){

        boolean KKQ = false;
        boolean QKQ = false;
        boolean KKK = false;
        boolean QKK = false;

        for(int i = 0; i < seq.length()-2; i++){
            if(seq.charAt(i) == 'K' && seq.charAt(i+1) == 'K' && seq.charAt(i+2) == 'Q'){
                KKQ = true;
                break;
            } else if(seq.charAt(i) == 'Q' && seq.charAt(i+1) == 'K' && seq.charAt(i+2) == 'Q'){
                QKQ = true;
            } else if(seq.charAt(i) == 'K' && seq.charAt(i+1) == 'K' && seq.charAt(i+2) == 'K'){
                KKK = true;
            } else if(seq.charAt(i) == 'Q' && seq.charAt(i+1) == 'K' && seq.charAt(i+2) == 'K'){
                QKK = true;
            }
        }

        if(KKQ){
            System.out.println(seq.length()-3);
        } else if(QKQ || KKK){
            System.out.println(seq.length()-2);
        }  else if(QKK){
            System.out.println(seq.length()-1);
        } else {
            System.out.println(-1);
        }
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int cases = s.nextInt();
        s.nextLine();
        for(int i = 0; i < cases; i++){
            func(s.nextLine());
        }
    }
}
