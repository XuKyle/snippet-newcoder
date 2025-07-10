package com.kylexu.leetcode.binarytree;

import com.kylexu.bean.TreeNode;
import com.kylexu.bean.TreeNodeTools;

import java.util.Arrays;

/**
 * 给你一棵 完整二叉树 的根，这棵树有以下特征：
 * <p>
 * 叶子节点 要么值为 0 要么值为 1 ，其中 0 表示 False ，1 表示 True 。
 * 非叶子节点 要么值为 2 要么值为 3 ，其中 2 表示逻辑或 OR ，3 表示逻辑与 AND 。
 * 计算 一个节点的值方式如下：
 * <p>
 * 如果节点是个叶子节点，那么节点的 值 为它本身，即 True 或者 False 。
 * 否则，计算 两个孩子的节点值，然后将该节点的运算符对两个孩子值进行 运算 。
 * 返回根节点 root 的布尔运算值。
 * <p>
 * 完整二叉树 是每个节点有 0 个或者 2 个孩子的二叉树。
 * <p>
 * 叶子节点 是没有孩子的节点。
 */
public class Solution2331 {
    public static void main(String[] args) {
//        root = [2,1,3,null,null,0,1]
        TreeNode treeNode = TreeNodeTools.buildTree(Arrays.asList(2, 1, 3, null, null, 0, 1));
        boolean b = new Solution2331().evaluateTree(treeNode);
        System.out.println("b = " + b);
    }

    public boolean evaluateTree(TreeNode root) {
        return dfs(root);
    }

    private boolean dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val == 1;
        }

        boolean leftValue = dfs(root.left);
        boolean rightValue = dfs(root.right);

        if (root.val == 2) {
            return leftValue || rightValue;
        } else {
            return leftValue && rightValue;
        }
    }
}
