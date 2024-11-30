package com.kylexu.leetcode.tree;

import com.kylexu.bean.TreeNode;

public class Solution111 {
    public static void main(String[] args) {
//        输入：root = [3,9,20,null,null,15,7]
//        输出：2
//        示例 2：
//
//        输入：root = [2,null,3,null,4,null,5,null,6]
//        输出：5


        TreeNode treeNode = new TreeNode(2,
                null,
                new TreeNode(3,
                        null,
                        new TreeNode(4,
                                null,
                                new TreeNode(5,
                                        null,
                                        new TreeNode(6)
                                )
                        )
                )
        );

        System.out.println(new Solution111().minDepth(treeNode));
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        if (root.left == null) {
            return minDepth(root.right) + 1;
        }

        if (root.right == null) {
            return minDepth(root.left) + 1;
        }

        return Math.min(minDepth(root.left) + 1, minDepth(root.right) + 1);

    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

//    给定一个二叉树，找出其最小深度。
//    最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//    说明：叶子节点是指没有子节点的节点。
}
