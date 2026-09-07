package org.usacoProbs;

import java.util.*;

public class BessiesCuisine {
    public static class Movement{
        public int s;
        public int e;

        public Movement(int start, int end){
            this.s = start;
            this.e = end;
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof Movement && s == ((Movement) obj).s && e == ((Movement) obj).e;
        }

        public int hashCode() {
            return Objects.hash(s, e);
        }
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        Iterator<Movement> e;
        int currNum;
        int currSwap;
        int[] swap;
        Movement a;
        HashMap<Movement, Integer> findCycle = new HashMap<>();
        Set<Movement> movements;
        Set<Integer> nums;
        boolean[] visitedAsFirst;
        boolean[] visitedAsSecond;
        int amtNums = s.nextInt();

        int[][] swaps = new int[s.nextInt()][2];
        int[][] nextOccurrence = new int[swaps.length][2];

        for(int i = 0; i < swaps.length; i++){
            swaps[i][0] = s.nextInt();
            swaps[i][1] = s.nextInt();
        }

        for(int i = 0; i < swaps.length; i++){
            nextOccurrence[i][0] = findNext(i, swaps, swaps[i][0]);
            nextOccurrence[i][1] = findNext(i, swaps, swaps[i][1]);
        }

        for(int i = 1; i <= amtNums; i++) {
            visitedAsFirst = new boolean[swaps.length];
            visitedAsSecond = new boolean[swaps.length];

            currSwap = swaps[0][0] == i || swaps[0][1] == i ? 0 : findNext(0, swaps, i);
            if(currSwap == -1){
                System.out.println(1);
                continue;
            }

            a = new Movement(swaps[currSwap][0] == i ? swaps[currSwap][0] : swaps[currSwap][1], swaps[currSwap][1] == i ? swaps[currSwap][0] : swaps[currSwap][1]);
            if(findCycle.containsKey(a)){
                System.out.println(findCycle.get(a));
            }

            currNum = swaps[currSwap][0] == i ? swaps[currSwap][0] : swaps[currSwap][1];
            nums = new HashSet<>();
            movements = new HashSet<>();
            nums.add(currNum);
            swap = swaps[currSwap];

            while (swap[0] == currNum ? !visitedAsFirst[currSwap] : !visitedAsSecond[currSwap]) {
                if (swap[0] == currNum) {
                    movements.add(new Movement(swap[0], swap[1]));
                    visitedAsFirst[currSwap] = true;
                    currNum = swap[1];
                    currSwap = nextOccurrence[currSwap][1];
                } else {
                    movements.add(new Movement(swap[1], swap[0]));
                    visitedAsSecond[currSwap] = true;
                    currNum = swap[0];
                    currSwap = nextOccurrence[currSwap][0];
                }
                nums.add(currNum);
                swap = swaps[currSwap];
            }
            e = movements.iterator();
            while(e.hasNext()){
                findCycle.put(e.next(), nums.size());
            }

//            System.out.println(nums.size());
        }
    }

    public static int findNext(int currSwap, int[][] swaps, int target){
        int initial = currSwap;
        int n = 0;
        do {
            if(currSwap == initial && n > 0){
                return -1;
            }
            if (currSwap == swaps.length - 1) {
                currSwap = -1;
            }
            currSwap++;
            n++;
        } while (swaps[currSwap][0] != target && swaps[currSwap][1] != target);
        return currSwap;
    }
}
