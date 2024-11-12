package com.kylexu.leetcode.tree;

import com.kylexu.bean.TreeNode;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * <p>
 * root = [1,2,2,3,4,4,3]
 */
public class Solution101 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3), new TreeNode(4)
                ),
                new TreeNode(2,
                        new TreeNode(4), new TreeNode(3))
        );

        boolean symmetric = new Solution101().isSymmetric(treeNode);
        System.out.println("symmetric = " + symmetric);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        if (root.left == root.right) {
            return true;
        }

        return isSymmetric(root.left,root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }

        if (left.val == right.val) {
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
        return false;
    }
}
