package com.gs.dsa.tree;

/**
 * Used recursion to traverse the tree.
 * At each node, swap its left and right children,
 * then recursively call the function for both subtrees.
 * This mirrors the binary tree in place (O(n) time, O(h) space).
 */
public class MirrorBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        mirror(root);
    }

    public static void mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirror(root.left);
        mirror(root.right);

    }
}

