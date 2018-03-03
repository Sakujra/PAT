package PAT;

import java.util.LinkedList;
import java.util.Queue;

public class GraphByTable {

    private class GNode {

        public GNode(int index) {
            adjcentNode = index;
        }

        int adjcentNode = -1;
        GNode next = null;
    }

    GNode[] nodes;

    boolean[] visited;

    public GraphByTable(int size) {
        nodes = new GNode[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new GNode(i);
        }
        visited = new boolean[size];
    }

    public void insertEdge(int node1, int node2) {
        GNode lastNode = nodes[node1];
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = new GNode(node2);

        lastNode = nodes[node2];
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = new GNode(node1);
    }


    public void DFS(int n) {
        visited[n] = true;
        System.out.print(n + " ");
        GNode node = nodes[n];
        while (node != null) {
            if (!visited[node.adjcentNode]) DFS(node.adjcentNode);
            node = node.next;
        }
    }

    public void BFS(int n) {
        visited[n] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        while (!queue.isEmpty()) {
            int i = queue.poll();
            GNode node = nodes[i];
            System.out.print(i + " ");
            while (node != null) {
                if (!visited[node.adjcentNode]) {
                    queue.add(node.adjcentNode);
                    visited[node.adjcentNode] = true;
                }
                node = node.next;
            }
        }
    }

    public void print() {
        for (int i = 0; i < nodes.length; i++) {
            GNode node = nodes[i];
            while (node != null) {
                System.out.print(node.adjcentNode + " ");
                node = node.next;
            }
            System.out.println();
        }
    }
}
