package com.kylexu.leetcode.tree;

import com.kylexu.bean.TreeNode;

/**
 * 输入：root = [10,4,6]
 * 输出：true
 * 解释：根结点、左子结点和右子结点的值分别是 10 、4 和 6 。
 * 由于 10 等于 4 + 6 ，因此返回 true 。
 */
public class Solution2236 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10, new TreeNode(4), new TreeNode(6));
        System.out.println(new Solution2236().checkTree(treeNode));
    }

    public boolean checkTree(TreeNode root) {
        return root.val == root.left.val + root.right.val;
    }
}
