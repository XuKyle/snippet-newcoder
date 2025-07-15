package com.kylexu.leetcode.binarytree;

import com.kylexu.bean.TreeNode;
import com.kylexu.bean.TreeNodeTools;

import java.util.Arrays;

public class Solution671 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeTools.buildTree(Arrays.asList(2, 2, 2));
        int secondMinimumValue = new Solution671().findSecondMinimumValue(treeNode);
        System.out.println("secondMinimumValue = " + secondMinimumValue);
    }

    int firstMinValue = -1;
    int secondMinValue = -1;

    public int findSecondMinimumValue(TreeNode root) {
        dfs(root);
        return secondMinValue;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (firstMinValue == -1) {
            firstMinValue = root.val;
        } else {
            if (root.val == firstMinValue) {
                // nothing
            } else if (root.val < firstMinValue) {
                secondMinValue = firstMinValue;
                firstMinValue = root.val;
            } else {
                if (secondMinValue == -1 || root.val < secondMinValue) {
                    secondMinValue = root.val;
                }
            }
        }

        dfs(root.left);
        dfs(root.right);
    }
}
