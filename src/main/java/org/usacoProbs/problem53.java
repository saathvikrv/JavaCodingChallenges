package org.usacoProbs;

import java.util.Scanner;

public class problem53 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int cases = s.nextInt();
        int[] barns;
        int i;

        for(int currCase = 0; currCase < cases; currCase++){
            barns = new int[s.nextInt()];
            for(int j =0; j < barns.length; j++){
                barns[j] = s.nextInt();
            }
            i = 1;
            while(i < barns.length && barns[i] == barns[i-1]){
                i++;
            }
            if(i >= barns.length) {
                System.out.println(0);
            } else {
                func(barns);
            }
        }

    }
    public static void func(int[] barns){
        boolean possible = true;
        int max;
        int maxIndex;
        int currBarn;
        int i;
        int count = 0;
        while(true) {
            if(barns[0] > barns[1]){
                possible = false;
                break;
            } else if(barns[barns.length-1]> barns[barns.length-2]){
                possible = false;
                break;
            }

            max = 0;
            maxIndex = 0;
            currBarn = 0;

            for (int barn : barns) {
                if (barn > max) {
                    max = barn;
                    maxIndex = currBarn;
                }

                currBarn++;
            }

            if (maxIndex == 0) {
                if (barns[0] == 0 || barns[1] == 0) {
                    possible = false;
                    break;
                }
                barns[0]--;
                barns[1]--;
                count+=2;
            } else if (maxIndex == barns.length - 1) {
                if (barns[barns.length - 1] == 0 || barns[barns.length - 2] == 0) {
                    possible = false;
                    break;
                }
                barns[barns.length - 1]--;
                barns[barns.length - 2]--;
                count+=2;
            } else {
                if (barns[maxIndex + 1] == 0 /*|| barns[maxIndex] == 0*/ && barns[maxIndex - 1] == 0) {
                    possible = false;
                    break;
                }
                if (barns[maxIndex + 1] > barns[maxIndex - 1]) {
                    barns[maxIndex]--;
                    barns[maxIndex + 1]--;
                } else {
                    barns[maxIndex - 1]--;
                    barns[maxIndex]--;
                }
                count+=2;
            }
            i = 1;
            while (i < barns.length && barns[i] == barns[i - 1]) {
                i++;
            }
            if (i >= barns.length) {
                possible = true;
                break;
            }
        }
        if(possible){
            System.out.println(count);

        } else {
            System.out.println(-1);
        }
    }
}
