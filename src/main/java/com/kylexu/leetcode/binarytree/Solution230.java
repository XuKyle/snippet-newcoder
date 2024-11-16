package com.kylexu.leetcode.binarytree;

import com.kylexu.bean.TreeNode;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。
 * <p>
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 */
public class Solution230 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3,
                new TreeNode(1,
                        null,
                        new TreeNode(2)),
                new TreeNode(4)
        );
        System.out.println(new Solution230().kthSmallest(treeNode, 1));
//        System.out.println(new Solution230().leftCount(treeNode));
    }

    public int kthSmallest(TreeNode root, int k) {
        int currentTh = nodeCount(root.left) + 1;
        if (currentTh == k) {
            return root.val;
        } else if (currentTh < k) {
            return kthSmallest(root.right, k - currentTh);
        } else {
            return kthSmallest(root.left, k);
        }
    }

    private int nodeCount(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return nodeCount(root.left) + nodeCount(root.right) + 1;
    }
}
