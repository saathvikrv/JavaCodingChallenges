package org.usacoProbs;

import java.util.*;

public class CowEntertainment{
    public static int count;
    public static ArrayList<Integer[]> same;
    public static ArrayList<Integer[]> different;

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int len = s.nextInt();
        int relations = s.nextInt();
        same = new ArrayList<>();
        different = new ArrayList<>();

        for(int i =0; i < relations; i++){
            if(s.next().equals("S")){
                same.add(new Integer[]{s.nextInt()-1, s.nextInt()-1});
            } else {
                different.add(new Integer[]{s.nextInt()-1, s.nextInt()-1});
            }

        }

        char[] order = new char[len];

        generate(0, order, new int[]{0, 0});
        System.out.println(Integer.toBinaryString(count));
    }

    public static void generate(int start, char[] used, int[] amtUsed){
        if(start == used.length){
            process(used, amtUsed);
        } else {
            used[start] = 'S';
            amtUsed[0] +=1;
            generate(start + 1, used, amtUsed);
            amtUsed[0] -=1;
            amtUsed[1] +=1;
            used[start] = 'M';
            generate(start + 1, used, amtUsed);
            amtUsed[1] -=1;
        }
    }

    public static void process(char[] used, int[] amtUsed){
        boolean works;

        works = true;
        for(Integer[] pair : same){
            if(used[pair[0]] != used[pair[1]]){
                works = false;
                break;
            }
        }
        if(works) {
            for (Integer[] pair : different) {
                if (used[pair[0]] == used[pair[1]]) {
                    works = false;
                    break;
                }
            }
        }
        if(works){
            count++;
        }
    }


}