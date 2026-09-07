package org.usacoProbs;

import java.util.*;

public class Usaco2023FindAndReplace {
    public static void main(String[] args){
        String curr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String target = "AbcdefghijklmnopqrstuvwxyzaBCDEFGHIJKLMNOPQRSTUVWXYZ";

        solve(curr, target);
    }

    public static void solve(String curr, String target){

        HashMap<Character, Character> map = new HashMap<>();
        Set<Character> duplicates = new HashSet<>();

        for(int i = 0; i < curr.length(); i++){
            if(map.containsKey(curr.charAt(i)) && map.get(curr.charAt(i)) != target.charAt(i)){
                System.out.println(-1);
                return;
            } else if(curr.charAt(i) != target.charAt(i)){
                map.putIfAbsent(curr.charAt(i), target.charAt(i));
            } else {
                duplicates.add(curr.charAt(i));
            }
        }
        if(duplicates.size() + map.size() == 52){
            System.out.println(-1);
            return;
        }

        Iterator<Map.Entry<Character, Character>> i = map.entrySet().iterator();
        Set<Character> toRemove = new HashSet<>();
        while(i.hasNext()){
            Map.Entry<Character, Character> e = i.next();
            if(map.containsKey(e.getValue()) && map.get(e.getValue()) == e.getKey()){
                toRemove.add(e.getKey());
                toRemove.add(e.getValue());
            }
        }

        for (Character character : toRemove) {
            map.remove(character);
        }

        





    }


}
