package org.usacoProbs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class problem67 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int cows = s.nextInt();

        ArrayList<Integer> xvals = new ArrayList<>();
        ArrayList<Integer> yvals = new ArrayList<>();

        for(int i =0; i < cows; i++){
            xvals.add(s.nextInt());
            yvals.add(s.nextInt());
        }

        ArrayList<Integer> xsorted = new ArrayList<>(xvals);
        ArrayList<Integer> ysorted = new ArrayList<>(yvals);

        xsorted.sort(Comparator.comparingInt(a -> a));
        ysorted.sort(Comparator.comparingInt(a -> a));

        int xmin;
        int xmax;
        int ymin;
        int ymax;
        int area;
        int minArea = Integer.MAX_VALUE;

        for(int cow = 0; cow < cows; cow++){
            xmin = xsorted.getFirst();
            xmax = xsorted.getLast();
            ymin = ysorted.getFirst();
            ymax = ysorted.getLast();
            if(xvals.get(cow) == xmax){
                xmax = xsorted.get(xsorted.size() -2);
            }
            if(xvals.get(cow) == xmin){
                xmin = xsorted.get(1);
            }
            if(yvals.get(cow) == ymax){
                ymax = ysorted.get(ysorted.size() -2);
            }
            if(yvals.get(cow) == ymin){
                ymin = ysorted.get(1);
            }
            area = (xmax-xmin) * (ymax-ymin);
            minArea = Math.min(area, minArea);
        }
        System.out.println(minArea);




    }
}
