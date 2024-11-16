package com.kylexu.leetcode.binarytree;

import com.kylexu.bean.TreeNode;

/**
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 * <p>
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 * <p>
 * 两节点之间路径的 长度 由它们之间边数表示。
 */
public class Solution543 {
    public static void main(String[] args) {
//        输入：root = [1,2,3,4,5]
//        输出：3
//        解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
//        示例 2：
//
//        输入：root = [1,2]
//        输出：1

        TreeNode treeNode = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4), new TreeNode(5)
                ),
                new TreeNode(3)
        );

        System.out.println(new Solution543().diameterOfBinaryTree(treeNode));
    }

    private Integer max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = depth(root.left);
        int right = depth(root.right);

        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }


}
