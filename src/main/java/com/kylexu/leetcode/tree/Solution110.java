package com.kylexu.leetcode.tree;

import com.kylexu.bean.TreeNode;

/**
 * 平衡二叉树 是指该树所有节点的左右子树的深度相差不超过 1。
 */
public class Solution110 {
    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = depth(root.left);
        int right = depth(root.right);

        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15), new TreeNode(7)));

        System.out.println(new Solution110().isBalanced(treeNode));
    }
}
