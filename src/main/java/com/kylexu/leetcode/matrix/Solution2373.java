package com.kylexu.leetcode.matrix;

import java.util.Arrays;

public class Solution2373 {
    public static void main(String[] args) {
        int[][] grid = {{9, 9, 8, 1}, {5, 6, 2, 6}, {8, 2, 6, 4}, {6, 2, 2, 2}};
        int[][] ints = new Solution2373().largestLocal(grid);
        System.out.println("ints = " + Arrays.deepToString(ints));
    }

    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] rs = new int[n - 2][n - 2];

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {

                int centerX = i + 1;
                int centerY = j + 1;

                int max = Integer.MIN_VALUE;

                for (int ci = centerX - 1; ci <= centerX + 1; ci++) {
                    for (int cy = centerY - 1; cy <= centerY + 1; cy++) {
                        max = Math.max(max, grid[ci][cy]);
                    }
                }

                rs[i][j] = max;
            }
        }

        return rs;
    }
}
