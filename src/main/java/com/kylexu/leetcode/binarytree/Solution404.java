package com.kylexu.leetcode.binarytree;

import com.kylexu.bean.TreeNode;
import com.kylexu.bean.TreeNodeTools;

import java.util.Arrays;

/**
 * 输入: root = [3,9,20,null,null,15,7]
 * 输出: 24
 * 解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * 示例 2:
 * <p>
 * 输入: root = [1]
 * 输出: 0
 */
public class Solution404 {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5};
        TreeNode treeNode = TreeNodeTools.buildTree(Arrays.stream(arr).toList());
        System.out.println(new Solution404().sumOfLeftLeaves(treeNode));
    }

    int rs = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        sumOfLeftLeaves(root, false);
        return rs;
    }

    private void sumOfLeftLeaves(TreeNode node, boolean isLeft) {
        if (node == null) {
            return;
        }

        var left = node.left;
        var right = node.right;

        if (left == null && right == null && isLeft) {
            rs += node.val;
        }

        sumOfLeftLeaves(left, true);
        sumOfLeftLeaves(right, false);
    }
}
