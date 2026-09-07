//package org.saathvik;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Usaco2023MooRoute {
////    public static int[] crossRecord;
////    public static ArrayList<int[]> answers;
////
////
////    public static void generate(int currPos, int[] dir, int index, int[] crossed){
////        if(Arrays.equals(crossed, crossRecord)) {
////            answers.add(dir.clone());
////
////        } else if(index < dir.length){
////            if (currPos > 0) {
////                dir[index] = -1;
////                crossed[currPos - 1]++;
////                generate(currPos - 1, dir, index + 1, crossed);
////                crossed[currPos - 1]--;
////            }
////            if (currPos < dir.length){
////                dir[index] = 1;
////                crossed[currPos]++;
////                generate(currPos + 1, dir, index + 1, crossed);
////                crossed[currPos]--;
////            }
////        }
////    }
////
////    public static void main(String[] args){
////        int len = 10;
////
////        int[] dir = new int[len];
////        int[] crossed = new int[dir.length];
////        crossRecord = new int[dir.length];
////        crossRecord = new int[]{2, 4, 4, 0, 0, 0, 0, 0, 0, 0};
////        answers = new ArrayList<>();
////
////
////        generate(0, dir, 0, crossed);
////
////        for(int[] ans : answers){
////            System.out.println(Arrays.toString(ans));
////        }
////    }
//
//    public static void main(String[] args){
//        int[] n = new int[]{0, 2, 4, 4, 0};
//        int prevDir = 1;
//        int currPos = 1;
//        while(){
//            if(prevDir == 1 && currPos > 0){
//                n[currPos] --;
//                currPos++;
//                System.out.print("R");
//            } else if(prevDir == -1 && currPos - 1 > 0){
//                n[currPos-1] --;
//                currPos--;
//                System.out.print("L");
//            } else if(currPos == 0){
//                n[currPos-1] --;
//                currPos--;
//                prevDir = 1;
//                System.out.print("L");
//            } else if(currPos-1 == 0){
//                n[currPos] --;
//                currPos++;
//                prevDir = -1;
//                System.out.print("R");
//            }
//        }
//    }
//
//}
