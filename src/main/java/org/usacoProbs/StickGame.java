package org.usacoProbs;

import java.util.*;

public class StickGame {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int[][] dotLocations = new int[s.nextInt()][2];
        HashMap<Integer, ArrayList<Integer>> xToY = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> yToX = new HashMap<>();
        ArrayList<Integer> arr;
        for(int i =0; i < dotLocations.length; i++){
            dotLocations[i][0] = s.nextInt();
            dotLocations[i][1] = s.nextInt();
            if(xToY.containsKey(dotLocations[i][0])){
                xToY.get(dotLocations[i][0]).add(dotLocations[i][1]);
            } else {
                arr = new ArrayList<>();
                arr.add(dotLocations[i][1]);
                xToY.put(dotLocations[i][0], (ArrayList<Integer>) arr.clone());
            }

            if(yToX.containsKey(dotLocations[i][1])){
                yToX.get(dotLocations[i][1]).add(dotLocations[i][0]);
            } else {
                arr = new ArrayList<>();
                arr.add(dotLocations[i][0]);
                yToX.put(dotLocations[i][1], (ArrayList<Integer>) arr.clone());
            }
        }
        TreeSet<int[]> covered = new TreeSet<>(Arrays::compare);

    }
}
