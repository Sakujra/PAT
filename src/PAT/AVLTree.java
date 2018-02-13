package PAT;

public class AVLTree {

    private AVLNode mRoot;

    private class AVLNode {
        int data;
        AVLNode left;
        AVLNode right;
        int height;
    }

    private int height(AVLNode tree) {
        if (tree == null) return 0;
        return tree.height;
    }

    public int height() {
        return height(mRoot);
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    private AVLNode leftLeftRotate(AVLNode tree) {
        AVLNode leftChild = tree.left;
        tree.left = leftChild.right;
        leftChild.right = tree;

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
        if (tree == null) {
            //空树
            tree = new AVLNode();
            tree.data = data;
        } else {
            if (data < tree.data) {
                //插左子树
                tree.left = insert(tree.left, data);
                //左子树失去平衡
                if (height(tree.left) - height(tree.right) == 2) {
                    if (data < tree.left.data)
                        tree = leftLeftRotate(tree);
                    else
                        tree = leftRightRotate(tree);
                }
            } else if (data > tree.data) {
                //插右子树
                tree.right = insert(tree.right, data);
                if (height(tree.right) - height(tree.left) == 2) {
                    if (data > tree.right.data)
                        tree = rightRightRotate(tree);
                    else
                        tree = rightLeftRotate(tree);
                }
            } else {
                //相等
            }
        }
        tree.height = max(height(tree.left), height(tree.right)) + 1;
        return tree;
    }

    public void insert(int data) {
        mRoot = insert(mRoot, data);
    }
}
