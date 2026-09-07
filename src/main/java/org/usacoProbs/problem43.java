package org.usacoProbs;

import java.util.Scanner;

public class problem43 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int[] IDs = new int[s.nextInt()];
        for(int i = 0; i < IDs.length; i++){
            IDs[i] = s.nextInt();
        }

        int evens = 0;
        int odds = 0;
        for(int num : IDs){
            if(num % 2 == 0){
                evens++;
            } else {
                odds++;
            }
        }

        int ans;
        boolean fullEnd = true;

        if(evens > odds){
            ans = odds + odds + 1;
        } else if(evens == odds){
            ans = evens + odds;
        } else {
            odds -= evens;
            ans = evens * 2;
            while(odds > 1){
                odds -= 2;
                ans++;
                if(odds < 1){
                    break;
                }
                odds -= 1;
                ans++;
            }
            if(odds == 1){
                ans--;
            }

        }


        System.out.println(ans);
    }
}
