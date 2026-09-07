package org.usacoProbs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class RaceCarUpgrade {
    public static void main(String[] args){
        Scanner s= new Scanner(System.in);
        double carForce = s.nextInt();
        double carMass = s.nextInt();
        int upgradesAvailable = s.nextInt();
        Upgrade[] upgrades = new Upgrade[upgradesAvailable];
        for(int i =0; i < upgradesAvailable; i++){
            upgrades[i] = new Upgrade(s.nextInt(), s.nextInt(), i+1);
        }
        Arrays.sort(upgrades);
        ArrayList<Integer> order = new ArrayList<>();

        for(Upgrade upgrade : upgrades){

            if((carForce + upgrade.force)/(carMass + upgrade.mass) > carForce/carMass){
                carMass += upgrade.mass;
                carForce += upgrade.force;
                order.add(upgrade.number);
            } else {
                break;
            }
        }

        Collections.sort(order);
        if(order.isEmpty()){
            System.out.println("NONE");
        } else {
            for (int n : order) {
                System.out.println(n);
            }
        }

    }


    public static class Upgrade implements Comparable<Upgrade>{
        public double force;
        public double mass;
        public int number;

        public Upgrade(int force, int mass, int number){
            this.force = force;
            this.mass = mass;
            this.number = number;
        }

        @Override
        public int compareTo(Upgrade other) {
            double thisRatio = force/mass;
            double otherRatio = other.force/other.mass;
            if(thisRatio == otherRatio){
                return Double.compare(force, other.force) * -1;
            } else {
                return Double.compare(thisRatio, otherRatio) * -1;
            }
        }
    }
}
