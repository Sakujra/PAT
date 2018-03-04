package PAT;

import java.util.LinkedList;
import java.util.Queue;

public class SP_SingleWeighted {
    public static void main(String[] args) {
        SP_SingleWeighted g = new SP_SingleWeighted(7);
        g.insertEdge('A', 'B', 12);
        g.insertEdge('A', 'F', 16);
        g.insertEdge('A', 'G', 14);
        g.insertEdge('B', 'C', 10);
        g.insertEdge('B', 'F', 7);
        g.insertEdge('C', 'D', 3);
        g.insertEdge('C', 'E', 5);
        g.insertEdge('C', 'F', 6);
        g.insertEdge('D', 'E', 4);
        g.insertEdge('E', 'F', 2);
        g.insertEdge('E', 'G', 8);
        g.insertEdge('F', 'G', 9);
        g.dijsktra('D');
    }

    private class Node {
        int data;
        int weight;
        Node next;

        public Node(int data, int weight) {
            this.data = data;
            this.weight = weight;
        }
    }

    Node[] mTable;

    public SP_SingleWeighted(int count) {
        mTable = new Node[count];
        for (int i = 0; i < count; i++) {
            mTable[i] = new Node(i, 0);
        }
    }

    public void insertEdge(char c1, char c2, int weight) {
        int start = c1 - 'A';
        int end = c2 - 'A';
        Node tail1 = mTable[start];
        while (tail1.next != null) {
            tail1 = tail1.next;
        }
        tail1.next = new Node(end, weight);

        Node tail2 = mTable[end];
        while (tail2.next != null) {
            tail2 = tail2.next;
        }
        tail2.next = new Node(start, weight);
    }

    public void dijsktra(char sourceChar) {
        int source = sourceChar - 'A';
        int count = mTable.length;
        int[] S = new int[count];
        int[] U = new int[count];
        for (int i = 0; i < count; i++) {
            U[i] = Integer.MAX_VALUE;
        }
        //-1表示从U中移除
        U[source] = -1;
        Node node = mTable[source].next;
        while (node != null) {
            U[node.data] = node.weight;
            node = node.next;
        }
        while (canContinue(U)) {
            int minValue = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int i = 0; i < count; i++) {
                if (U[i] < minValue && U[i] != -1) {
                    minValue = U[i];
                    minIndex = i;
                }
            }
            S[minIndex] = minValue;
            U[minIndex] = -1;
            Node adjcent = mTable[minIndex].next;
            while (adjcent != null) {
                int oldWeight = U[adjcent.data];
                if (oldWeight != -1) {
                    int newWeight = minValue + adjcent.weight;
                    if (newWeight < oldWeight) {
                        U[adjcent.data] = newWeight;
                    }
                }
                adjcent = adjcent.next;
            }
        }

        System.out.println("S：");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append((char) ('A' + i));
            builder.append(S[i]);
            if (i != count - 1) builder.append(',');
        }
        System.out.println(builder);
    }

    public static boolean canContinue(int[] U) {
        for (int i = 0; i < U.length; i++) {
            if (U[i] != -1) return true;
        }
        return false;
    }


}
