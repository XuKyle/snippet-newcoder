package com.kylexu.leetcode.dp;

import java.util.Arrays;

public class Solution746V2 {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];

        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i < cost.length + 1; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }

        return dp[cost.length];
    }

    public static void main(String[] args) {
        //        val cost = Array(10, 15, 20)
//        val rs = Solution746V1.minCostClimbingStairs(cost)
//        println(rs)

        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
//        int[] cost = {10, 15, 20};
        int i = new Solution746V2().minCostClimbingStairs(cost);
        System.out.println("i = " + i);
    }
}