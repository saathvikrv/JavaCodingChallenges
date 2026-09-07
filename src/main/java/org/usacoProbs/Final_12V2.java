package org.usacoProbs;

import java.util.*;

public class Final_12V2 {
    public static boolean[] visited;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int friends  = s.nextInt();
        int met = s.nextInt();
        int queries = s.nextInt();
        ArrayList<Set<Integer>> islands = new ArrayList<>();

        boolean[][] adj = new boolean[friends][friends];

        for(int i = 0; i < met; i++){
            int a = s.nextInt()-1;
            int b = s.nextInt()-1;

            adj[a][b] = true;
            adj[b][a] = true;
        }

        visited = new boolean[friends];

        for(int i = 0; i < friends; i++){
            if(!visited[i]){
                Set<Integer> e = new HashSet<>();
                fillIsland(adj, i, e);
                islands.add(e);
            }
        }

        System.out.println(islands.size());
    }

    public static void fillIsland(boolean[][] adj, int start, Set<Integer> toFill){
        int i = 0;
        for(boolean next : adj[start]){
            if(!visited[i] && next){
                visited[i] = true;
                toFill.add(i);
                fillIsland(adj, i, toFill);
            }
            i++;
        }
    }
}
