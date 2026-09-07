package org.usacoProbs;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class problem66 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String[][] mothers = new String[s.nextInt()][2];
        String target1 = s.next();
        String target2 = s.next();
        for(int i =0 ; i < mothers.length; i++){
            mothers[i][0] = s.next();
            mothers[i][1] = s.next();
        }

        String  current = target1;
        ArrayList<String> lineage1 = new ArrayList<>();
        ArrayList<String> lineage2 = new ArrayList<>();
        boolean hasMother = true;
        while(hasMother){
            hasMother = false;
            for(String[] pair : mothers){
                if(Objects.equals(pair[1], current)){
                    lineage1.add(pair[0]);
                    current = pair[0];
                    hasMother = true;
                    break;
                }
            }
        }
        current = target2;
        hasMother = true;
        while(hasMother){
            hasMother = false;
            for(String[] pair : mothers){
                if(Objects.equals(pair[1], current)){
                    lineage2.add(pair[0]);
                    current = pair[0];
                    hasMother = true;
                    break;
                }
            }
        }
        StringBuilder relation;
        int i = 1;

        if(!lineage1.isEmpty() && !lineage2.isEmpty() && Objects.equals(lineage1.getFirst(), lineage2.getFirst())){
            System.out.println("SIBLINGS");
            System.exit(0);
        }

        for(String tree : lineage1){
            if(Objects.equals(tree, target2)){
                if(i == 1){
                    System.out.println(target2 + " is the mother of " + target1);
                } else if(i == 2){
                    System.out.println(target2 + " is the grand-mother of " + target1);
                } else {
                    relation = new StringBuilder("grand-mother of" + target1);
                    for(int n = 3; n < i; n++){
                        relation.insert(0, "great-");
                    }
                    relation.insert(0, target2 + "is the ");
                    System.out.println(relation);
                }
                System.exit(0);
            }
            i++;
        }

        for(String tree : lineage2){
            if(Objects.equals(tree, target1)){
                if(i == 1){
                    System.out.println(target1 + " is the mother of " + target2);
                } else if(i == 2){
                    System.out.println(target1 + " is the grand-mother of " + target2);
                } else {
                    relation = new StringBuilder("grand-mother of" + target2);
                    for(int n = 3; n < i; n++){
                        relation.insert(0, "great-");
                    }
                    relation.insert(0, target1 + "is the ");
                    System.out.println(relation);
                }
                System.exit(0);
            }
            i++;
        }

        for(int tree1 = 0; tree1 < lineage1.size(); tree1++){
            for(int tree2 = 0; tree2 < lineage2.size(); tree2++){
                if(Objects.equals(lineage1.get(tree1), lineage2.get(tree2))){
                    if(tree1-tree2 == 1){
                        System.out.println(target2 + " is the aunt of " + target1);
                    } else if(tree2-tree1 == 1){
                        System.out.println(target1 + " is the aunt of " + target2);
                    } else if(tree1 > tree2){
                        relation = new StringBuilder("aunt of " + target1);
                        for(int n = 1; n < tree1-tree2; n++){
                            relation.insert(0, "great-");
                        }
                        relation.insert(0, target2 + " is the ");
                        System.out.println(relation);
                    } else if(tree2 > tree1){
                        relation = new StringBuilder("aunt of " + target2);
                        for(int n = 1; n < tree2-tree1; n++){
                            relation.insert(0, "great-");
                        }
                        relation.insert(0, target1 + " is the ");
                        System.out.println(relation);
                    } if(tree1 == tree2){
                        System.out.println("COUSINS");
                    }

                    System.exit(0);
                }
            }
        }

        System.out.println("NOT RELATED");


    }
}
