package org.usacoProbs;

import java.util.*;

public class WoodlandPatterns {
    public static void main(String[] args){
        Scanner s= new Scanner(System.in);
        int cities = s.nextInt();
        CityAbbrevPair[] pairs = new CityAbbrevPair[cities];
        CityAbbrevPair[] pairsReversed = new CityAbbrevPair[cities];
        TwoChar a;
        TwoChar b;

        for(int i = 0; i < cities; i++){
            b = new TwoChar(s.next());
            a = new TwoChar(s.next());
            pairs[i] = new CityAbbrevPair(a, b);
            pairsReversed[i] = new CityAbbrevPair(b, a);
        }
        // System.out.println(Arrays.toString(pairs));
        // System.out.println(Arrays.toString(pairsReversed));

        HashMap<CityAbbrevPair, Integer> occurrences = new HashMap<>();
        int commonCount = 0;

        for(CityAbbrevPair n : pairs){
            if(occurrences.containsKey(n)){
                occurrences.put(n, occurrences.get(n) + 1);
            } else {
                occurrences.put(n, 1);
            }
        }

        for(CityAbbrevPair n : pairsReversed){
            if(!n.name.equals(n.abbrev)) {
                if (occurrences.containsKey(n)) {
                    commonCount += occurrences.get(n);
                }
            }
        }

        System.out.println(commonCount / 2);
    }

    private static class TwoChar implements Comparable<TwoChar>{
        char first;
        char second;
        public TwoChar(String s){
            first = s.charAt(0);
            second = s.charAt(1);
        }

        public TwoChar(char f, char s){
            first = f;
            second = s;
        }

        @Override
        public int compareTo(TwoChar o) {
            if(o.first == this.first){
                return Character.compare(o.second, this.second);
            } else {
                return Character.compare(o.first, this.first);
            }
        }

        public boolean equals(TwoChar other){
            return first == other.first && second == other.second;
        }
    }

    private static class CityAbbrevPair implements Comparable<CityAbbrevPair>{
        TwoChar name;
        TwoChar abbrev;

        public CityAbbrevPair(TwoChar name, TwoChar abbrev){
            this.name = name;
            this.abbrev = abbrev;
        }

        @Override
        public int compareTo(CityAbbrevPair other) {
            if(name.equals(other.name)){
                return abbrev.compareTo(other.abbrev);
            } else {
                return name.compareTo(other.name);
            }
        }

        public void reverse(){
            TwoChar temp = new TwoChar(name.first, name.second);
            name = new TwoChar(abbrev.first, abbrev.second);
            abbrev = temp;
        }

        @Override
        public String toString(){
            return "{" + name.first+ name.second + ", " + abbrev.first+abbrev.second+ "}";
        }

        @Override
        public int hashCode() {
            return Objects.hash(name.first, name.second, abbrev.first, abbrev.second);
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof CityAbbrevPair) {
                return ((CityAbbrevPair) obj).compareTo(this) == 0;
            } else {
                return false;
            }
        }
    }
}
