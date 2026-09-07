//package org.saathvik;

import java.util.*;

public class Usaco2022Herdle {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine()+scanner.nextLine()+scanner.nextLine();
        String line2 = scanner.nextLine()+scanner.nextLine()+scanner.nextLine();

        System.out.println(herdle(line2, line1)[0]);
        System.out.println(herdle(line2, line1)[1]);
    }


    public static HashMap<String, Integer> getMap(String grid) {
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

        for (int i = 0; i < 9; i++) {
            gridDict.put("" + grid.charAt(i), gridDict.get(""+grid.charAt(i)) + 1);
        }


        return gridDict;
    }

    public static int[] herdle(String guess, String answer){
        int yellows = 0;
        int greens = 0;

        HashMap<String, Integer> guessMap = getMap(guess);

        HashMap<String, Integer> answerMap = getMap(answer);

        int guessFrequency = 0;

        int answerFrequency = 0;

        for(int i = 0; i < 9; i++){
            guessFrequency = guessMap.get(""+answer.charAt(i));
            answerFrequency = answerMap.get(""+answer.charAt(i));

            yellows += Math.min(guessFrequency, answerFrequency);

            answerMap.put(""+answer.charAt(i), 0);
        }


        for(int i = 0; i < 9; i ++) {

            if (guess.charAt(i) == answer.charAt(i)) {
                greens += 1;

            }
        }

        return new int[]{greens, yellows - greens};
    }




//        boolean notInList = true;

//        List<Integer> yellows = new ArrayList<>();
//
//        List<Integer> greens = new ArrayList<>();
//
//        for(int i = 0; i < 9; i ++){
//
//            if(guess[i] == answer[i]){
//                greens.add(i);
//                yellows.add(i);
//            } else {
//
//                for( int j = 0; j < 9; j ++){
//                    for(int n = 0; n < yellows.size(); n++){
//                        if( yellows.get(n) == j){
//                            notInList = false;
//                        }
//                    }
//                    System.out.println(yellows.toString());
//                    if(guess[i] == answer[j] && notInList){
//                        yellows.add(j);
//                    }
//                }
//            }
//        }

//        return new int[]{greens.size(), yellows.size()-greens.size()};
    

}
