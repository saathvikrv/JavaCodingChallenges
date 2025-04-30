package org.saathvik;

import java.util.Arrays;


public class EightQueens {
    public static void main(String[] args) {



        int currentRow =0;
        int[] queenPos = {-1,-1,-1,-1,-1,-1,-1,-1};
        while(currentRow>-1){
            queenPos[currentRow]+=1;
            if(queenPos[currentRow]>7){
                queenPos[currentRow] = -1;
                currentRow -= 1;
            }
            else if(checkRowValid(queenPos, currentRow)){
                currentRow+=1;
                if(currentRow>7){
                    System.out.println(Arrays.toString(queenPos));
                    currentRow-=1;
                }
            }

        }

    }

    public static boolean checkRowValid(int[] pawns, int rowNum){
        int y = rowNum;
        int x = pawns[rowNum];

        for(int i = 0; i < rowNum; i++){
            //System.out.println("looped"+rowNum);
            if(pawns[i] == pawns[rowNum] || Math.abs(y - i) == Math.abs(x - pawns[i])) {
                return false;
            }
        }

        return true;
    }

}