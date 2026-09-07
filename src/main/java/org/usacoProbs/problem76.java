package org.usacoProbs;

import java.util.Scanner;

public class problem76 {
    public static int demolishCount(int[] barnHeights){
        int i=0;
        for(int barnNum = 0; barnNum < barnHeights.length-2; barnNum++){
            if(barnHeights[barnNum] < barnHeights[barnNum+1] && barnHeights[barnNum+2] > 0){
                i++;
                barnHeights[barnNum+1]--;
                barnHeights[barnNum+2]--;
                barnNum--;
            }
        }

        for(int barnNum = barnHeights.length-1; barnNum > 1; barnNum--){
            if(barnHeights[barnNum] < barnHeights[barnNum-1] && barnHeights[barnNum-2] > 0){
                i++;
                barnHeights[barnNum-1]--;
                barnHeights[barnNum-2]--;
                barnNum++;
            }
        }
        int j =0;
        while(j < barnHeights.length-1 && barnHeights[j] == barnHeights[j+1]) {
            j++;
        }
        if(j >= barnHeights.length-1){
            return i*2;
        } else {
            return -1;
        }
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int tests = s.nextInt();
        int len;
        int[] barns;
        for(int t =0; t < tests; t++) {
            len = s.nextInt();
            barns = new int[len];
            for (int i = 0; i < len; i++) {
                barns[i] = s.nextInt();
            }
            System.out.println(demolishCount(barns));
        }

    }
}
