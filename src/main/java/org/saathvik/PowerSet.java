package org.saathvik;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSet {
    public static void main(String[] args) {
        int a = 1;
        System.out.println(listSubsets(a));
    }

    public static List<List<Integer>> listSubsets(int setLength){
        if(setLength==1){
            List<List<Integer>> list = new ArrayList<>();
            list.add(new ArrayList<>());
            list.add(new ArrayList<>(Arrays.asList(0)));
            return list;
        }

        /*
            split list in to two parts: everything except the last term, and the last term
            run recursion on first part
            duplicate result
            add last term to every list in the second copy
            add both copies
            return result
        */


        int lastTerm = setLength - 1;
        List<List<Integer>> recursedPart = listSubsets(lastTerm);
        //List<List<Integer>> duplicatedPart = recursedPart;
        addToSublists(recursedPart, lastTerm);
        recursedPart.addAll(listSubsets(lastTerm));
        return recursedPart;
    }
    public static void addToSublists(List<List<Integer>> list, int numToAdd) {
        for(int i = 0; i < list.toArray().length; i++){
            list.get(i).add(numToAdd);
        }
    }
}
