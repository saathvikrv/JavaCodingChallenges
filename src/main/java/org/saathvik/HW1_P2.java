package org.example;

public class HW1_P2 {
    public static void main(String[] args){
        int[] a = {1, 10, 6, 1};
        int[] b = {3, 6, 3, 6};
        System.out.println(whoWins(a, b));
    }




    public static char whoWins(int[] a, int[] b) {
        int aScore = 0;
        int bScore = 0;

        for(int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                if (a[i] > b[j]) {
                    aScore += 1;
                } else if (a[i] < b[j]) {
                    bScore += 1;
                }
            }
        }


        if(aScore > bScore){
            //System.out.println('a');
            return 'a';
        } else if(aScore < bScore){
            //System.out.println('b');
            return 'b';
        } else {
            //System.out.println('-');
            return '-';
        }
    }
}
