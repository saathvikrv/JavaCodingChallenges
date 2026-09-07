package org.usacoProbs;

import java.util.*;

public class Usaco2022RangeReconstruction {
    public static void main(String[] args){
        ArrayList<Integer>[] ranges = new ArrayList[4];
        ranges[0] = new ArrayList<>();
        ranges[0].add(0);
        ranges[0].add(1);
        ranges[0].add(2);
        ranges[0].add(2);
        ranges[1] = new ArrayList<>();
        ranges[1].add(0);
        ranges[1].add(1);
        ranges[1].add(1);
        ranges[2] = new ArrayList<>();
        ranges[2].add(0);
        ranges[2].add(1);
        ranges[3] = new ArrayList<>();
        ranges[3].add(0);


        Set<Integer>[] list = new HashSet[ranges.length];
        list[0] = new HashSet<>();
        list[0].add(1);
        for(int i =1; i < list.length; i++){
            int diff = ranges[i-1].get(1);
            list[i] = new HashSet<>();
            for(Integer j : list[i-1]){
                list[i].add(j + diff);
                list[i].add(j - diff);
            }
        }
        System.out.println(Arrays.toString(list));

        for(int i =0; i < ranges.length; i++){
            for(int j = 1; j < ranges[i].size(); j++){
                Iterator<Integer> iter = list[i].iterator();
                while(iter.hasNext()){
                    Integer n = iter.next();
                    boolean works = false;
                    for(Integer m : list[j]){
                        if(Math.abs(n - m) == ranges[i].get(j)){
                            works = true;
                            break;
                        }
                    }
                    if(!works){
                        iter.remove();
                    }
                }
            }
        }

        System.out.println(Arrays.toString(list));
    }
}

/*
4
0 1 2 2
0 1 1
0 1
0

[1, 0/2, -1/1/3, -2, 0, 4, 2]
 */
