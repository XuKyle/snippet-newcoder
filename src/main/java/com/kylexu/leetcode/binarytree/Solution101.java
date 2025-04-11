package com.kylexu.leetcode.binarytree;

import com.kylexu.bean.TreeNode;

public class Solution101 {
    public static void main(String[] args) {
//        输入：root = [1,2,2,3,4,4,3]
//        输出：true
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3), new TreeNode(4)
                ),
                new TreeNode(2,
                        new TreeNode(4), new TreeNode(3)
                )
        );

        System.out.println(new Solution101().isSymmetric(treeNode));
    }

    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }

        if (left.val == right.val) {
            return check(left.right, right.left) && check(left.left, right.right);
        }

        return false;
    }
}
