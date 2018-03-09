package PAT.Score30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class SavingJamesBond_HardVersion {

    private static class Node {
        int x;
        int y;
        int pre = -1;
        boolean toBank = false;
        boolean visited = false;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] strings = reader.readLine().split(" ");
            int N = Integer.parseInt(strings[0]);
            int D = Integer.parseInt(strings[1]);
            Node[] table = new Node[N];
            for (int i = 0; i < N; i++) {
                strings = reader.readLine().split(" ");
                int x = Integer.parseInt(strings[0]);
                int y = Integer.parseInt(strings[1]);
                table[i] = new Node(x, y);
            }
            for (int i = 0; i < N; i++) {
                if (50 - abs(table[i].x) <= D) table[i].toBank = true;
                if (50 - abs(table[i].y) <= D) table[i].toBank = true;
            }
            Queue<Integer> queue = new LinkedList<>();
            //first jump
            Vector<Integer> firstJump = new Vector<>();
            for (int i = 0; i < N; i++) {
                int x = table[i].x;
                int y = table[i].y;
                if (x * x + y * y <= (15 + D) * (15 + D)) {
                    table[i].visited = true;
                    firstJump.add(i);
                }
            }
            Collections.sort(firstJump);
            for (int i = 0; i < firstJump.size(); i++)
                queue.add(firstJump.get(i));
            int outIndex = -1;
            while (!queue.isEmpty()) {
                int head = queue.poll();
                Node node = table[head];
                if (node.toBank) {
                    outIndex = head;
                    break;
                }
                for (int i = 0; i < N; i++) {
                    if (table[i].visited) continue;
                    if (pow(node.x - table[i].x) + pow(node.y - table[i].y) <= D*D) {
                        table[i].visited = true;
                        table[i].pre = head;
                        queue.add(i);
                    }
                }
            }

            if (outIndex == -1) System.out.println("0");
            else {
                int count = 1;
                StringBuilder builder = new StringBuilder();
                int index = outIndex;
                while (index != -1) {
                    builder.append(table[index].x + " " + table[index].y + "\n");
                    count++;
                    index = table[index].pre;
                }
                System.out.println(count);
                System.out.print(builder);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int pow(int n) {
        return n * n;
    }

    public static int abs(int n) {
        if (n < 0) return -n;
        return n;
    }

}
