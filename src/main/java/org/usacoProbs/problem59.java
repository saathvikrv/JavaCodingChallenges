package org.usacoProbs;

import java.util.ArrayList;
import java.util.Arrays;

public class problem59 {
    public static void main(String[] args){
        int fields = 4;
        int cows = 4;
        ArrayList<Integer[]>[] cowGrazeLog = new ArrayList[4];
        cowGrazeLog[0] = new ArrayList<Integer[]>();
        cowGrazeLog[0].add(new Integer[]{1, 1});
        cowGrazeLog[0].add(new Integer[]{3, 5});
        cowGrazeLog[0].add(new Integer[]{4, 7});
        cowGrazeLog[1] = new ArrayList<Integer[]>();
        cowGrazeLog[1].add(new Integer[]{2, 6});
        cowGrazeLog[1].add(new Integer[]{3, 4});
        cowGrazeLog[1].add(new Integer[]{4, 7});
        cowGrazeLog[2] = new ArrayList<Integer[]>();
        cowGrazeLog[2].add(new Integer[]{1, 8});
        cowGrazeLog[2].add(new Integer[]{1, 5});
        cowGrazeLog[3] = new ArrayList<Integer[]>();
        cowGrazeLog[3].add(new Integer[]{1, 1});
        cowGrazeLog[3].add(new Integer[]{3, 5});
        cowGrazeLog[3].add(new Integer[]{4, 7});


        int[][] cowSickLog = {
                {1, 4},
                {3, 7}
        };

        int currField = 0;
        int j = 0;

        boolean[][] fieldCulprits = new boolean[fields][cowSickLog.length];
        for(boolean[] i : fieldCulprits) {
            Arrays.fill(i, false);
        }

        for(ArrayList<Integer[]> field : cowGrazeLog){
            for(Integer[] info : field){
                if(isCulprit(cowSickLog, info)){
                    for(int sick = 0; sick < cowSickLog.length; sick++) {
                        if(cowSickLog[sick][0] == info[0]){
                            fieldCulprits[currField][sick] = true;
                            break;
                        }
                    }
                }
            }
            currField++;
        }
        System.out.println(Arrays.deepToString(fieldCulprits));

        for(int cow = 0; cow < fieldCulprits.length; cow++){
            
        }

    }

    public static boolean isCulprit(int[][] cowsSick, Integer[] cowGrazeInfo){

        for(int[] cow : cowsSick){
            if(cow[0] == cowGrazeInfo[0] && cowGrazeInfo[1] < cow[1]){
                return true;
            }
        }
        return false;
    }
}
