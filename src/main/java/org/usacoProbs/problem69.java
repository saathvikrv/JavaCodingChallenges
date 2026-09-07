package org.usacoProbs;

import java.util.Arrays;
import java.util.Scanner;

public class problem69 {
    public static int func(int index, int[] cowWeights, int[] elevatorWeights, boolean[] elevatorUsed){
        if(index == cowWeights.length){
            return 1;
        }


        int cow = cowWeights[cowWeights.length - 1 - index];

        int count = 0;

        for(int i = elevatorWeights.length-1; i >= 0; i--){
            if(!elevatorUsed[i] && cow <= elevatorWeights[i]){
                System.out.println(index);
                elevatorUsed[i] = true;
                count += func(index+1, cowWeights, elevatorWeights, elevatorUsed);
                elevatorUsed[i] = false;
            }
            if(cow > elevatorWeights[i]){
                break;
            }
        }

        return count;
    }

    public static long calculateWays(int[] cowWeights, int[] elevatorWeights){
        Arrays.sort(cowWeights);
        Arrays.sort(elevatorWeights);

        return func(cowWeights.length-1, cowWeights, elevatorWeights);
    }


    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int num = s.nextInt();
        int[] a = new int[num];
        int[] b = new int[num];

        for(int i= 0; i < num; i ++){
            a[i] = s.nextInt();
        }
        for(int i= 0; i < num; i ++){
            b[i] = s.nextInt();
        }

        //long start = System.nanoTime();

        System.out.println(calculateWays(b, a));

        //long end = System.nanoTime();

        //System.out.println("Took" + (start-end) + "seconds");
    }

    public static long func(int start, int[] elevators, int[] cows){
        if(start == 1){
            if(cows[1] <= elevators[0]){
                return 2;
            } else {
                return 1;
            }
        }

        long count = 0;

        for(int i = start; i >= 0; i--){
            if(elevators[i] >= cows[start]){
                count++;
            } else {
                break;
            }
        }

        return count * func(start-1, elevators, cows);
    }
}
