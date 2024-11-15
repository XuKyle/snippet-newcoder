package com.kylexu.leetcode.dp;

public class ClimbStairsCost {
    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(new ClimbStairsCost().minCostClimbingStairs(cost));
    }


    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 0;

        for (int i = 2; i < n + 1; i++) {
            memo[i] = Math.min(memo[i - 1] + cost[i - 1], memo[i - 2] + cost[i - 2]);
        }

        return memo[n];
    }
}
