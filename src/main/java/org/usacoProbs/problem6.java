package org.usacoProbs;

import java.util.Scanner;

public class problem6 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int leaves = s.nextInt();
        String[] face1 = new String[leaves];
        String[] face2 = new String[leaves];
        for(int i = 0; i < leaves; i++){
            face1[i] = s.next();
            face2[i] = s.next();
        }
        cubesNeeded(leaves, face1, face2);
    }

    public static void cubesNeeded(int leaves, String[] face1, String[] face2){
       char letter;
       int face1Count;
       int face2Count;
       int maxOccurences;
       for(int k = 0; k < 25; k++){
           letter = (char) (k + 97);
           maxOccurences =0;
           for(int i = 0; i < leaves; i++) {
               face1Count = 0;
               face2Count = 0;
               for (int j = 0; j < face1[i].length(); j++) {
                   if (face1[i].charAt(j) == letter) {
                       face1Count++;
                   }
               }
               for (int j = 0; j < face2[i].length(); j++) {
                   if (face2[i].charAt(j) == letter) {
                       face2Count++;
                   }
               }
               maxOccurences += Math.max(face1Count, face2Count);
           }
           System.out.println(maxOccurences);
       }
    }
}
