package org.saathvik;


import java.io.*;
import java.util.StringTokenizer;

public class Usaco2018BlockedBillboardII {

    public enum Containment {
        PARTIAL,
        FULL,
        NONE,
    }



    public static Containment findContainment(int a1, int a2, int b1, int b2){
        /*
        y1 is above, y2 is below

        3 Cases:

        fully contained:

        ay1

        by1
        by2

        ay2

        not contained at all:

        ay1
        ay2

        by1
        by2

        other:
         */

        if(a1 > b1 && b2 > a2) {
            return Containment.FULL;
        } else if(b1 > a1 && a2 > b2){
            return Containment.NONE;
        } else if(a2 > b1 || b2 > a1){
            return Containment.NONE;
        } else {
            return Containment.PARTIAL;
        }
    }

    public static int findOverlap(int a1, int a2, int b1, int b2){
        return a1 - a2 + b1 - b2  - Math.max(Math.abs(a1-b2), Math.abs(b1-a2));
    }

    public static void main(String[] args) throws IOException{
        int[] xValPair1 = new int[2];
        int[] yValPair1 = new int[2];
        int[] xValPair2 = new int[2];
        int[] yValPair2 = new int[2];

        String in = "billboard.in";
        String out = "billboard.out";

        BufferedReader r = new BufferedReader(new FileReader(in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(out)));

        StringTokenizer st = new StringTokenizer(r.readLine());

        xValPair2[0] = Integer.parseInt(st.nextToken());
        yValPair2[0] = Integer.parseInt(st.nextToken());
        xValPair2[1] = Integer.parseInt(st.nextToken());
        yValPair2[1] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(r.readLine());

        xValPair1[0] = Integer.parseInt(st.nextToken());
        yValPair1[0] = Integer.parseInt(st.nextToken());
        xValPair1[1] = Integer.parseInt(st.nextToken());
        yValPair1[1] = Integer.parseInt(st.nextToken());

        r.close();

        int totalArea = Math.abs(xValPair2[0]-xValPair2[1])*Math.abs(yValPair2[0]-yValPair2[1]);

        Containment xCont = findContainment(Math.max(xValPair1[0], xValPair1[1]), Math.min(xValPair1[0], xValPair1[1]), Math.max(xValPair2[0], xValPair2[1]), Math.min(xValPair2[0], xValPair2[1]));
        Containment yCont = findContainment(Math.max(yValPair1[0], yValPair1[1]), Math.min(yValPair1[0], yValPair1[1]), Math.max(yValPair2[0], yValPair2[1]), Math.min(yValPair2[0], yValPair2[1]));

        if(xCont == Containment.NONE || yCont == Containment.NONE){
            pw.println(totalArea);
        } else if(xCont == Containment.FULL && yCont == Containment.FULL){
            pw.println(0);
        } else if(xCont == Containment.PARTIAL && yCont == Containment.PARTIAL){
            pw.println(totalArea);
        } else if(xCont == Containment.FULL){
            pw.println(Math.abs(xValPair2[0]-xValPair2[1])*(Math.abs(yValPair2[0]-yValPair2[1])-findOverlap(Math.max(yValPair1[0], yValPair1[1]), Math.min(yValPair1[0], yValPair1[1]), Math.max(yValPair2[0], yValPair2[1]), Math.min(yValPair2[0], yValPair2[1]))));
        } else if(yCont == Containment.FULL){
            pw.println(Math.abs(yValPair2[0]-yValPair2[1])*(Math.abs(xValPair2[0]-xValPair2[1])-findOverlap(Math.max(xValPair1[0], xValPair1[1]), Math.min(xValPair1[0], xValPair1[1]), Math.max(xValPair2[0], xValPair2[1]), Math.min(xValPair2[0], xValPair2[1]))));
        }

        pw.close();

    }
}
