package com.kylexu.leetcode.tree;

import com.kylexu.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution104 {
    public static void main(String[] args) {

//        给定一个二叉树 root ，返回其最大深度。
//
//        二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。

//        输入：root = [3,9,20,null,null,15,7]
//        输出：3
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15), new TreeNode(7)));

        System.out.println(new Solution104().maxDepth(treeNode));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
