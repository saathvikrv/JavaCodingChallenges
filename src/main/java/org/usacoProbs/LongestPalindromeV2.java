package org.usacoProbs;

import java.util.Scanner;

public class LongestPalindromeV2 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        StringBuilder str= new StringBuilder();
        String line;

        while(s.hasNextLine()){
            line = s.nextLine();
            str.append(line).append("\n");
        }

        StringBuilder modifiedText = new StringBuilder(str);
        for(int t = 0; t < modifiedText.length(); t++){
            if(!Character.isLetter(modifiedText.charAt(t))){
                modifiedText.deleteCharAt(t);
                t--;
            } else if(!Character.isLowerCase(modifiedText.charAt(t))){
                modifiedText.replace(t, t+1, String.valueOf(Character.toLowerCase(modifiedText.charAt(t))));
            }
        }
        int sizeOdd;
        int maxSizeOdd = 0;
        int maxSizeCentreOdd = -1;
        for(int i = 1; i < modifiedText.length()-1; i++){
            sizeOdd = 0;
            while(i - sizeOdd >= 0 && i + sizeOdd < modifiedText.length() && modifiedText.charAt(i- sizeOdd) == modifiedText.charAt(i+ sizeOdd)){
                sizeOdd++;
            }
            if(sizeOdd > maxSizeOdd){
                maxSizeOdd = sizeOdd;
                maxSizeCentreOdd = i;
            }
        }

        int sizeEven;
        int maxSizeEven = 0;
        int maxSizeCentreEven = -1;
        for(int i = 0; i < modifiedText.length()-1; i++){
            sizeEven = 0;
            while(i - sizeEven >= 0 && i + sizeEven + 1 < modifiedText.length() && modifiedText.charAt(i-sizeEven) == modifiedText.charAt(i+sizeEven + 1)){
                sizeEven++;
            }
            if(sizeEven > maxSizeEven){
                maxSizeEven = sizeEven;
                maxSizeCentreEven = i;
            }
        }
        int endInModifiedStr = maxSizeCentreOdd + maxSizeOdd;
        int startInModifiedStr = maxSizeCentreOdd - maxSizeOdd + 1;

        if(maxSizeEven * 2 + 2 > maxSizeOdd * 2 + 1){
            endInModifiedStr = maxSizeCentreEven + maxSizeEven + 1;
            startInModifiedStr = maxSizeCentreEven - maxSizeEven + 1;
        }

        // System.out.println(modifiedText.substring(maxSizeCentreOdd-maxSizeOdd+1, maxSizeCentreOdd+maxSizeOdd));

        int charsPassed = 0;
        int index = 0;
        while(charsPassed <= startInModifiedStr){
            while(!Character.isLetter(str.charAt(index))){
                index ++;
            }
            index ++;
            charsPassed ++;
        }
        int start = index - 1;

        while(charsPassed < endInModifiedStr){
            while(!Character.isLetter(str.charAt(index))){
                index ++;
            }
            index ++;
            charsPassed ++;
        }
        int end = index;

        System.out.println(Math.max(maxSizeEven * 2 + 2, maxSizeOdd * 2 + 1));
        System.out.println(str.substring(start, end));
    }
}
