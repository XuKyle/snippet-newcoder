package com.kylexu.leetcode.binarytree;

import com.kylexu.bean.TreeNode;

public class Solution226 {
    public static void main(String[] args) {
        //[4,2,7,1,3,6,9]
        TreeNode treeNode = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9))
        );

        System.out.println(new Solution226().invertTree(treeNode));
    }


    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invertTree(root.right);
        TreeNode right = invertTree(root.left);

        root.left = left;
        root.right = right;
        return root;
    }
}
