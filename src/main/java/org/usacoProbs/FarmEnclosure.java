package org.usacoProbs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class FarmEnclosure {
    public static class AcornTree{
        int x;
        int y;

        public AcornTree(int x, int y){
            this.x = x;
            this.y = y;
        }

        public AcornTree clone(){
            return new AcornTree(x, y);
        }

    }

    public static void main(String[] args){
        Scanner s= new Scanner(System.in);
        int trees = s.nextInt();
        ArrayList<AcornTree> treeLocationsX = new ArrayList<>();
        ArrayList<AcornTree> treeLocationsY = new ArrayList<>();
        for(int i =0; i < trees; i++){
            treeLocationsX.set(i, new AcornTree(s.nextInt(), s.nextInt()));
        }
        for(int i = 0; i < treeLocationsX.size(); i++){
            treeLocationsY.set(i, treeLocationsX.get(i).clone());
        }

        treeLocationsX.sort(Comparator.comparingInt(t -> t.x));
        treeLocationsY.sort(Comparator.comparingInt(t -> t.y));


    }
}
