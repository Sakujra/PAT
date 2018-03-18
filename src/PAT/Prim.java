package PAT;

import java.util.Vector;

public class Prim {

    int nodeCount;
    int[][] matrix;

    public Prim(int nodeCount) {
        this.nodeCount = nodeCount;
        matrix = new int[nodeCount][nodeCount];
    }

    public void primMST(int start) {
        boolean[] collected = new boolean[nodeCount];
        collected[start - 1] = true;
        int[] dist = new int[nodeCount];
        int[] parent = new int[nodeCount];

        for (int i = 0; i < nodeCount; i++) {
            if (matrix[start - 1][i] > 0) {
                dist[i] = matrix[start - 1][i];
                parent[i] = start - 1;
            } else
                dist[i] = 9999;
        }
        dist[start - 1] = 0;
        parent[start - 1] = -1;

        while (true) {
            int V = -1;
            int currentMinDist = 9999;
            for (int i = 0; i < nodeCount; i++) {
                if (!collected[i]) {
                    if (currentMinDist > dist[i]) {
                        currentMinDist = dist[i];
                        V = i;
                    }
                }
            }
            if (V == -1) break;
            collected[V] = true;

            for (int i = 0; i < nodeCount; i++) {
                if (!collected[i]) {
                    if (dist[i] > matrix[V][i] && matrix[V][i] > 0) {
                        dist[i] = matrix[V][i];
                        parent[i] = V;
                    }
                }
            }
        }

        int sumOfWeight = 0;
        for (int i = 0; i < nodeCount; i++) {
            sumOfWeight += dist[i];
        }
        System.out.println("sum of weight: " + sumOfWeight);
        for (int i = 1; i < nodeCount; i++) {
            System.out.println((parent[i]+1) + "->" + (i+1));
        }
    }

    public void insertEdge(int from, int to, int weight) {
        from--;
        to--;
        matrix[from][to] = weight;
        matrix[to][from] = weight;
    }

    public void print() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < nodeCount; i++) {
            for (int j = 0; j < nodeCount; j++) {
                builder.append(matrix[i][j] + " ");
            }
            builder.append("\n");
        }
        System.out.println(builder);
    }
}
