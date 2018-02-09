package PAT.Score25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class $1086 {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int N = Integer.parseInt(reader.readLine());
            Node[] nodes = new Node[N];
            int rootIndex = Integer.parseInt(reader.readLine().split(" ")[1]) - 1;
            nodes[rootIndex] = new Node();
            Stack<Integer> stack = new Stack<>();
            stack.push(rootIndex);
            boolean isLastPush = true;
            int lastNumber = rootIndex;
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lines = line.split(" ");
                if (lines.length == 2) {
                    //push
                    int index = Integer.parseInt(lines[1]) - 1;
                    stack.push(index);
                    nodes[index] = new Node();
                    if (isLastPush) {
                        nodes[lastNumber].left = index;
                    } else {
                        nodes[lastNumber].right = index;
                    }
                    lastNumber = index;
                    isLastPush = true;
                } else if (lines[0].equals("Pop")) {
                    //pop
                    isLastPush = false;
                    lastNumber = stack.pop();
                } else {
                    break;
                }
            }
            postOrderTraversal(nodes, rootIndex, rootIndex);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void postOrderTraversal(Node[] nodes, int rootIndex, int realRoot) {
        if (rootIndex != -1) {
            postOrderTraversal(nodes, nodes[rootIndex].left, realRoot);
            postOrderTraversal(nodes, nodes[rootIndex].right, realRoot);
            System.out.print(rootIndex + 1);
            if(rootIndex != realRoot) System.out.print(" ");
        }
    }

    static class Node {
        int left = -1;
        int right = -1;
    }
}
