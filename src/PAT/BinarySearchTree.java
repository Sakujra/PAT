package PAT;

import javax.transaction.TransactionRequiredException;

public class BinarySearchTree {

    private TreeNode root;

    private class TreeNode {
        private int data;
        private TreeNode left, right;
    }

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int data) {
        root = insert(data, root);
    }

    private TreeNode insert(int data, TreeNode root) {
        if (root == null) {
            TreeNode node = new TreeNode();
            node.data = data;
            return node;
        }
        if (data < root.data) root.left = insert(data, root.left);
        else if (data > root.data) root.right = insert(data, root.right);
        else root.data = data;
        return root;
    }

    public void remove(int data) {
        root = remove(data, root);
    }

    private TreeNode remove(int data, TreeNode root) {
        if (root == null) return null;
        if (data < root.data) root.left = remove(data, root.left);
        else if (data > root.data) root.right = remove(data, root.right);
        else {
            if (root.right == null) return root.left;
            if (root.left == null) return root.right;
            TreeNode node = findMin(root.right);
            root.right = removeMin(root.right);
            root.data = node.data;
        }
        return root;
    }

    private TreeNode removeMin(TreeNode root) {
        if (root.left == null) return null;
        root.left = removeMin(root.left);
        return root;
    }

    public TreeNode findMin() {
        return findMin(root);
    }

    //内部实现
    private TreeNode findMin(TreeNode root) {
//        //递归实现
//        if (root == null) return null;
//        if (root.left == null) return root;
//        else return findMin(root.left);

        //迭代实现
        if (root != null) {
            while (root.left != null) {
                root = root.left;
            }
        }
        return root;
    }

    public TreeNode findMax() {
        return findMax(root);
    }

    //内部实现
    private TreeNode findMax(TreeNode root) {
        if (root == null) return null;
        if (root.right == null) return root;
        else return findMax(root.right);
    }

    public TreeNode find(int data) {
        find(data, root);
        return null;
    }

    //内部实现
    private TreeNode find(int data, TreeNode root) {
        if (root == null) return null;
        if (data > root.data) return find(data, root.right);
        else if (data < root.data) return find(data, root.left);
        else return root;
    }

    public int size() {
        return 0;
    }

    public int height() {
        return 0;
    }

    public String preOrder() {
        return null;
    }

    public String inOrder() {
        return null;
    }

    public String postOrder() {
        return null;
    }

    public String levelOrder() {
        return null;
    }
}
