package com.kylexu.leetcode.linklist;

import java.util.Arrays;

public class Solution70V1 {
    public static void main(String[] args) {
        int i = new Solution70V1().climbStairs(4);
        System.out.println("i = " + i);
    }

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }


        return dp[n];
    }
}

