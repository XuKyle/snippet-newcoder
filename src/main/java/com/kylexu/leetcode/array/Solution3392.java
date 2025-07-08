package com.kylexu.leetcode.array;

public class Solution3392 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 4, 1};
        int i = new Solution3392().countSubarrays(nums);
        System.out.println("i = " + i);
    }

    /**
     * 给你一个整数数组 nums ，请你返回长度为 3 的 子数组 的数量，满足第一个数和第三个数的和恰好为第二个数的一半。
     * <p>
     * 子数组 指的是一个数组中连续 非空 的元素序列。
     *
     * @param nums
     * @return
     */
    public int countSubarrays(int[] nums) {
        int rs = 0;

        int n = nums.length;
        for (int i = 0; i <= n - 3; i++) {
            if (nums[i] * 2 + nums[i + 2] * 2 == nums[i + 1]) {
                rs++;
            }
        }

        return rs;
    }
}
