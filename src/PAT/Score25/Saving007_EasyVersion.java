package PAT.Score25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Saving007_EasyVersion {

    private static class GNode {
        int x;
        int y;
        boolean visited = false;
        boolean toBank = false;
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line = reader.readLine();
            String[] strings = line.split(" ");
            int N = Integer.parseInt(strings[0]);
            int D = Integer.parseInt(strings[1]);
            GNode[] nodes = new GNode[N];
            for (int i = 0; i < N; i++) {
                strings = reader.readLine().split(" ");
                GNode newNode = new GNode();
                newNode.x = Integer.parseInt(strings[0]);
                newNode.x = Integer.parseInt(strings[1]);
                if (50 - abs(newNode.x) <= D) newNode.toBank = true;
                if (50 - abs(newNode.y) <= D) newNode.toBank = true;
                nodes[i] = newNode;
            }

            Queue<GNode> queue = new LinkedList<>();
            //first jump
            for (int i = 0; i < N; i++) {
                int x = nodes[i].x;
                int y = nodes[i].y;
                if (x * x + y * y <= (15 + D) * (15 + D)) {
                    nodes[i].visited = true;
                    queue.add(nodes[i]);
                }
            }
            boolean canJumpOut = false;
            while (!queue.isEmpty()) {
                GNode node = queue.poll();
                if (node.toBank) {
                    canJumpOut = true;
                    break;
                }
                for (int i = 0; i < N && !nodes[i].visited; i++) {
                    if (pow(node.x - nodes[i].x) + pow(node.y - nodes[i].y) <= D) {
                        nodes[i].visited = true;
                        queue.add(nodes[i]);
                    }
                }
            }
            if (canJumpOut) System.out.println("yes");
            else System.out.println("no");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static int pow(int n) {
        return n * n;
    }

    private static int abs(int n) {
        if (n < 0) return -n;
        return n;
    }
}
