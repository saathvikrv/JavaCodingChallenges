package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Final_2 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int[] data = new int[s.nextInt()-1];
        for(int i = 0; i< data.length; i++){
            data[i] = s.nextInt();
        }

        int amountNumbers = data.length+1;
        boolean[] used = new boolean[amountNumbers+1];
        int currVal;
        boolean done;
        int start =0;

        for(int i = 1; i <= amountNumbers; i++){
            done = true;
            currVal = i;


            Arrays.fill(used, false);
            used[0]= true;

            for(int n = 0; n < data.length; n++){
                if(currVal < used.length && currVal > 0 && !used[currVal]) {
                    used[currVal] = true;
                } else {
                    done = false;
                    break;
                }


                currVal = data[n] - currVal;

            }
            if(done){
                start = i;
                break;
            }
        }

        currVal = start;


        for(int n = 0; n < data.length; n++){

            currVal = data[n] - currVal;
            System.out.print(currVal+" ");

        }
    }
}
