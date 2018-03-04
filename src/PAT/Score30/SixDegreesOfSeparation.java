package PAT.Score30;

import org.omg.CORBA.NO_IMPLEMENT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SixDegreesOfSeparation {

    private static class GNode {
        int index;
        GNode next;

        public GNode(int i) {
            index = i;
        }
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] strings = reader.readLine().split(" ");
            int N = Integer.parseInt(strings[0]);
            int M = Integer.parseInt(strings[1]);
            GNode[] nodes = new GNode[N + 1];
            for (int i = 1; i < N + 1; i++) {
                nodes[i] = new GNode(i);
            }
            for (int i = 0; i < M; i++) {
                strings = reader.readLine().split(" ");
                int first = Integer.parseInt(strings[0]);
                int second = Integer.parseInt(strings[1]);
                GNode lastNode = nodes[first];
                while (lastNode.next != null)
                    lastNode = lastNode.next;
                lastNode.next = new GNode(second);

                lastNode = nodes[second];
                while (lastNode.next != null)
                    lastNode = lastNode.next;
                lastNode.next = new GNode(first);
            }

            for (int i = 1; i < N+1; i++) {
                int n = BFS(nodes, i);
                System.out.println(n);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int BFS(GNode[] nodes, int i) {
        int count = 1;
        int[] level = new int[nodes.length];
        boolean[] visited = new boolean[nodes.length];
        Queue<Integer> queue = new LinkedList<>();
        visited[i] = true;
        queue.add(i);
        while (!queue.isEmpty()) {
            int n = queue.poll();
            GNode node = nodes[n];
            GNode next = node.next;
            while (next != null) {
                if (!visited[next.index] && level[node.index] <= 5) {
                    visited[next.index] = true;
                    queue.add(next.index);
                    count++;
                    level[next.index] = level[node.index] + 1;
                }
                next = next.next;
            }
        }
        return count;
    }
}
