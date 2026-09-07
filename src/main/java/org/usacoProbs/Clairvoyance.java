package org.usacoProbs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Clairvoyance {


    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[] bunnyCards = new int[N];
        ArrayList<Integer> harryCards = new ArrayList<>();
        boolean[] bunnyHas = new boolean[N*2];
        for(int i =0; i < N; i++){
            bunnyCards[i] = s.nextInt();
            bunnyHas[bunnyCards[i]-1] = true;
        }


        int q = 0;
        for(int i =0; i < N*2; i++){
            if(!bunnyHas[i]){
                harryCards.add(i + 1);
                q++;
            }
        }

        harryCards.sort(Comparator.comparingInt(a -> a));

        int count = 0;

        for(int card : bunnyCards){
            int i = greaterThan(card, harryCards);
            if(harryCards.get(i) < card){
                harryCards.removeFirst();
            } else {
                harryCards.remove(i);
                count++;
            }
        }
        System.out.println(count);

    }

    public static int greaterThan(int a, ArrayList<Integer> arr){
        int lo = 0;
        int hi = arr.size()-1;
        int mid;
        while(lo < hi){
            // System.out.println(arr[lo] + ", " + arr[hi]);
            mid = (lo+ hi)/2;
            if(arr.get(mid) < a){
                lo = mid+1;
            } else if(arr.get(mid) > a){
                hi = mid;
            } if(arr.get(mid) == a){
                return mid;
            }

        }
        return hi;
    }
}
