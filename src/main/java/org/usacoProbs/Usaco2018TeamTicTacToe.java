package org.usacoProbs;

import java.io.*;
import java.util.*;


public class Usaco2018TeamTicTacToe {

    public static void main(String[] args) throws IOException{
        String in = "tttt.in";
        String out = "tttt.out";

//        BufferedReader r = new BufferedReader(new FileReader(in));
//        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(out)));
        BufferedReader r = new BufferedReader(new FileReader(System.in.toString()));

        String[] grid = new String[3];

        grid[0] = r.readLine();
        grid[1] = r.readLine();
        grid[2] = r.readLine();

        r.close();

        System.out.println(teamTicTacToe(grid)[0]);
        System.out.println(teamTicTacToe(grid)[1]);

//        pw.println(teamTicTacToe(grid)[0]);
//        pw.println(teamTicTacToe(grid)[1]);
//
//        pw.close();
    }


    public static HashMap<String, Integer> makeABCMap(){
        HashMap<String, Integer> gridDict = new HashMap<>();


        gridDict.put("A", 0);
        gridDict.put("B", 0);
        gridDict.put("C", 0);
        gridDict.put("D", 0);
        gridDict.put("E", 0);
        gridDict.put("F", 0);
        gridDict.put("G", 0);
        gridDict.put("H", 0);
        gridDict.put("I", 0);
        gridDict.put("J", 0);
        gridDict.put("K", 0);
        gridDict.put("L", 0);
        gridDict.put("M", 0);
        gridDict.put("N", 0);
        gridDict.put("O", 0);
        gridDict.put("P", 0);
        gridDict.put("Q", 0);
        gridDict.put("R", 0);
        gridDict.put("S", 0);
        gridDict.put("T", 0);
        gridDict.put("U", 0);
        gridDict.put("V", 0);
        gridDict.put("W", 0);
        gridDict.put("X", 0);
        gridDict.put("Y", 0);
        gridDict.put("Z", 0);

        return gridDict;
    }

//    public static int tripletCheck(String abc){
//        if(abc.charAt(0) == abc.charAt(1) || abc.charAt(1) == abc.charAt(2) || abc.charAt(2) == abc.charAt(0)) {
//            if (abc.charAt(0) == abc.charAt(1) && abc.charAt(0) == abc.charAt(2)){
//                return 1;
//            } else {
//                return 0;
//            }
//        } else {
//            return -1;
//        }
//
//    }

    public static Set<Character> toSet(char a, char b, char c){
        Set<Character> s = new HashSet<>();
        s.add(a);
        s.add(b);
        s.add(c);
        return s;
    }

    public static int[] teamTicTacToe(String[] rows){
        /*String[] columns = {"" + rows[0].charAt(0) + rows[1].charAt(0) + rows[2].charAt(0), "" + rows[0].charAt(1) + rows[1].charAt(1) + rows[2].charAt(1), "" + rows[0].charAt(2) + rows[1].charAt(2) + rows[2].charAt(2)};
        String[] diagonals = {"" + rows[0].charAt(0) + rows[1].charAt(1) + rows[2].charAt(2), "" + rows[2].charAt(0) + rows[1].charAt(1) + rows[0].charAt(2)};*/

        Set<Set<Character>> allianceWinners = new HashSet<>();

        Set<Set<Character>> individualWinners = new HashSet<>();

        Set<Character> set = toSet(rows[0].charAt(0), rows[0].charAt(1), rows[0].charAt(2));

        if(set.size() == 1){
            individualWinners.add(set);
        } else if(set.size() == 2){
            allianceWinners.add(set);
        }

        set = toSet(rows[1].charAt(0), rows[1].charAt(1), rows[1].charAt(2));
        if(set.size() == 1){
            individualWinners.add(set);
        } else if(set.size() == 2){
            allianceWinners.add(set);
        }
        set = toSet(rows[2].charAt(0), rows[2].charAt(1), rows[2].charAt(2));
        if(set.size() == 1){
            individualWinners.add(set);
        } else if(set.size() == 2){
            allianceWinners.add(set);
        }
        set = toSet(rows[0].charAt(0), rows[1].charAt(0), rows[2].charAt(0));
        if(set.size() == 1){
            individualWinners.add(set);
        } else if(set.size() == 2){
            allianceWinners.add(set);
        }
        set = toSet(rows[0].charAt(1), rows[1].charAt(1), rows[2].charAt(1));
        if(set.size() == 1){
            individualWinners.add(set);
        } else if(set.size() == 2){
            allianceWinners.add(set);
        }
        set = toSet(rows[0].charAt(2), rows[1].charAt(2), rows[2].charAt(2));
        if(set.size() == 1){
            individualWinners.add(set);
        } else if(set.size() == 2){
            allianceWinners.add(set);
        }
        set = toSet(rows[0].charAt(0), rows[1].charAt(1), rows[2].charAt(2));
        if(set.size() == 1){
            individualWinners.add(set);
        } else if(set.size() == 2){
            allianceWinners.add(set);
        }
        set = toSet(rows[2].charAt(0), rows[1].charAt(1), rows[0].charAt(2));

        if(set.size() == 1){
            individualWinners.add(set);
        } else if(set.size() == 2){
            allianceWinners.add(set);
        }



        /*if(tripletCheck(rows[0]) == 1){
            individualWinners += 1;
            IWList.add("row 1");
        } else if(tripletCheck(rows[0]) == 0){
            allianceWinners += 1;
            AWList.add("row 1");
        }

        if(tripletCheck(rows[1]) == 1){
            individualWinners += 1;
            IWList.add("row 2");
        } else if(tripletCheck(rows[1]) == 0){
            allianceWinners += 1;
            AWList.add("row 2");
        }

        if(tripletCheck(rows[2]) == 1){
            individualWinners += 1;
            IWList.add("row 3");
        } else if(tripletCheck(rows[2]) == 0){
            allianceWinners += 1;
            AWList.add("row 3");
        }

        if(tripletCheck(columns[0]) == 1){
            individualWinners += 1;
            IWList.add("column 1");
        } else if(tripletCheck(columns[0]) == 0){
            allianceWinners += 1;
            AWList.add("column 1");
        }

        if(tripletCheck(columns[1]) == 1){
            individualWinners += 1;
            IWList.add("column 2");
        } else if(tripletCheck(columns[1]) == 0){
            allianceWinners += 1;
            AWList.add("column 2");
        }

        if(tripletCheck(columns[2]) == 1){
            individualWinners += 1;
            IWList.add("column 3");
        } else if(tripletCheck(columns[2]) == 0){
            allianceWinners += 1;
            AWList.add("column 3");
        }

        if(tripletCheck(diagonals[0]) == 1){
            individualWinners += 1;
            IWList.add("diagonal 1");
        } else if(tripletCheck(diagonals[0]) == 0){
            allianceWinners += 1;
            AWList.add("diagonal 1");
        }

        if(tripletCheck(diagonals[1]) == 1){
            individualWinners += 1;
            IWList.add("diagonal 2");
        } else if(tripletCheck(diagonals[1]) == 0){
            allianceWinners += 1;
            AWList.add("diagonal 2");
        }*/

        return new int[]{individualWinners.size(), allianceWinners.size()};

    }

}
