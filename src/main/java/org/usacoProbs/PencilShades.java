package org.usacoProbs;

import java.util.*;

public class PencilShades {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int moves = s.nextInt();
        int shaded = s.nextInt();

        int[][] events = new int[moves*2][2];

        int pos = 0;

        for(int i = 0; i < moves*2; i+=2){
            events[i] = new int[]{pos, 0};
            int len = s.nextInt();
            char dir = s.next().charAt(0);
            events[i+1] = new int[]{pos + (dir == 'R' ? 1 : -1) * len, pos};
            events[i][1] = events[i+1][0];
            pos = events[i+1][0];
        }

        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));

        System.out.println(Arrays.deepToString(events));

        Set<Integer> current = new HashSet<>();

        int[] prev = events[0];

        for(int[] event : events){
            if(!current.contains(event[0])){
                current.add(event[0]);
            } else {
                current.remove(event[0]);
            }
        }
    }
}
