package PAT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 用数组保存二叉树
 * 层序遍历（队列：保存孩子；双栈：模拟队列）
 * 测试数据：
 8
 1 -
 - -
 0 -
 2 7
 - -
 - -
 5 -
 4 6
 */
public class ListLeaves {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int N = Integer.parseInt(reader.readLine());
            Node[] treeNodes = new Node[N];
            int[] check = new int[N];
            for (int i = 0; i < N; i++) {
                String[] numbers = reader.readLine().split(" ");
                int left = -1;
                int right = -1;
                if (!numbers[0].equals("-")) {
                    left = Integer.parseInt(numbers[0]);
                }
                if (!numbers[1].equals("-")) {
                    right = Integer.parseInt(numbers[1]);
                }
                Node n = new Node();
                n.left = left;
                n.right = right;
                treeNodes[i] = n;
                if (left != -1) check[left] = 1;
                if (right != -1) check[right] = 1;
            }
            int rootIndex = 0;
            for (int i = 0; i < treeNodes.length; i++) {
                if (check[i] == 0) {
                    rootIndex = i;
                    break;
                }
            }
            levelOrderTraversalByQueue(treeNodes, rootIndex);
            levelOrderTraversalByStack(treeNodes, rootIndex);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void levelOrderTraversalByStack(Node[] treeNodes, int rootIndex) {
        Stack<Integer> stackA = new Stack<>();
        Stack<Integer> stackB = new Stack<>();
        stackA.push(rootIndex);
        StringBuilder builder = new StringBuilder();
        while (!stackA.isEmpty()) {
            while (!stackA.isEmpty()) {
                stackB.push(stackA.pop());
            }
            while (!stackB.isEmpty()) {
                int item = stackB.pop();
//                builder.append(item + " ");
                int left = treeNodes[item].left;
                int right = treeNodes[item].right;
                if (left != -1) stackA.push(left);
                if (right != -1) stackA.push(right);
                if (left == -1 && right == -1) {
                    builder.append(item + " ");
                }
            }
        }
        System.out.println(builder);
    }

    public static void levelOrderTraversalByQueue(Node[] treeNodes, int rootIndex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(rootIndex);
        StringBuilder builder = new StringBuilder();
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int leftChild = treeNodes[cur].left;
            int rightChild = treeNodes[cur].right;
            if (leftChild != -1) queue.add(leftChild);
            if (rightChild != -1) queue.add(rightChild);
            if (leftChild == -1 && rightChild == -1) builder.append(cur + " ");
        }
        System.out.println(builder.subSequence(0, builder.length() - 1));
    }



    private static class Node {
        int left = -1;
        int right = -1;
    }

}
