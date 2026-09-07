package org.usacoProbs;
import java.util.Arrays;
import java.util.Scanner;

public class BallGownFitting {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int numberOfFoxes = s.nextInt();
        int gownLength = s.nextInt();
        int[] foxes = new int[numberOfFoxes];
        for(int i =0; i < numberOfFoxes; i++){
            foxes[i] = s.nextInt();
        }
        Arrays.sort(foxes);

        int count = 0;
        for(int fox1 = 0; fox1 < numberOfFoxes; fox1++){
            for(int fox2 = fox1+1; fox2 < numberOfFoxes && foxes[fox2] + foxes[fox1] <= gownLength; fox2++){
                count++;
            }
        }
        System.out.println(count);
    }
}