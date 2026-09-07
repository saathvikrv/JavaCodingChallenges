package org.usacoProbs;



import java.util.Scanner;

public class problem4 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        s.nextLine();
        String str = s.nextLine();
        boolean unique = true;

        for(int k = 1; k < N-1; k++){
            unique = true;
            for(int p = 0; p < N-k; p++){
                System.out.println(str.substring(p+1, N));
                System.out.println(str.substring(p, p+k));

                if(str.substring(p+1, N-1).contains(str.substring(p, p+k))){
                    unique = false;
                    break;
                }
            }
            if(unique){
                System.out.println(k);
                break;
            }
        }

    }


}
