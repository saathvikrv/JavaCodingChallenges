package org.usacoProbs;

import java.util.Scanner;

public class RabbitTunnels {
    public static int count;
    public static boolean[] visited;

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int nodes = s.nextInt();
        int queries = s.nextInt();
        int[][] adj = new int[nodes][nodes];
        for(int i = 0; i < nodes -1; i++){
            int a = s.nextInt()-1;
            int b = s.nextInt()-1;
            int weight = s.nextInt();
            adj[a][b] = weight;
            adj[b][a] = weight;
        }

        int[] query = new int[2];

        for(int i = 0; i < queries; i++){
            query[0] = s.nextInt();
            query[1] = s.nextInt();
            visited = new boolean[nodes];
            count = 0;
            DFS(adj, query[1]-1, query[0]);
            System.out.println(count);
        }

    }

    public static void DFS(int[][] adjacency, int startNode, int K){
        visited[startNode] = true;
        int j = 0;
        for(int i : adjacency[startNode]){
            if(!visited[j] && i >= K){
                DFS(adjacency, j, K);
                count++;
            }
            j++;
        }
    }


}

/*

10 10
4 5 690
8 4 1616
9 5 736
1 5 429
6 1 1291
3 4 1619
2 9 805
7 2 749
10 2 1178
736 2
736 8
1 6
1 7
1 7
1 1
1616 6
736 8
1616 7
1616 8

 */
