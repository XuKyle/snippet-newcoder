package com.kylexu.leetcode.array;

import java.util.Arrays;

public class Solution3201 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 1, 2, 1, 2};
        int i = new Solution3201().maximumLength(nums);
        System.out.println("i = " + i);
    }

    public int maximumLength(int[] nums) {
        return maximumLength(nums, 2);
    }

    public int maximumLength(int[] nums, int k) {
        int maxLength = 0;
        int[][] dp = new int[k][k];
        for (int num : nums) {
            int curr = num % k;
            for (int prev = 0; prev < k; prev++) {
                dp[prev][curr] = dp[curr][prev] + 1;
                maxLength = Math.max(maxLength, dp[prev][curr]);
            }
        }
        return maxLength;
    }
}
