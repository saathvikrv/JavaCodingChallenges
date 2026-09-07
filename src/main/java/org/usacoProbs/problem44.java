package org.usacoProbs;

import java.util.Scanner;

public class problem44 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int students = s.nextInt();
        int testLen = s.nextInt();
        int queries = s.nextInt();
        int[][] answers = new int[students][testLen];
        for(int i = 0; i < students; i++){
            for(int j = 0; j < testLen; j++){
                answers[i][j] = s.nextInt();
            }
        }
        int[][] questions = new int[queries][2];
        for(int i = 0; i < queries; i++){
            questions[i][0] = s.nextInt();
            questions[i][1] = s.nextInt();
        }
        int count = 0;
        boolean valid;
        for(int row = 0; row < students; row++){
            valid = true;
            for(int[] question : questions){
                if(answers[row][question[0] - 1] != question[1]){
                    valid = false;
                    break;
                }
            }
            if(valid){count++;}
        }
        System.out.println(count);
    }
}
