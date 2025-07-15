package com.kylexu.leetcode.matrix;

public class Solution892 {
    public static void main(String[] args) {
        int[][] grid = {
                {2, 2, 2},
                {2, 1, 2},
                {2, 2, 2},
        };
        int i = new Solution892().surfaceArea(grid);
        System.out.println("i = " + i);
    }

    public int surfaceArea(int[][] grid) {
        int rs = 0;

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                // 上下
                rs += 2;
                // 左边
                if (i == 0) {
                    rs += grid[i][j];
                } else {
                    rs += grid[i - 1][j] > grid[i][j] ? 0 : grid[i][j] - grid[i - 1][j];
                }
                // 右边
                if (i == m - 1) {
                    rs += grid[i][j];
                } else {
                    rs += grid[i + 1][j] > grid[i][j] ? 0 : grid[i][j] - grid[i + 1][j];
                }
                // 前
                if (j == 0) {
                    rs += grid[i][j];
                } else {
                    rs += grid[i][j - 1] > grid[i][j] ? 0 : grid[i][j] - grid[i][j - 1];
                }

                // 后
                if (j == n - 1) {
                    rs += grid[i][j];
                } else {
                    rs += grid[i][j + 1] > grid[i][j] ? 0 : grid[i][j] - grid[i][j + 1];
                }
            }
        }

        return rs;
    }
}
