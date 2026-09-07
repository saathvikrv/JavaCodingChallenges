package org.usacoProbs;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Final_6 {
    public static void individualCase(ArrayList<Integer> order){
        int count = 0;

        int q = 0;
        while(q < order.size()-1 && Objects.equals(order.get(q), order.get(q + 1))){
            q++;
        }
        if (q == order.size()-1){
            System.out.println(0);
            return;
        }

        for(int i =0; i < order.size(); i++){
            if(order.get(i) == 0){
                order.remove(i);
                i--;
                count++;
            }
        }

        ArrayList<Integer> orderChanged = new ArrayList<>(order);

        int max = 0;
        int sum = 0;
        for(int i : order){
            max = Math.max(max, i);
            sum += i;
        }

        for(int i = max; i <= sum; i++){
            if(((float) sum / (float) i) == Math.floorDiv(sum, i)){
                for(int n = 0; n < orderChanged.size()-1; n++){
                    if(orderChanged.get(n) + orderChanged.get(n+1) <= i){
                        orderChanged.set(n, orderChanged.get(n) + orderChanged.get(n+1));
                        orderChanged.remove(n+1);
                        n--;
                    }
                }
                if(orderChanged.size() == Math.floorDiv(sum, i)){
                    System.out.println(order.size()-orderChanged.size() + count);
                    break;
                } else {
                    orderChanged = new ArrayList<>(order);
                }
            }
        }

    }

    public static void main(String[] args){
        Scanner s= new Scanner(System.in);
        int tests = s.nextInt();
        ArrayList<Integer> order = new ArrayList<>();
        int len;
        for(int i = 0; i < tests; i++){
            order = new ArrayList<>();
            len = s.nextInt();
            for(int j =0; j < len; j++){
                order.add(s.nextInt());
            }

            individualCase(order);
        }



    }
}
