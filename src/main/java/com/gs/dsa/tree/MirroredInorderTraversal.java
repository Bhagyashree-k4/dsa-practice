package com.gs.dsa.tree;

/**
 * Perform a modified in-order traversal — visit the right subtree first,
 * then the root, then the left subtree.
 * This reverses the normal in-order order, effectively printing the mirrored
 * view without altering the tree structure.
 */
public class MirroredInorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.print("Mirrored In-order Traversal: ");
        mirroredInorder(root);
    }

    public static void mirroredInorder(TreeNode root) {
        if (root == null) return;
        // Reverse the normal in-order: Right → Root → Left
        mirroredInorder(root.right);
        System.out.print(root.val + " ");
        mirroredInorder(root.left);
    }
}


