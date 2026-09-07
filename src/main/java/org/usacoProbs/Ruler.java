package org.usacoProbs;

import java.util.Scanner;

public class Ruler {
    public static void main(String[] args){
        int size = new Scanner(System.in).nextInt();
        String output = "*".repeat(size) + "\n" + rulery(size) + "\n" + "*".repeat(size);
        System.out.println(output);
    }

    public static String rulery(int size){
        if(size == 1){
            return "*";
        }

        String ruleryResult = rulery(size-1);
        return ruleryResult + "\n" + "*".repeat(size) + "\n" + ruleryResult;
    }


}

/*

     **..* (N times *)
r_N = d_(N-1)
      **..* (N times *)

      d_(N-1)
d_N = **..* (N times *)
      d_(N-1)

d_1 = *

 */
