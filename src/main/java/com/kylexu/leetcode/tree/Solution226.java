package com.kylexu.leetcode.tree;

import com.kylexu.bean.TreeNode;

/**
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 */
public class Solution226 {
    public static void main(String[] args) {
//        输入：root = [2,1,3]
//        输出：[2,3,1]

        TreeNode treeNode = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode invertTree = new Solution226().invertTree(treeNode);
//        System.out.println("invertTree = " + invertTree.depth());
        System.out.println("invertTree = " + invertTree);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        invertTree(root.left);
        invertTree(root.right);

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
    }
}
