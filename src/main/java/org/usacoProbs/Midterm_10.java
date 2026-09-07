package org.usacoProbs;

import java.util.*;

public class Midterm_10 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        s.nextInt();
        int groups = s.nextInt();
        Set<Integer>[] friendGroups = new Set[groups];
        boolean[] groupInvited = new boolean[groups];
        int size;
        for(int group = 0; group < groups; group++){
            size = s.nextInt();
            friendGroups[group] = new HashSet<>();
            for(int i = 0; i < size; i++){
                friendGroups[group].add(s.nextInt());
            }
        }
        System.out.println(Arrays.toString(friendGroups));

        Set<Integer> inviting = new HashSet<>();
        inviting.add(1);
        boolean stillAdding = true;

        int friendsInvited = 0;

        while(stillAdding){
            stillAdding = false;
            for(int set = 0; set < groups; set++){
                if(!groupInvited[set]) {
                    Set<Integer> g = friendGroups[set];

                    Iterator<Integer> i = friendGroups[set].iterator();
                    int count = 0;
                    Integer n = 0;
                    int m = 0;
                    while (i.hasNext()) {
                        n = i.next();
                        if (!inviting.contains(n)) {
                            count++;
                            m = n;
                        }
                    }
                    if (count == 1) {
                        inviting.add(m);
                        groupInvited[set] = true;
                        stillAdding = true;
                        friendsInvited++;
                    }
                }
            }
        }

        System.out.println(friendsInvited + 1);
    }
}
/*
1 7 11 18 5 4 12 13 3 20 9 6 19

 */