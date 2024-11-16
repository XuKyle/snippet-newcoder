package com.kylexu.leetcode.binarytree;

import com.kylexu.bean.TreeNode;

public class Solution98 {
    public static void main(String[] args) {
//        输入：root = [2,1,3]
//        输出：true
        TreeNode treeNode = new TreeNode(2,
                new TreeNode(1),
                new TreeNode(3)
        );

        System.out.println(new Solution98().isValidBST(treeNode));

//        输入：root = [5,1,4,null,null,3,6]
//        输出：false
//        解释：根节点的值是 5 ，但是右子节点的值是 4 。

        TreeNode node = new TreeNode(
                5,
                new TreeNode(4),
                new TreeNode(6,
                        new TreeNode(3),
                        new TreeNode(7)
                )
        );

        System.out.println(new Solution98().isValidBST(node));
    }


    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode root, long lower, long higher) {
        if (root == null) {
            return true;
        }

        if (root.val <= lower || root.val >= higher) {
            return false;
        }

        return helper(root.left, lower, root.val) && helper(root.right, root.val, higher);
    }
}
