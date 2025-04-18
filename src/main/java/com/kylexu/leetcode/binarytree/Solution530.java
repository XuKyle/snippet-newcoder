package com.kylexu.leetcode.binarytree;

import com.kylexu.bean.TreeNode;
import com.kylexu.bean.TreeNodeTools;

import java.util.ArrayList;
import java.util.List;

public class Solution530 {
    public static void main(String[] args) {
        var nums = new Integer[]{4, 2, 6, 1, 3};
        TreeNode treeNode = TreeNodeTools.buildTree(nums);
        int difference = new Solution530().getMinimumDifference(treeNode);
        System.out.println("difference = " + difference);
    }

    public int getMinimumDifference(TreeNode root) {
        List<Integer> rs = new ArrayList<>();
        helper(root, rs);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < rs.size() - 1; i++) {
            min = Math.min(min, Math.abs(rs.get(i) - rs.get(i + 1)));
        }
        return min;
    }

    private void helper(TreeNode root, List<Integer> rs) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            helper(root.left, rs);
        }
        rs.add(root.val);
        if (root.right != null) {
            helper(root.right, rs);
        }
    }
}
