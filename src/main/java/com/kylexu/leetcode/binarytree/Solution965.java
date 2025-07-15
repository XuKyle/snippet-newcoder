package com.kylexu.leetcode.binarytree;

import com.kylexu.bean.TreeNode;
import com.kylexu.bean.TreeNodeTools;

import java.util.Arrays;

public class Solution965 {
    public static void main(String[] args) {
        TreeNode root = TreeNodeTools.buildTree(Arrays.asList(2, 2, 2, 5, 2));
        boolean univalTree = new Solution965().isUnivalTree(root);
        System.out.println("univalTree = " + univalTree);
    }

    public boolean isUnivalTree(TreeNode root) {
        return dfs(root, root.val);
    }

    private boolean dfs(TreeNode root, int val) {
        if (root == null) {
            return true;
        }

        if (root.val != val) {
            return false;
        }

        return dfs(root.left, val) && dfs(root.right, val);
    }
}
