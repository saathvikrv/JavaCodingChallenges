package org.usacoProbs;

import java.util.Scanner;
import java.util.stream.IntStream;

public class problem33 {
    public static void main(String[] args){
//        System.out.println(Arrays.toString(cycle(new int[]{0, 1, 2, 3, 4}, new int[]{0, 2, 3})));


        Scanner s = new Scanner(System.in);
        int max = s.nextInt();
        int[] order = IntStream.range(0, max).toArray();
        int[] switchers = new int[s.nextInt()];
        int time = s.nextInt();
        time = time % (order.length * switchers.length);
        for(int i =0; i < switchers.length; i++){
            switchers[i] = s.nextInt();
        }


        for(int i = 0; i < time; i++){
            order = cycle(order, switchers);
            switchers = increase(switchers, max);
        }
        for(int i = 0; i < order.length-1; i++) {
            System.out.print(order[i]+" ");
        }
        System.out.print(order[order.length-1]);
    }


    public static int[] cycle(int[] order, int[] online){
        int n = order[online[0]];
        int m;
        int k = order[online[online.length-1]];

        for(int i = 1; i < online.length; i++){
            m = n;
            n = order[online[i]];
            order[online[i]] = m;
        }

        order[online[0]] = k;

        return order;
    }

    public static int[] increase(int[] online, int max){
        for(int i =0; i < online.length; i++){
            online[i]++;
            if(online[i] >= max){
                online[i] = 0;
            }
        }
        return online;
    }
}
