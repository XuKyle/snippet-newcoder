package com.kylexu.leetcode.binarytree;

import com.kylexu.bean.TreeNode;
import com.kylexu.bean.TreeNodeTools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution783 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeTools.buildTree(Arrays.asList(4, 2, 6, 1, 3));
        int i = new Solution783().minDiffInBST(treeNode);
        System.out.println("i = " + i);
    }

    public int minDiffInBST(TreeNode root) {
        List<Integer> rs = new ArrayList<>();
        int minValue = Integer.MAX_VALUE;
        dfs(root, rs);
        for (int i = 0; i < rs.size() - 1; i++) {
            minValue = Math.min(minValue, Math.abs(rs.get(i) - rs.get(i + 1)));
        }
        return minValue;
    }

    private void dfs(TreeNode treeNode, List<Integer> rs) {
        if (treeNode == null) {
            return;
        }
        dfs(treeNode.left, rs);
        rs.add(treeNode.val);
        dfs(treeNode.right, rs);
    }
}
