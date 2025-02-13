package com.kylexu.leetcode.array;

import java.util.Arrays;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 示例 2：
 * <p>
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 */
public class Solution977 {
    public static void main(String[] args) {
        int[] nums = new int[]{-7, -3, 2, 3, 11};
        int[] rs = new Solution977().sortedSquares(nums);
        System.out.println("rs = " + Arrays.toString(rs));
    }

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int index = n - 1;

        int[] rs = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] * nums[i];
        }

        while (left <= right) {
            if (nums[left] > nums[right]) {
                rs[index--] = nums[left++];
            } else {
                rs[index--] = nums[right--];
            }
        }
        return rs;
    }
}
