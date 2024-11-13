package com.kylexu.leetcode.array;

/**
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,0,1]
 * 输出：2
 * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：2
 * 解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 */
public class Solution268 {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int numSum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += i;
            numSum += nums[i];
        }

        return sum + nums.length - numSum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution268().missingNumber(new int[]{3, 0, 1}));
        System.out.println(new Solution268().missingNumber(new int[]{0, 1}));
    }
}
