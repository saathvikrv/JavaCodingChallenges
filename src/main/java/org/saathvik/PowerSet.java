package org.saathvik;
import java.util.Arrays;

public class PowerSet {
    public static void main(String[] args) {
        boolean[] boolList = {false, false, false, false, false, false};
        listSubsets(boolList,0);
    }

    public static void listSubsets(boolean[] keep, int startPos) {

        if(startPos == keep.length) {
            System.out.println(Arrays.toString(keep));

        } else {
            keep[startPos] = true;
            listSubsets(keep, startPos + 1);
            keep[startPos] = false;
            listSubsets(keep, startPos + 1);
        }
        return;
    }
}
