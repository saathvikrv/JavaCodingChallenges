package org.usacoProbs;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class HW3_P2 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int lines = s.nextInt();
        String[][] lineInfo = new String[4][lines];
        for(int i = 0; i < lines; i++){
            lineInfo[0][i] = s.next();
            s.next();
            s.next();
            lineInfo[1][i] = s.next();
            lineInfo[2][i] = s.next();
            s.next();
            s.next();
            lineInfo[3][i] = s.next();
        }
        s.close();

        HashMap<String, String[]> cowRegister = new HashMap<>();
        cowRegister.put("Bessie", new String[]{"300", "Ox"});
        String secondCowYear;
        int secondCowYearBorn;
        String prevOrAfter;
        String firstCowYear;
        String[] yearDiff;
        int i = 0;

        //System.out.println(Arrays.toString(lineInfo[0]));
        //System.out.println(Arrays.toString(lineInfo[1]));
        //System.out.println(Arrays.toString(lineInfo[2]));
        //System.out.println(Arrays.toString(lineInfo[3]));

        while(!cowRegister.containsKey("Elsie")){
            secondCowYear =  cowRegister.get(lineInfo[3][i])[1];
            secondCowYearBorn = Integer.parseInt(cowRegister.get(lineInfo[3][i])[0]);
            prevOrAfter = lineInfo[1][i];
            firstCowYear = lineInfo[2][i];

            yearDiff = calcYearDiff(firstCowYear, secondCowYear, prevOrAfter, secondCowYearBorn);
            //System.out.println(lineInfo[0][i]+", "+Arrays.toString(yearDiff));
            cowRegister.put(lineInfo[0][i], yearDiff);
            i+=1;
        }



        System.out.println(Math.abs(300 - Integer.parseInt(cowRegister.get("Elsie")[0])));
    }
    public static String[] calcYearDiff(String cow1Year, String cow2Year, String order, int baseYear){
        HashMap<String, Integer> years = new HashMap<>();
        years.put("Rat", 0);
        years.put("Ox", 1);
        years.put("Tiger", 2);
        years.put("Rabbit", 3);
        years.put("Dragon", 4);
        years.put("Snake", 5);
        years.put("Horse", 6);
        years.put("Goat", 7);
        years.put("Monkey", 8);
        years.put("Rooster", 9);
        years.put("Dog", 10);
        years.put("Pig", 11);

        int year1 = years.get(cow1Year);
        int year2 = years.get(cow2Year);

        int yearDiff = 0;

        if(Objects.equals(order, "previous")){
            if(year1 >= year2){
                year2 += 12;
            }
        } else {
            if(year1 <= year2){
                year1 += 12;
            }
        }

        yearDiff = baseYear + year1 - year2;


        return new String[]{Integer.toString(yearDiff), cow1Year};
    }
}
