package com.kylexu.leetcode.binarytree;

import com.kylexu.bean.TreeNode;
import com.kylexu.bean.TreeNodeTools;

import java.util.Arrays;
import java.util.List;

public class Solution563 {
    public static void main(String[] args) {
        List<Integer> data = Arrays.asList(4, 2, 9, 3, 5, null, 7);
        TreeNode treeNode = TreeNodeTools.buildTree(data);
        int tilt = new Solution563().findTilt(treeNode);
        System.out.println("tilt = " + tilt);
    }

    int rs = 0;

    public int findTilt(TreeNode root) {
        dfs(root);
        return rs;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = dfs(root.left);
        int r = dfs(root.right);
        rs += Math.abs(l - r);
        return root.val + l + r;
    }
}
