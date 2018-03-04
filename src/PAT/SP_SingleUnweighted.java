package PAT;

import java.util.LinkedList;
import java.util.Queue;

public class SP_SingleUnweighted {
    public static void main(String[] args) {
        SP_SingleUnweighted graph = new SP_SingleUnweighted(7);
        graph.insertEdge(1, 2);
        graph.insertEdge(1, 4);
        graph.insertEdge(2, 4);
        graph.insertEdge(2, 5);
        graph.insertEdge(3, 1);
        graph.insertEdge(3, 6);
        graph.insertEdge(4, 3);
        graph.insertEdge(4, 5);
        graph.insertEdge(4, 6);
        graph.insertEdge(4, 7);
        graph.insertEdge(5, 7);
        graph.insertEdge(7, 6);
        graph.singleShortestPath(3);
    }

    private class Node {
        int current;
        Node next;

        public Node(int i) {
            current = i;
        }
    }

    Node[] mTable;

    public SP_SingleUnweighted(int count) {
        mTable = new Node[count + 1];
        for (int i = 1; i < count + 1; i++) {
            mTable[i] = new Node(i);
        }
    }

    public void insertEdge(int start, int end) {
        Node node = mTable[start];
        Node tail = node;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = new Node(end);
    }

    public void singleShortestPath(int source) {
        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[mTable.length];
        for (int i = 1; i < mTable.length; i++)
            dist[i] = -1;
        int[] path = new int[mTable.length];
        queue.add(source);
        dist[source] = 0;
        while (!queue.isEmpty()) {
            int top = queue.poll();
            Node node = mTable[top];
            while (node.next != null) {
                int nextNodeIndex = node.next.current;
                if (dist[nextNodeIndex] == -1) {
                    queue.add(node.next.current);
                    dist[nextNodeIndex] = dist[top] + 1;
                    path[nextNodeIndex] = top;
                }
                node = node.next;
            }
        }
        for (int i = 1; i < mTable.length; i++) {
            System.out.println(i+" dist：" + dist[i]);
        }
    }

}
