package com.kylexu.leetcode.binarytree;

import com.kylexu.bean.TreeNode;
import com.kylexu.bean.TreeNodeTools;

/**
 * 输入：root = [1,2,3,4,5,6]
 * 6
 */
public class Solution222 {
    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 5, 6};
        TreeNode treeNode = TreeNodeTools.buildTree(nums);
        System.out.println(new Solution222().countNodes(treeNode));
    }

    int sum = 0;

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);

        if (root.left != null) {
            sum += 1;
        }
        if (root.right != null) {
            sum += 1;
        }

        return sum + 1;
    }
}
