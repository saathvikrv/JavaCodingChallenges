package org.usacoProbs;

import java.util.*;

public class Final_11 {
    public static class Pair{
        public int pos;
        public int breed;

        public Pair(int a, int b){
            this.pos = a;
            this.breed = b;
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof Pair && pos == ((Pair) obj).pos && breed == ((Pair) obj).breed;
        }

        public int hashCode() {
            return Objects.hash(pos, breed);
        }
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int dogs = s.nextInt();
        Pair[] dogPositions = new Pair[dogs];

        Set<Integer> breeds = new HashSet<>();

        for(int i = 0; i < dogs; i++){
            dogPositions[i] = new Pair(s.nextInt(), s.nextInt());
            breeds.add(dogPositions[i].breed);
        }

        Arrays.sort(dogPositions, Comparator.comparingInt(dog -> dog.pos));
        HashMap<Integer, Integer> breedCount = new HashMap<>();

        int first;
        int last;
        int minWindow = Integer.MAX_VALUE;
        int windowSize = breeds.size();

        while(windowSize < dogPositions.length){
            breedCount.clear();
            first = 0;
            last = windowSize-1;
            for(int i = 0; i <= last; i++){
                breedCount.putIfAbsent(dogPositions[i].breed, 0);
                breedCount.put(dogPositions[i].breed, breedCount.get(dogPositions[i].breed) + 1);
            }

            while(last < dogPositions.length){
                if(breedCount.size() == breeds.size()){
                    minWindow = Math.min(dogPositions[last].pos - dogPositions[first].pos, minWindow);
                }
                first++;
                last++;
                if(last < dogPositions.length){
                    breedCount.put(dogPositions[first-1].breed, breedCount.get(dogPositions[first-1].breed) - 1);
                    if(breedCount.get(dogPositions[first-1].breed) == 0){
                        breedCount.remove(dogPositions[first-1].breed);
                    }
                    breedCount.putIfAbsent(dogPositions[last].breed, 0);
                    breedCount.put(dogPositions[last].breed, breedCount.get(dogPositions[last].breed) + 1);
                }
            }
            windowSize++;
        }

        System.out.println(minWindow);
    }
}
