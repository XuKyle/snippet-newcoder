package com.kylexu.leetcode.binarytree;

import com.kylexu.bean.TreeNode;

import java.util.Arrays;

/*
输入：nums = [3,2,1,6,0,5]
输出：[6,3,5,null,2,0,null,null,1]
解释：递归调用如下所示：
- [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
    - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
        - 空数组，无子节点。
        - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
            - 空数组，无子节点。
            - 只有一个元素，所以子节点是一个值为 1 的节点。
    - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
        - 只有一个元素，所以子节点是一个值为 0 的节点。
        - 空数组，无子节点。
示例 2：


输入：nums = [3,2,1]
输出：[3,null,2,null,1]

 */
public class Solution654 {
    public static void main(String[] args) {
        /**
         * 创建一个根节点，其值为 nums 中的最大值。
         * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
         * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
         * 返回 nums 构建的 最大二叉树 。
         */

        int[] nums = new int[]{3, 2, 1, 6, 0, 5};
        TreeNode treeNode = new Solution654().constructMaximumBinaryTree(nums);
        System.out.println("treeNode = " + treeNode);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int left, int right) {
        System.out.println("nums = " + Arrays.toString(nums) + " ;left = " + left + " ;right=" + right);
        if (right - left < 1) {
            return null;
        }

        if (right - left == 1) {
            return new TreeNode(nums[left]);
        }

        int maxIndex = left;
        int maxValue = nums[left];

        for (int i = left + 1; i < right; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                maxIndex = i;
            }
        }

        TreeNode treeNode = new TreeNode(maxValue);
        treeNode.left = constructMaximumBinaryTree(nums, left, maxIndex);
        treeNode.right = constructMaximumBinaryTree(nums, maxIndex + 1, right);

        return treeNode;
    }

}
