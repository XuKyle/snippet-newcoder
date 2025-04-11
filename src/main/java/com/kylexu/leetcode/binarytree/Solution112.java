package com.kylexu.leetcode.binarytree;

import com.kylexu.bean.TreeNode;
import com.kylexu.bean.TreeNodeTools;

import java.util.LinkedList;

/**
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 * 解释：等于目标和的根节点到叶节点路径如上图所示。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：false
 * 解释：树中存在两条根节点到叶子节点的路径：
 * (1 --> 2): 和为 3
 * (1 --> 3): 和为 4
 * 不存在 sum = 5 的根节点到叶子节点的路径。
 * 示例 3：
 * <p>
 * 输入：root = [], targetSum = 0
 * 输出：false
 * 解释：由于树是空的，所以不存在根节点到叶子节点的路径。
 */
public class Solution112 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeTools.buildTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1});
        int targetSum = 22;
        boolean rs = new Solution112().hasPathSum(treeNode, targetSum);
        System.out.println("rs = " + rs);

        boolean rs1 = new Solution112().hasPathSumV1(treeNode, targetSum);
        System.out.println("rs = " + rs1);
    }

    public boolean hasPathSumV1(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        return hasPathSumV1(root.left, targetSum - root.val) || hasPathSumV1(root.right, targetSum - root.val);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        LinkedList<TreeNode> helper = new LinkedList<>();
        LinkedList<Integer> memo = new LinkedList<>();
        helper.add(root);
        memo.add(0);

        while (!helper.isEmpty()) {
            int n = helper.size();
            while (n > 0) {
                TreeNode treeNode = helper.removeFirst();
                Integer upSum = memo.removeFirst();

                if (treeNode.left == null && treeNode.right == null) {
                    if (upSum + treeNode.val == targetSum) {
                        return true;
                    }
                }

                if (treeNode.left != null) {
                    helper.add(treeNode.left);
                    memo.add(upSum + treeNode.val);
                }

                if (treeNode.right != null) {
                    helper.add(treeNode.right);
                    memo.add(upSum + treeNode.val);
                }
                n--;
            }
        }

        return false;
    }
}
