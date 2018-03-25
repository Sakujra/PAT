package PAT;

import java.util.LinkedList;
import java.util.Queue;

public class TopoSort {
    private class Node {
        int seq;
        int cost;
        Node next;

        public Node(int seq, int cost, Node next) {
            this.seq = seq;
            this.cost = cost;
            this.next = next;
        }
    }

    private int nodeCount;

    private Node[] mTable;

    public TopoSort(int nodeCount) {
        this.nodeCount = nodeCount;
        mTable = new Node[nodeCount];
        for (int i = 0; i < nodeCount; i++) {
            mTable[i] = new Node(i, 1, null);
        }
    }

    public void insertEdge(int from, int to, int cost) {
        Node oldNext = mTable[from - 1].next;
        mTable[from - 1].next = new Node(to - 1, cost, oldNext);
    }

    public void pirnt() {
        for (int i = 0; i < nodeCount; i++) {
            Node node = mTable[i].next;
            while (node != null) {
                System.out.print(node.seq + " ");
                node = node.next;
            }
            System.out.println();
        }
    }

    public void topoSort() {
        int indegree[] = new int[nodeCount];
        for (int i = 0; i < nodeCount; i++) {
            Node node = mTable[i].next;
            while (node != null) {
                indegree[node.seq]++;
                node = node.next;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nodeCount; i++) {
            if (indegree[i] == 0) queue.add(i);
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int seq = queue.poll();
            System.out.print((seq + 1) + " ");
            count++;
            Node next = mTable[seq].next;
            while (next != null) {
                indegree[next.seq]--;
                if (indegree[next.seq] == 0)
                    queue.add(next.seq);
                next = next.next;
            }
        }
        if (count != nodeCount) System.out.println("\n图中有回路");
    }

    public static void main(String[] args) {
        TopoSort topoSort = new TopoSort(15);
        topoSort.insertEdge(1, 3, 1);
        topoSort.insertEdge(2, 3, 1);
        topoSort.insertEdge(2, 13, 1);
        topoSort.insertEdge(3, 7, 1);
        topoSort.insertEdge(4, 5, 1);
        topoSort.insertEdge(5, 6, 1);
        topoSort.insertEdge(6, 15, 1);
        topoSort.insertEdge(7, 12, 1);
        topoSort.insertEdge(7, 10, 1);
        topoSort.insertEdge(7, 11, 1);
        topoSort.insertEdge(8, 9, 1);
        topoSort.insertEdge(9, 10, 1);
        topoSort.insertEdge(9, 11, 1);
        topoSort.insertEdge(10, 14, 1);
//        topoSort.pirnt();
        topoSort.topoSort();
    }


}
