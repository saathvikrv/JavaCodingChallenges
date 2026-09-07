package org.usacoProbs;

import java.util.HashMap;
import java.util.Scanner;

public class problem71 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int tests = s.nextInt();
        s.nextLine();

        HashMap<Character, Character> CW = new HashMap<>();
        HashMap<Character, Character> CCW = new HashMap<>();

        CW.put('N', 'E');
        CW.put('E', 'S');
        CW.put('S', 'W');
        CW.put('W', 'N');

        CCW.put('N', 'W');
        CCW.put('W', 'S');
        CCW.put('S', 'E');
        CCW.put('E', 'N');

        int turnCount;

        String path;

        for(int t = 0; t < tests; t++) {
            turnCount = 0;
            path = s.nextLine();
            for (int i = 0; i < path.length() - 1; i++) {
                if (CW.get(path.charAt(i)) == path.charAt(i + 1)) {
                    turnCount++;
                } else if (CCW.get(path.charAt(i)) == path.charAt(i + 1)) {
                    turnCount--;
                }
            }

            if (turnCount > 0) {
                System.out.println("CW");
            } else {
                System.out.println("CCW");
            }
        }
    }
}
