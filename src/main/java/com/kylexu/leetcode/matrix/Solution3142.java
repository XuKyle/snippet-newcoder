package com.kylexu.leetcode.matrix;

/**
 * 输入：grid = [[1,0,2],[1,0,2]]
 * <p>
 * 输出：true
 */
public class Solution3142 {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 2},
                {1, 0, 2},
        };
        boolean b = new Solution3142().satisfiesConditions(grid);
        System.out.println("b = " + b);
    }

    public boolean satisfiesConditions(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i < m - 1) {
                    if (grid[i][j] != grid[i + 1][j]) {
                        return false;
                    }
                }

                if (j < n - 1) {
                    if (grid[i][j] == grid[i][j + 1]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
