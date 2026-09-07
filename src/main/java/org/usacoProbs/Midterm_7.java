package org.usacoProbs;

import java.io.*;
import java.util.*;

public class Midterm_7 {
    public static void main(String[] args) throws IOException {

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(r.readLine());
        PrintWriter pw = new PrintWriter(System.out);

        int firstCowMoves = Integer.parseInt(st.nextToken());
        int secondCowMoves = Integer.parseInt(st.nextToken());
        int cow1Pos = 0;
        int cow2Pos = 0;
        Queue<Pair> cow1NextMoves = new LinkedList<>();
        Queue<Pair> cow2NextMoves = new LinkedList<>();
        char n;
        int moves;
        int collisions = 0;
        boolean previousCollision = false;

        Pair c1 = new Pair('n', 1);
        Pair c2 = new Pair('n', 1);
        int c1movesLeft = 0;
        int c2movesLeft = 0;

        for(int i = 0; i < firstCowMoves; i++){
            st = new StringTokenizer(r.readLine());
            moves = Integer.parseInt(st.nextToken());
            n = st.nextToken().charAt(0);
            cow1NextMoves.add(new Pair(n, moves));
        }

        for(int i = 0; i < secondCowMoves; i++){
            st = new StringTokenizer(r.readLine());
            moves = Integer.parseInt(st.nextToken());
            n = st.nextToken().charAt(0);
            cow2NextMoves.add(new Pair(n, moves));

        }

        r.close();

        while(!cow1NextMoves.isEmpty() || !cow2NextMoves.isEmpty() || c1movesLeft > 0 || c2movesLeft > 0){
            if(!cow1NextMoves.isEmpty() || c1movesLeft > 0){
                if(c1movesLeft == 0) {
                    c1 = cow1NextMoves.poll();
                    c1movesLeft = c1.second;
                }
                if (c1.first == 'R') {
                    cow1Pos++;
                } else {
                    cow1Pos--;
                }
                c1movesLeft--;
            }
            if(!cow2NextMoves.isEmpty() || c2movesLeft > 0){
                if(c2movesLeft == 0) {
                    c2 = cow2NextMoves.poll();
                    c2movesLeft = c2.second;
                }
                if (c2.first == 'R') {
                    cow2Pos++;
                } else {
                    cow2Pos--;
                }
                c2movesLeft--;
            }

            if(cow1Pos == cow2Pos){
                if(!previousCollision) {
                    collisions++;
                }
                previousCollision = true;
            } else {
                previousCollision = false;
            }
        }
        pw.println(collisions);
        pw.close();
    }

    public static class Pair{
        public char first;
        public int second;

        public Pair(char a, int b){
            first = a;
            second = b;
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof Pair && first == ((Pair) obj).first && second == ((Pair) obj).second;
        }

        public int hashCode() {
            return Objects.hash(first, second);
        }
    }
}
