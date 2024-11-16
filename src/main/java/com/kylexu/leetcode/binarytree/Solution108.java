package com.kylexu.leetcode.binarytree;

import com.kylexu.bean.TreeNode;

/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵
 * 平衡
 * 二叉搜索树。
 * <p>
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 */
public class Solution108 {
    public static void main(String[] args) {
        int[] nums = new int[]{-10, -3, 0, 5, 9};

        System.out.println(new Solution108().sortedArrayToBST(nums));
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }


    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);

        treeNode.left = helper(nums, left, mid - 1);
        treeNode.right = helper(nums, mid + 1, right);

        return treeNode;
    }

}
