package com.kylexu.leetcode.binarytree;

import com.kylexu.bean.TreeNode;
import com.kylexu.bean.TreeNodeTools;

public class Solution700 {
    public static void main(String[] args) {
        Integer[] root = new Integer[]{4, 2, 7, 1, 3};
        TreeNode treeNode = TreeNodeTools.buildTree(root);
        int val = 2;
        TreeNode rs = new Solution700().searchBST(treeNode, val);
        System.out.println("rs = " + rs);
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }

        if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
