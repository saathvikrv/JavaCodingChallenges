package org.usacoProbs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class AcornDispensing {
    public static class Coord{
        public int x;
        public int y;

        public Coord(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof AcornDispensing.Coord && x == ((AcornDispensing.Coord) obj).x && y == ((AcornDispensing.Coord) obj).y;
        }

        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static HashMap<Coord, ArrayList<Coord>> levers;
    public static char[][] grid;
    public static int newlyFound;
    public static int count;

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int mansionSize = s.nextInt();
        int leversSize = s.nextInt();
        levers = new HashMap<>();
        grid = new char[mansionSize][mansionSize];
        Coord value;

        for(int i = 0; i < leversSize; i++){
            Coord key = new Coord(s.nextInt()-1, s.nextInt()-1);
            value = new Coord(s.nextInt()-1, s.nextInt()-1);

            if(!levers.containsKey(key)) {
                levers.put(key, new ArrayList<>());
            }
            levers.get(key).add(value);
        }

        int prevCount = -1;
        count = 0;
        grid[0][0] = '@';
        newlyFound = 0;
        int i = 1;

        while(count > prevCount) {
            prevCount = count;
            count = 0;
            grid[0][0] = (char) i;
            floodfill(grid, 0, 0, (char) i);
            i++;
        }

        System.out.println(1 + newlyFound);



    }

    public static void floodfill(char[][] topView, int x, int y, char toFillWith){
        if(levers.containsKey(new Coord(x, y))){
            ArrayList<Coord> list = levers.get(new Coord(x, y));
            for(Coord c : list) {
                if(topView[c.x][c.y] == '\u0000') {
                    topView[c.x][c.y] = '.';
                    newlyFound++;
//                    for(int n = 0; n < topView.length; n++){
//                        for (char[] chars : topView) {
//                            System.out.print(chars[n]);
//                        }
//                        System.out.println();
//                    }
//                    System.out.println();
                }
            }
        }

        int[][] possibleNextPositions = {
                {x+1, y},
                {x-1, y},
                {x, y+1},
                {x, y-1},
        };
        for(int[] nextPos : possibleNextPositions){
            if(
                    nextPos[0] >= 0 &&
                    nextPos[0] < topView.length &&
                    nextPos[1] >= 0 &&
                    nextPos[1] < topView.length &&
                    topView[nextPos[0]][nextPos[1]] != toFillWith &&
                    topView[nextPos[0]][nextPos[1]] != '\u0000'
            ){
                topView[nextPos[0]][nextPos[1]] = toFillWith;
                count++;
                floodfill(topView, nextPos[0], nextPos[1], toFillWith);
            }
        }
    }
}

/*

5 25
5 3 4 3        . . . # .
1v1 1 3        . . # # .
1v3 2 2        . . . . #
4 2 4 3        . # # # .
1v1 1 2        . # # . #
1 4 3 5
5 1 3 1
5 3 5 2
4v3 4 5
5 4 3 1
5 4 3 4
3 4 5 4
3v3 4 3
3v3 1 5
1v2 2 1
4 5 3 1
1v4 3 3
4 5 1 3
2v1 5 1
3 5 5 1
2v1 1 4
4v3 5 4
1v3 2 3
3v3 5 2
1v2 3 1

 */
