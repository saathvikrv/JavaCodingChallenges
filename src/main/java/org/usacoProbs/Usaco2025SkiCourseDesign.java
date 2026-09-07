package org.usacoProbs;

import java.util.Arrays;

public class Usaco2025SkiCourseDesign {

    public static void main(String[] args) {
        int[] hillList = {20, 4, 1, 24, 21};
        System.out.println(skiCourseDesign(5, hillList));
    }


    public static int skiCourseDesign(int hillNum, int[] hills){

        Arrays.sort(hills);
        int price = 0;
        int j;

        if(hills[hills.length-1]-hills[0]<=17){
            return 0;
        } else {
            int increase = hills[hills.length-1]-17;
            int i = 0;
             while(hills[i] < increase){

                 j=increase - hills[i];
                 price+=j*j;
                 i+=1;
            }

            return price;
        }
    }

}
