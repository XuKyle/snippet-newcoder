package com.kylexu.leetcode.dp;

public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(new ClimbStairs().climbStairs(3));
    }

    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i < n + 1; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    public int climbStairs2(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        return memo[n];
    }

    public int climbStairs1(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
