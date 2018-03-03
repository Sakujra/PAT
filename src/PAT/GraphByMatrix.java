package PAT;

import java.util.LinkedList;
import java.util.Queue;

public class GraphByMatrix {

    int[] nodes;

    boolean[] visited;

    int nodeCount;

    public GraphByMatrix(int n) {
        int size = n * (n + 1) / 2;
        nodeCount = n;
        nodes = new int[size];
        visited = new boolean[n];
    }

    public void insertEdge(int node1, int node2) {
        int index = node2 * (node2 + 1) / 2 + node1;
        nodes[index] = 1;
    }

    public void DFS(int i) {
        visited[i] = true;
        System.out.print(i + " ");
        for (int j = 0; j < i; j++) {
            int index = i * (i + 1) / 2 + j;
            if (nodes[index] == 1 && !visited[j]) {
                DFS(j);
            }
        }
        for (int j = nodeCount - 1; j > i; j--) {
            int index = j * (j + 1) / 2 + i;
            if (nodes[index] == 1 && !visited[j]) {
                DFS(j);
            }
        }
    }

    public void BFS(int i) {
        visited[i] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            for (int j = 0; j < node; j++) {
                int index = node * (node + 1) / 2 + j;
                if (nodes[index] == 1 && !visited[j]) {
                    visited[j] = true;
                    queue.add(j);
                }
            }
            for (int j = nodeCount - 1; j > node; j--) {
                int index = j * (j + 1) / 2 + node;
                if (nodes[index] == 1 && !visited[j]) {
                    visited[j] = true;
                    queue.add(j);
                }
            }
        }
    }

    public void print() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < i + 1; j++) {
                int index = i * (i + 1) / 2 + j;
                System.out.print(nodes[index]);
            }
            System.out.println();
        }
    }
}
