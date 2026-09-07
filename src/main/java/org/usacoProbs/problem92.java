package org.usacoProbs;

import java.util.*;
import java.util.function.Function;

public class problem92 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);


        int cap1 = s.nextInt();
        int cap2 = s.nextInt();
        int movesAllowed = s.nextInt();
        int target = s.nextInt();

        Function<Pair, Pair[]> moveOptions = a -> moves(a, cap1, cap2);

        System.out.println(BFS(moveOptions, target, cap1, cap2, movesAllowed));
    }

    public static Pair[] moves(Pair curr, int cap1, int cap2){
        return new Pair[]{
                new Pair(0, curr.second),
                new Pair(curr.first, 0),
                new Pair(cap1, curr.second),
                new Pair(curr.first, cap2),
                (curr.first + curr.second > cap1 ? new Pair(cap1, curr.first + curr.second - cap1) : new Pair(curr.first + curr.second, 0)),
                (curr.first + curr.second > cap2 ? new Pair(curr.first + curr.second - cap2, cap2) : new Pair(0, curr.first + curr.second))};
    }

    public static int BFS(Function<Pair, Pair[]> moveOptions, int sum, int bucket1, int bucket2, int movesAllowed){
        HashMap<Pair, Integer> steps = new HashMap<>();
        for(int i =0; i <= bucket1; i++){
            for(int j =0; j <= bucket2; j++){
                steps.put(new Pair(i, j), -1);
            }
        }
        steps.put(new Pair(0, 0), 0);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0));          // add the starting index
        int closest = Integer.MAX_VALUE;
        Pair x;

        while(!q.isEmpty() && steps.get(q.peek()) <= movesAllowed) {
            // search the elements for the current step
            x = q.poll();
            // if reached to N th element, write the answer and exit the program
            if(x.first + x.second == sum) {
                return steps.get(x);
            }
            closest = Math.min(closest, Math.abs(x.first + x.second - sum));


            // make the moves, and update the valid and not visited elements
            Pair[] moves = moveOptions.apply(x);
            for(Pair nextMove : moves) {
                if(steps.containsKey(nextMove) && steps.get(nextMove) == -1){
                    steps.put(nextMove, steps.get(x) + 1);
                    q.add(nextMove);
                    // System.out.println("Added " + nextMove.first + " "+ nextMove.second);
                }
            }
        }
        return closest;
    }

    public static class Pair{
        public Integer first;
        public Integer second;

        public Pair(int a, int b){
            first = a;
            second = b;
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof Pair && Objects.equals(((Pair) obj).first, first) && Objects.equals(((Pair) obj).second, second);
        }

        public int hashCode() {
            return Objects.hash(first, second);
        }
    }
}
