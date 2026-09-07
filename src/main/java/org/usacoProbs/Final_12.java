package org.usacoProbs;

import java.util.*;

public class Final_12 {
    public static boolean[] visited;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int friends  = s.nextInt();
        int met = s.nextInt();
        int queries = s.nextInt();


        boolean[][] adj = new boolean[friends][friends];

        for(int i = 0; i < met; i++){
            int a = s.nextInt()-1;
            int b = s.nextInt()-1;

            adj[a][b] = true;
            adj[b][a] = true;
        }

        for(int i = 0; i < queries; i++){
            visited = new boolean[friends];
            System.out.println(DFS(adj, s.nextInt()-1, s.nextInt()-1) ? "Y" : "N");
        }
    }

    public static boolean DFS(boolean[][] adj, int start, int target){
        if(start == target){
            return true;
        }

        int i = 0;
        for(boolean next : adj[start]){
            if(!visited[i] && next){
                visited[i] = true;
                if(DFS(adj, i, target)){
                    return true;
                }
            }
            i++;
        }

        return false;
    }

}
