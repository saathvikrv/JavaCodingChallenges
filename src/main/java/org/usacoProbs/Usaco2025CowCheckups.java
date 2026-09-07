package org.usacoProbs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Usaco2025CowCheckups {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int len = s.nextInt();

        int[] current = new int[len];
        int[] target = new int[len];

        for(int i = 0; i < len; i++){
            current[i] = s.nextInt();
        }

        for(int i = 0; i < len; i++){
            target[i] = s.nextInt();
        }

        ArrayList<Integer> similarities = new ArrayList<>();
        int[] result = new int[current.length +1];
        Arrays.fill(result, 0);


        for(int i = 0; i < current.length; i++){
            if(current[i] == target[i]){
                similarities.add(i);
            }
        }

        result[similarities.size()] = current.length;

        for(int i =0; i < current.length; i++){
            for(int j = i+1; j < current.length; j++){
                result[findSimilaritiesWithinNonReversedSegments(similarities, i, j) + findSimilaritiesWithinReversedSegments(current, target, i, j)]++;
            }
        }
        for(int row : result){
            System.out.println(row);
        }
    }
    public static int findSimilaritiesWithinReversedSegments(int[] current, int[] target, int start, int end){
        int count = 0;

        for(int i = 0; i <= end - start; i++){
            if(current[i + start] == target[end - i]){
                count++;
            }
        }

        return count;
    }

    public static int findSimilaritiesWithinNonReversedSegments(ArrayList<Integer> sims, int start, int end){
        int count = 0;
        int i =0;
        while(i < sims.size() && sims.get(i) < start){
            i++;
            count++;
        }
        i = sims.size()-1;
        while(i >= 0 && sims.get(i) > end){
            i--;
            count++;
        }
        return count;
    }
}
