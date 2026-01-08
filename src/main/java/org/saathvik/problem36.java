package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class problem36 {
    public static boolean isStylish(String[][] subPops){
        System.out.println(Arrays.deepToString(subPops));
        String trait1;
        String trait2;
        boolean trait1Occurence;
        boolean trait2Occurence;
        boolean trait1Good;
        boolean trait2Good;


        for(String[] traits : subPops){
            for(int i = 0; i < traits.length; i++){
                for(int j = i+1; j < traits.length; j++){
                    trait1 = traits[i];
                    trait2 = traits[j];
                    trait1Good = false;
                    trait2Good = false;

                    for(String[] subPopTraits : subPops){
                        trait1Occurence = false;
                        trait2Occurence = false;
                        for(String trait : subPopTraits){
                            if(Objects.equals(trait, trait1)){
                                trait1Occurence = true;
                            }   else if(Objects.equals(trait, trait2)){
                                trait2Occurence = true;
                            }
                        }
                        if(trait1Occurence && !trait2Occurence){
                            trait1Good = true;

                        }
                        if(trait2Occurence && !trait1Occurence){
                            trait2Good = true;
                        }
                        if(trait1Good && trait2Good){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        Scanner l;
        ArrayList<ArrayList<String>> subPops = new ArrayList<>();
        int m = s.nextInt();
        int q = 0;
        for(int i =0; i <= m; i++){
            subPops.add(new ArrayList<>());
            l = new Scanner(s.nextLine());
            if(l.hasNext()) {
                l.next();
            }
            while(l.hasNext()){
                subPops.get(q).add(l.next());
            }
            q++;
        }

        String[][] stringArray = subPops.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);

        boolean res = isStylish(stringArray);

        if(res){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
    }
}
