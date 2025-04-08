package com.kylexu.leetcode.array;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其总和大于等于 target 的长度最小的
 * 子数组
 * [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 * <p>
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 */
public class Solution209 {
    public static void main(String[] args) {
        int target = 11;
        int[] nums = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
        int rs = new Solution209().minSubArrayLen(target, nums);
        System.out.println("rs = " + rs);
    }

    public int minSubArrayLen(int target, int[] nums) {
        // 所谓滑动窗口，就是不断的调节子序列的起始位置和终止位置，从而得出我们要想的结果。
        int rs = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                rs = Math.min(rs, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return rs == Integer.MAX_VALUE ? 0 : rs;
    }
}
