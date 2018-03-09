package PAT;

public class Dijkstra_Table {
    private class Node {
        int seq;
        int weight;
        Node next;

        public Node(int seq, int weight) {
            this.seq = seq;
            this.weight = weight;
        }
    }

    int size;
    Node[] mTable;

    public Dijkstra_Table(int size) {
        this.size = size;
        mTable = new Node[size];
        for (int i = 0; i < size; i++) {
            mTable[i] = new Node(i, 0);
        }
    }

    public void insertEdge(int from, int to, int weight) {
        Node oldNext = mTable[from - 1].next;
        mTable[from - 1].next = new Node(to - 1, weight);
        mTable[from - 1].next.next = oldNext;
    }


    public void dijkstra(int source) {
        boolean[] collected = new boolean[size];
        int[] dist = new int[size];
        int[] path = new int[size];
        //初始化
        for (int i = 0; i < size; i++) {
            dist[i] = 100;
            path[i] = -1;
        }
        Node node = mTable[source].next;
        while (node != null) {
            dist[node.seq] = node.weight;
            path[node.seq] = source;
            node = node.next;
        }
        //收入起点
        dist[source] = 0;
        collected[source] = true;
        while (true) {
            int min = findMinDist(dist, collected);
            if (min == -1) break;
            collected[min] = true;
            Node adjcent = mTable[min].next;
            while (adjcent != null) {
                int i = adjcent.seq;
                if (!collected[i]) {
                    if (dist[i] > dist[min] + adjcent.weight) {
                        dist[i] = dist[min] + adjcent.weight;
                        path[i] = min;
                    }
                }
                adjcent = adjcent.next;
            }
        }
        for (int i = 0; i < size; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print((path[i] + 1) + " ");
        }
    }

    private int findMinDist(int[] dist, boolean[] collected) {
        int minDist = Integer.MAX_VALUE;
        int minV = -1;
        for (int i = 0; i < size; i++) {
            if (!collected[i] && dist[i] < minDist) {
                minDist = dist[i];
                minV = i;
            }
        }
        return minV;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            StringBuilder builder = new StringBuilder();
            builder.append((i + 1) + "->");
            Node node = mTable[i].next;
            while (node != null) {
                builder.append(node.seq + 1 + " ");
                node = node.next;
            }
            System.out.println(builder);
        }
    }
}
