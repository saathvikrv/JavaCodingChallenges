package org.usacoProbs;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class problem50 {
    public static void main(String[] args){
        Scanner s= new Scanner(System.in);
        int[] town1 = {s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt()};
        int[] town2 = {s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), -1};
        int town1pop = 1000;
        int minus1posl1;
        int minus1posl2;
        int minus1posl3;
        Set <Integer> pops = new HashSet<>();

        for(int planeIndex = 0; planeIndex < 10; planeIndex++){
            town2[10] = town1[planeIndex];
            town1[planeIndex] = -1;
            minus1posl1 = planeIndex;
            town1pop -= town2[10];

            for(int plane2Index = 0; plane2Index < 11; plane2Index++){
                if(town2[plane2Index] != -1){
                    town1[minus1posl1] = town2[plane2Index];
                    town2[plane2Index] = -1;
                    minus1posl2 = plane2Index;
                    town1pop += town1[planeIndex];

                    for(int plane3Index = 0; plane3Index < 10; plane3Index++){
                        if(town1[plane3Index] != -1) {
                            town2[minus1posl2] = town1[plane3Index];
                            town1[plane3Index] = -1;
                            minus1posl3 = plane3Index;
                            town1pop -= town2[plane2Index];

                            for (int plane4Index = 0; plane4Index < 10; plane4Index++) {
                                if (town2[plane4Index] != -1) {
                                    town1[minus1posl3] = town2[plane4Index];
                                    town2[plane4Index] = -1;
                                    pops.add(town1pop + town1[plane3Index]);
                                    town2[plane4Index] = town1[minus1posl3];
                                    town1[minus1posl3] = -1;
                                }
                            }

                            town1pop += town2[plane2Index];
                            town1[plane3Index] = town2[minus1posl2];
                            town2[minus1posl2] = -1;
                        }
                    }

                    town1pop -= town1[planeIndex];
                    town2[plane2Index] = town1[planeIndex];
                    town1[minus1posl1] = -1;
                }
            }

            town1pop += town2[10];
            town1[planeIndex] = town2[10];
            town2[10] = -1;
        }

        if(pops.contains(1000)){
            System.out.println(pops.size()+1);
        } else {
            System.out.println(pops.size());
        }
    }
}
