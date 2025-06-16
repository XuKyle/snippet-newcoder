package com.kylexu.leetcode.matrix;

import java.util.Arrays;

/**
 * [0,0,0],[0,1,0],[0,0,0]
 */
public class Solution62 {
    public static void main(String[] args) {
        int m = 3, n = 7;
        int i = new Solution62().uniquePaths(m, n);
        System.out.println("i = " + i);
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
