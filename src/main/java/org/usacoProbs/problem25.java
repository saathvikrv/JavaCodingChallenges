package org.usacoProbs;


import java.util.Objects;
import java.util.Scanner;

public class problem25 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int recordNum = s.nextInt();



        log[] FJlogs = new log[recordNum];

        String typeOfRecord;

        for(int i = 0; i < recordNum; i++){
            typeOfRecord = s.next();
            FJlogs[i] = new log(s.nextInt(), s.nextInt(), typeOfRecord);
        }




        int minPassengers = 0;
        int maxPassengers = 0;

        boolean first = true;
        log record;

        for(int i = 0; i < FJlogs.length; i++){
            record = FJlogs[i];

            if(Objects.equals(record.recordType, "off")){
                minPassengers -= record.maxCows;
                maxPassengers -= record.minCows;
            } else if(Objects.equals(record.recordType, "on")){
                minPassengers += record.minCows;
                maxPassengers += record.maxCows;
            } else if(Objects.equals(record.recordType, "none")){
                if(first){
                    maxPassengers = record.maxCows;
                    minPassengers = record.minCows;
                    first = false;
                } else {
                    if (maxPassengers > record.maxCows) {
                        maxPassengers = record.maxCows;
                    }
                    if (minPassengers < record.minCows) {
                        minPassengers = record.minCows;
                    }
                }
            }
        }

        int minPassengersEnd = minPassengers;
        int maxPassengersEnd = maxPassengers;

        minPassengers = 0;
        maxPassengers = 0;

        first = true;

        for(int i = 0; i < FJlogs.length; i++){
            record = FJlogs[FJlogs.length - 1 - i];

            if(Objects.equals(record.recordType, "off")){
                minPassengers += record.minCows;
                maxPassengers += record.maxCows;
            } else if(Objects.equals(record.recordType, "on")){
                minPassengers -= record.maxCows;
                maxPassengers -= record.minCows;
            } else if(Objects.equals(record.recordType, "none")){
                if(first){
                    maxPassengers = record.maxCows;
                    minPassengers = record.minCows;
                    first = false;
                } else {
                    if (maxPassengers > record.maxCows) {
                        maxPassengers = record.maxCows;
                    }
                    if (minPassengers < record.minCows) {
                        minPassengers = record.minCows;
                    }
                }
            }
        }
        if(minPassengers < 0){
            minPassengers = 0;
        }

        if(minPassengersEnd < 0){
            minPassengersEnd = 0;
        }

        if(maxPassengers < 0){
            maxPassengers = 0;
        }

        if(maxPassengersEnd < 0){
            maxPassengersEnd = 0;
        }


        System.out.println(minPassengers+" "+maxPassengers);
        System.out.println(minPassengersEnd+" "+maxPassengersEnd);

    }


}

class log {
    String recordType;
    int minCows;
    int maxCows;

    public log(int minNum, int maxNum, String type){
        this.maxCows = maxNum;
        this.minCows = minNum;
        this.recordType = type;
    }

    public int minCows(){
        return this.minCows;
    }

    public int maxCows(){
        return this.maxCows;
    }

    public String recordType(){
        return this.recordType;
    }

    public void setMinCows(int min){
        this.minCows = min;
    }

    public void setMaxCows(int max){
        this.maxCows = max;
    }

    public void setRecordType(String type){
        this.recordType = type;
    }
}
