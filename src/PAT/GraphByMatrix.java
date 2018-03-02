package PAT;

public class GraphByMatrix {

    int[] nodes;

    public GraphByMatrix(int n) {
        int size = n * (n + 1) / 2;
        nodes = new int[size];
    }

    public void insertEdge(int node1, int node2) {
        int index = node2 * (node2 + 1) / 2 + node1;
        nodes[index] = 1;
    }

    public void DFS() {

    }

    public void BFS() {

    }

    public void printGraph() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < i + 1; j++) {
                int index = i * (i + 1) / 2 + j;
                System.out.print(nodes[index]);
            }
            System.out.println();
        }
    }
}
