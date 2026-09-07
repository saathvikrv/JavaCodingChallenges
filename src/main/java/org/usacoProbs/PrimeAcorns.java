package org.usacoProbs;

import java.util.ArrayList;
import java.util.Scanner;

public class PrimeAcorns {

    public static ArrayList<Integer> superprimes(int digits){
        if(digits == 1){
            ArrayList<Integer> a = new ArrayList<>();
            a.add(2);
            a.add(3);
            a.add(5);
            a.add(7);
            return a;
        }

        ArrayList<Integer> prev = superprimes(digits -1);
        ArrayList<Integer> ans = new ArrayList<>();

        for(int prime : prev){
            if(isPrime(prime * 10 + 1)){
                ans.add(prime * 10 + 1);
            }
            if(isPrime(prime * 10 + 3)){
                ans.add(prime * 10 + 3);
            }
            if(isPrime(prime * 10 + 7)){
                ans.add(prime * 10 + 7);
            }
            if(isPrime(prime * 10 + 9)){
                ans.add(prime * 10 + 9);
            }
        }

        return ans;
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int digits = s.nextInt();
        ArrayList<Integer> ans = superprimes(digits);
        for (Integer a : ans) {
            System.out.println(a);
        }

    }


    public static boolean isPrime(int n){
        for(int i = 2; i < Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}

