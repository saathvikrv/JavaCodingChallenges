package org.usacoProbs;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class problem20 {
    public static void main(String[] args) throws IOException {
        String in = "breedflip.in";
        String out = "breedflip.out";

        BufferedReader r = new BufferedReader(new FileReader(in));
        r.readLine();




        String cowBreedsGoal = r.readLine();
        String cowBreedsGiven = r.readLine();
        r.close();

        long gaps = 0;
        for(long i = 0; i < cowBreedsGoal.length(); i++){
            if(cowBreedsGoal.charAt((int) i) != cowBreedsGiven.charAt((int) i)) {
                gaps++;
                while (cowBreedsGoal.charAt((int) i) != cowBreedsGiven.charAt((int) i)) {
                    i++;
                }
            }
        }

        PrintWriter pw = new PrintWriter(out);

        pw.println(gaps);

        pw.close();
    }

}
