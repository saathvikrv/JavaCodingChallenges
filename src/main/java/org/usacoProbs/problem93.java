package org.usacoProbs;


import java.util.*;

public class problem93 {
    public static class Sheet{
        int[] arr;
        public Sheet(int[] n){
            arr = new int[8];
            System.arraycopy(n, 0, arr, 0, 8);
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Sheet) {
                return Arrays.equals(arr, ((Sheet) obj).arr);
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(arr);
        }
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int[] order = new int[8];

        order[0] = s.nextInt();
        order[1] = s.nextInt();
        order[2] = s.nextInt();
        order[3] = s.nextInt();
        order[4] = s.nextInt();
        order[5] = s.nextInt();
        order[6] = s.nextInt();
        order[7] = s.nextInt();

        String output = BFS(new Sheet(order));

        System.out.println(output.length());
        System.out.println(output);
    }

    public static Sheet[] ops(Sheet curr){
        // Sheet a = new Sheet(new int[]{curr.arr[4], curr.arr[5], curr.arr[6], curr.arr[7], curr.arr[3], curr.arr[2], curr.arr[1], curr.arr[0]});
        // Sheet b = new Sheet(new int[]{curr.arr[3], curr.arr[0], curr.arr[1], curr.arr[2], curr.arr[6], curr.arr[5], curr.arr[4], curr.arr[7]});
        // Sheet c = new Sheet(new int[]{curr.arr[0], curr.arr[2], curr.arr[6], curr.arr[3], curr.arr[7], curr.arr[5], curr.arr[1], curr.arr[4]});

        return new Sheet[]{new Sheet(new int[]{curr.arr[7], curr.arr[6], curr.arr[5], curr.arr[4], curr.arr[3], curr.arr[2], curr.arr[1], curr.arr[0]}),
                new Sheet(new int[]{curr.arr[3], curr.arr[0], curr.arr[1], curr.arr[2], curr.arr[5], curr.arr[6], curr.arr[7], curr.arr[4]}),
                new Sheet(new int[]{curr.arr[0], curr.arr[6], curr.arr[1], curr.arr[3], curr.arr[4], curr.arr[2], curr.arr[5], curr.arr[7]})
        };

        /*
        0 1 2 3
        7 6 5 4

        7 6 5 4
        0 1 2 3

        3 0 1 2
        4 7 6 5

        0 6 1 3
        7 5 2 4

         */
    }

    public static String BFS(Sheet result){
        HashMap<Sheet, String> steps = new HashMap<>();
        steps.put(new Sheet(new int[]{1, 2, 3, 4, 5, 6, 7, 8}), "");
        Queue<Sheet> q = new LinkedList<>();
        q.add(new Sheet(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
        String[] abc = {"A", "B", "C"};
        int count = 0;
        while(!q.isEmpty()) {
            Sheet x = q.poll();

            if(x.equals(result)) {
                return steps.get(x);
            }

            Sheet[] moves = ops(x);
            int n = 0;
            for(Sheet nextMove : moves) {
                if(!steps.containsKey(nextMove)){
                    steps.put(nextMove, steps.get(x) + abc[n]);
                    q.add(nextMove);
                }
                n++;
            }
        }
        return "welp. somehting went wrong";
    }
}


