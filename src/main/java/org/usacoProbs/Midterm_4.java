package org.usacoProbs;

import java.util.*;

public class Midterm_4 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        char[][] grid = new char[s.nextInt()][s.nextInt()];
        String line;
        s.nextLine();
        for(int x = 0; x < grid.length; x++){
            line = s.nextLine();
            for(int y = 0; y < grid[0].length; y++){
                grid[x][y] = line.charAt(y);
            }
        }


        boolean currSlot = false;
        ArrayList<ArrayList<Integer>> coords = new ArrayList<>();
        ArrayList<Integer> pair;
        for(int y = 0; y < grid[0].length; y++){
            currSlot = false;
            for(int x = 0; x < grid.length; x++){
                if(grid[x][y] == '#'){
                    currSlot = false;
                }
                if(grid[x][y] == '.' && x + 2 < grid.length && grid[x+1][y] == '.' && grid[x+2][y] == '.' && !currSlot){
                    currSlot = true;
                    pair = new ArrayList<>();
                    pair.add(x);
                    pair.add(y);
                    coords.add(pair);
                }
            }
        }
        currSlot = false;
        for(int x = 0; x < grid.length; x++){
            currSlot = false;
            for(int y = 0; y < grid[0].length; y++){
                if(grid[x][y] == '#'){
                    currSlot = false;
                }
                if(grid[x][y] == '.' && y + 2 < grid[0].length && grid[x][y+1] == '.' && grid[x][y+2] == '.' && !currSlot){
                    currSlot = true;
                    pair = new ArrayList<>();
                    pair.add(x);
                    pair.add(y);
                    coords.add(pair);
                }
            }
        }


        coords.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
                if (Objects.equals(arr1.get(0), arr2.get(0))) {
                    return Integer.compare(arr1.get(1), arr2.get(1));
                } else {
                    return Integer.compare(arr1.getFirst(), arr2.getFirst());
                }
            }
        });
        LinkedHashSet<ArrayList<Integer>> hashSet = new LinkedHashSet<>(coords);
        coords.clear();
        coords.addAll(hashSet);


        System.out.println(coords.size());
        for(ArrayList<Integer> coordPair : coords){
            grid[coordPair.getFirst()][coordPair.get(1)] = '!';
            System.out.println((coordPair.getFirst()+1) + " " + (coordPair.get(1)+1));
        }
    }
}
