package com.kylexu.leetcode.array;

import java.util.Arrays;

/**
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 */
public class Solution55 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        boolean b = new Solution55().canJump(nums);
        System.out.println("b = " + b);
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (dp[i - 1] > i) {
                dp[i] = Math.max(dp[i - 1], i + nums[i]);
            } else {
                dp[i] = 0;
            }
        }

        return dp[n - 2] >= n - 1 ? true : false;
    }
}
