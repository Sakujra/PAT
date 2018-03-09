package PAT.Score25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class $1003 {

    private static class Node {
        int seq;
        int weight;
        Node next;
        boolean collected = false;

        public Node(int seq, int weight) {
            this.seq = seq;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] strings = reader.readLine().split(" ");
            int N = Integer.parseInt(strings[0]);
            int M = Integer.parseInt(strings[1]);
            int C1 = Integer.parseInt(strings[2]);
            int C2 = Integer.parseInt(strings[3]);
            int[] peopleAmount = new int[N];
            strings = reader.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                peopleAmount[i] = Integer.parseInt(strings[i]);
            }
            Node[] table = new Node[N];
            for (int i = 0; i < N; i++) {
                table[i] = new Node(i, 0);
            }
            for (int i = 0; i < M; i++) {
                strings = reader.readLine().split(" ");
                int from = Integer.parseInt(strings[0]);
                int to = Integer.parseInt(strings[1]);
                int len = Integer.parseInt(strings[2]);
                Node node = table[from].next;
                table[from].next = new Node(to, len);
                table[from].next.next = node;
                node = table[to].next;
                table[to].next = new Node(from, len);
                table[to].next.next = node;
            }

//            StringBuilder builder = new StringBuilder();
//            for (int i = 0; i < N; i++) {
//                Node node = table[i].next;
//                builder.append(i + "->");
//                while (node != null) {
//                    builder.append(node.seq + " ");
//                    node = node.next;
//                }
//                builder.append("\n");
//            }
//            System.out.println(builder);

            int[] dist = new int[N];
            Vector<Integer>[] paths = new Vector[N];
            for (int i = 0; i < N; i++) {
                dist[i] = 9999;
                paths[i] = new Vector<Integer>();
            }
            Node node = table[C1].next;
            while (node != null) {
                dist[node.seq] = node.weight;
                Vector<Integer> v = paths[node.seq];
                v.add(C1);
                node = node.next;
            }
            dist[C1] = 0;
            table[C1].collected = true;
            while (true) {
                Vector<Integer> v = findMinDist(table, dist);
                if (v.isEmpty()) break;
                int currentMinDist = Integer.MAX_VALUE;
                Vector<Integer> currentPaths = new Vector<>();
                for (int i = 0; i < v.size(); i++) {
                    int vertex = v.get(i);
                    Node adjcent = table[vertex].next;
                    while (adjcent != null) {
                        if (!table[adjcent.seq].collected && dist[adjcent.seq] > dist[vertex] + adjcent.weight) {
                            dist[adjcent.seq] = dist[vertex] + adjcent.weight;
                            if (dist[adjcent.seq] < currentMinDist) {
                                currentMinDist = dist[adjcent.seq];
                                currentPaths.clear();
                                currentPaths.add(adjcent.seq);
                            } else if (dist[adjcent.seq] == currentMinDist)
                                currentPaths.add(adjcent.seq);
                        }
                    }
                }
                for (int i = 0; i < currentPaths.size(); i++) {
//                    paths[currentPaths.get(i)].add()
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static Vector<Integer> findMinDist(Node[] table, int[] dist) {
        int minDist = 9999;
        Vector<Integer> v = new Vector<>();
        for (int i = 0; i < table.length; i++) {
            if (!table[i].collected && dist[i] <= minDist) {
                if (dist[i] < minDist) {
                    minDist = dist[i];
                    v.clear();
                    v.add(i);
                } else if (dist[i] == minDist) {
                    v.add(i);
                }
            }
        }
        return v;
    }


}
