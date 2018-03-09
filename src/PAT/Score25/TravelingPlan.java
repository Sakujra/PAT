package PAT.Score25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TravelingPlan {

    public static class Node {
        int seq;
        int len;
        int cost;
        Node next;

        public Node(int seq, int len, int cost, Node node) {
            this.seq = seq;
            this.len = len;
            this.cost = cost;
            this.next = node;
        }
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] strings = reader.readLine().split(" ");
            int N = Integer.parseInt(strings[0]);
            int M = Integer.parseInt(strings[1]);
            int S = Integer.parseInt(strings[2]);
            int D = Integer.parseInt(strings[3]);
            Node[] table = new Node[N];
            for (int i = 0; i < N; i++) {
                table[i] = new Node(i, -1, -1, null);
            }
            for (int i = 0; i < M; i++) {
                strings = reader.readLine().split(" ");
                int c1 = Integer.parseInt(strings[0]);
                int c2 = Integer.parseInt(strings[1]);
                int len = Integer.parseInt(strings[2]);
                int cost = Integer.parseInt(strings[3]);
                Node node = table[c1].next;
                table[c1].next = new Node(c2, len, cost, node);
                node = table[c2].next;
                table[c2].next = new Node(c1, len, cost, node);
            }

            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < N; i++) {
                builder.append(i + "->");
                Node node = table[i].next;
                while (node != null) {
                    builder.append(node.seq + " ");
                    node = node.next;
                }
                builder.append("\n");
            }
            System.out.println(builder);

            //dijkstra
            int[] dist = new int[N];
            int[] cost = new int[N];
            boolean[] collected = new boolean[N];
            for (int i = 0; i < N; i++) {
                dist[i] = 500;
                cost[i] = 500;
            }
            Node adjcent = table[S].next;
            while (adjcent != null) {
                int seq = adjcent.seq;
                dist[seq] = adjcent.len;
                cost[seq] = adjcent.cost;
                adjcent = adjcent.next;
            }
            collected[S] = true;
            while (true) {
                int V = -1;
                int currentMinDist = 500;
                for (int i = 0; i < N; i++) {
                    if (!collected[i]) {
                        if (currentMinDist > dist[i]) {
                            currentMinDist = dist[i];
                            V = i;
                        }
                    }
                }
                if (V == -1) break;
                collected[V] = true;
                Node neighbor = table[V].next;
                while (neighbor != null) {
                    int seq = neighbor.seq;
                    if (!collected[seq]) {
                        if (dist[seq] > dist[V] + neighbor.len) {
                            dist[seq] = dist[V] + neighbor.len;
                            cost[seq] = cost[V] + neighbor.cost;
                        } else if (dist[seq] == dist[V] + neighbor.len) {
                            if (cost[seq] > cost[V] + neighbor.cost) {
                                cost[seq] = cost[V] + neighbor.cost;
                            }
                        }
                    }
                    neighbor = neighbor.next;
                }
            }

            System.out.println(dist[D]);
            System.out.println(cost[D]);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
