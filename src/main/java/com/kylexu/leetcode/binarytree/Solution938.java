package com.kylexu.leetcode.binarytree;

import com.kylexu.bean.TreeNode;
import com.kylexu.bean.TreeNodeTools;

import java.util.Arrays;

public class Solution938 {
    public static void main(String[] args) {
//        输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
        TreeNode treeNode = TreeNodeTools.buildTree(Arrays.asList(10, 5, 15, 3, 7, null, 18));
        int low = 7, high = 15;
        int i = new Solution938().rangeSumBST(treeNode, low, high);
        System.out.println("i = " + i);
    }

    private int low;
    private int high;
    private int rs;

    public int rangeSumBST(TreeNode root, int low, int high) {
        this.low = low;
        this.high = high;
        dfs(root);
        return rs;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.val >= low && root.val <= high) {
            rs += root.val;
        }
        dfs(root.left);
        dfs(root.right);
    }
}
