package org.usacoProbs;

import java.util.*;

public class SkiSlope {
    public static Node root;

    public static class Node {
        ArrayList<Node> children;
        int runEnjoyment;
        int runSkill;

        public Node(){
            children = new ArrayList<>();
        }

        public Node(int skill, int enjoyment){
            children = new ArrayList<>();
            this.runEnjoyment = enjoyment;
            this.runSkill = skill;
        }

        public void addChild(Node child){
            children.add(child);
        }
    }

    public static int maxEnjoyment(int skill, int courage){
        HashMap<Node, Integer> steps = new HashMap<>();
        Queue<Node> toVisit = new LinkedList<>();
        toVisit.add(root);
        steps.put(root, 0);

        ArrayList<Node> moves;
        Node x;
        int enjoymentMax = 0;

        while(!toVisit.isEmpty()) {
            x = toVisit.poll();

            if(steps.get(x) > enjoymentMax){
                enjoymentMax = steps.get(x);
            }

            moves = x.children;

            for(Node nextMove : moves) {
                if(!steps.containsKey(nextMove) || steps.get(nextMove) < steps.get(x) + nextMove.runEnjoyment){
                    steps.put(nextMove, steps.get(x) + nextMove.runEnjoyment);
                    toVisit.add(nextMove);
                }
            }
        }
        return enjoymentMax;
    }

    public static void createSkiTree(Scanner s){
        root = new Node();
        int nodes = s.nextInt();
        Node[] nodeList = new Node[nodes];
        nodeList[0] = root;
        for(int i = 1; i < nodes; i++){
            int childOf = s.nextInt();
            nodeList[i] = new Node(s.nextInt(), s.nextInt());
            nodeList[childOf].addChild(nodeList[i]);
        }
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        createSkiTree(s);
        int friends = s.nextInt();
        for(int friend = 0; friend < friends; friend++){
            System.out.println(maxEnjoyment(s.nextInt(), s.nextInt()));
        }
    }
}
