package org.usacoProbs;

import java.util.*;

public class Buddies {
    public static void main(String[] buddy){
        Scanner s = new Scanner(System.in);
        int seniors = s.nextInt();

        int freshpeople = s.nextInt();

        int[] seniorTimes = new int[seniors];
        ArrayList<int[]> freshpeopleTimes = new ArrayList<>();

        for(int i =0; i < seniors; i++){
            seniorTimes[i] = s.nextInt();
        }

        for(int i =0; i < freshpeople; i++){
            freshpeopleTimes.add(new int[2]);
            freshpeopleTimes.get(i)[0] = s.nextInt();
            freshpeopleTimes.get(i)[1] = s.nextInt();
        }
        boolean[] used = new boolean[seniors];
        int count = 0;
        Arrays.sort(seniorTimes);
        freshpeopleTimes.sort(Comparator.comparingInt(a -> a[1]));
        freshpeopleTimes.sort(Comparator.comparingInt(a -> a[0]));

        for(int senior : seniorTimes){
            int freshperson = greaterThan(senior, freshpeopleTimes);
            if(freshpeopleTimes.get(freshperson)[0] <= senior){
                count++;
                freshpeopleTimes.remove(freshperson);
            }
            if(freshpeopleTimes.isEmpty()){
                break;
            }
        }
        System.out.println(count);
    }

    public static int smallerThan(int a, ArrayList<int[]> arr){
        int lo = 0;
        int hi = arr.size()-1;
        int mid;
        while(lo < hi){
            // System.out.println(arr[lo] + ", " + arr[hi]);
            mid = (lo+ hi +1)/2;
            if(arr.get(mid)[0] < a){
                lo = mid;
            } else if(arr.get(mid)[0] > a){
                hi = mid-1;
            } if(arr.get(mid)[0] == a){
                return mid;
            }

        }
        return lo;
    }

    public static int greaterThan(int a, ArrayList<int[]> arr){
        int lo = 0;
        int hi = arr.size()-1;
        int mid;
        while(lo < hi){
            // System.out.println(arr[lo] + ", " + arr[hi]);
            mid = (lo+ hi)/2;
            if(arr.get(mid)[1] < a){
                lo = mid+1;
            } else if(arr.get(mid)[1] > a){
                hi = mid;
            } if(arr.get(mid)[1] == a){
                return mid;
            }

        }
        return hi;
    }
}

/*

6 5
2
3
5
7
8
10
3 5
3 6
3 8
4 8
6 15

 */
