package PAT.Score25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class $1066 {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int N = Integer.parseInt(reader.readLine());
            String[] strings = reader.readLine().split(" ");
            AVLTree tree = new AVLTree();
            for (int i = 0; i < strings.length; i++) {
                tree.insert(Integer.parseInt(strings[i]));
            }
            System.out.println(tree.getmRoot().data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class AVLTree {
        private class AVLNode {
            int data;
            AVLNode left;
            AVLNode right;
            int height;

            private AVLNode(int data) {
                this.data = data;
            }
        }

        private AVLNode mRoot;

        public AVLNode getmRoot() {
            return mRoot;
        }

        private int height(AVLNode tree) {
            if (tree == null) return 0;
            return tree.height;
        }

        private int max(int a, int b) {
            return a > b ? a : b;
        }

        private AVLNode leftLeftRotate(AVLNode tree) {
            AVLNode leftChild = tree.left;
            tree.left = leftChild.right;
            leftChild.right = tree;
            //不要通过 属性 求高度！！
            tree.height = max(height(tree.left), height(tree.right)) + 1;
            leftChild.height = max(height(leftChild.left), height(leftChild.right)) + 1;
            return leftChild;
        }

        private AVLNode rightRightRotate(AVLNode tree) {
            AVLNode rightChild = tree.right;
            tree.right = rightChild.left;
            rightChild.left = tree;
            tree.height = max(height(tree.left), height(tree.right)) + 1;
            rightChild.height = max(height(rightChild.left), height(rightChild.right)) + 1;
            return rightChild;
        }

        private AVLNode leftRightRotate(AVLNode tree) {
            tree.left = rightRightRotate(tree.left);
            return leftLeftRotate(tree);
        }

        private AVLNode rightLeftRotate(AVLNode tree) {
            tree.right = leftLeftRotate(tree.right);
            return rightRightRotate(tree);
        }

        private AVLNode insert(AVLNode tree, int data) {
            if (tree == null) tree = new AVLNode(data);
            else {
                if (data < tree.data) {
                    tree.left = insert(tree.left, data);
                    if (height(tree.left) - height(tree.right) == 2) {
                        if (data < tree.left.data)
                            tree = leftLeftRotate(tree);
                        else
                            tree = leftRightRotate(tree);
                    }
                } else if (data > tree.data) {
                    tree.right = insert(tree.right, data);
                       if (height(tree.right) - height(tree.left) == 2) {
                        if (data > tree.right.data)
                            tree = rightRightRotate(tree);
                        else
                            tree = rightLeftRotate(tree);
                    }
                } else {
                }
            }
            tree.height = max(height(tree.left), height(tree.right)) + 1;
            return tree;
        }

        public void insert(int data) {
            mRoot = insert(mRoot, data);
        }
    }

}
