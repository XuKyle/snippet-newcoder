package com.kylexu.leetcode.binarytree;

import com.kylexu.bean.TreeNode;
import com.kylexu.bean.TreeNodeTools;

public class Solution236 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeTools.buildTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});

        TreeNode p = treeNode.left;
        TreeNode q = treeNode.right;

        TreeNode rs = new Solution236().lowestCommonAncestor(treeNode, p, q);
        System.out.println("rs = " + rs);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return new TreeNode();
    }
}
