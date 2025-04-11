package com.kylexu.leetcode.binarytree;

import com.kylexu.bean.TreeNode;

/**
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 * <p>
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 * 示例 2:
 * <p>
 * 输入：inorder = [-1], postorder = [-1]
 * 输出：[-1]
 */
public class Solution106 {
    public static void main(String[] args) {
        int[] inorder = {};
        int[] postorder = {};
        TreeNode treeNode = new Solution106().buildTree(inorder, postorder);
        System.out.println("treeNode = " + treeNode);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int lastIndex = postorder.length - 1;
        return createTree(inorder, postorder, 0, lastIndex);
    }

    private TreeNode createTree(int[] inorder, int[] postorder, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return null;
        }
        var root = new TreeNode();
        root.val = postorder[endIndex];
        endIndex--;

        int targetIndex = findTargetIndex(inorder, startIndex, endIndex, root.val);
        root.left = createTree(inorder, postorder, startIndex, targetIndex - 1);
        root.right = createTree(inorder, postorder, targetIndex + 1, endIndex);

        return root;
    }

    private int findTargetIndex(int[] inorder, int startIndex, int endIndex, int value) {
        for (int i = startIndex; i < endIndex; i++) {
            if (inorder[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
