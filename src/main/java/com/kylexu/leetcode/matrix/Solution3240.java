package com.kylexu.leetcode.matrix;

public class Solution3240 {
    public static void main(String[] args) {
//        [[3,2],[1,3],[3,4],[0,1]]
//        int[][] grid = {{3, 2, 1}, {2, 1, 0}, {1, 2, 3}};
        int[][] grid = {{0}, {50}};

        int rs = new Solution3240().minimumOperations(grid);
        System.out.println("rs = " + rs);
    }

    public int minimumOperations(int[][] grid) {
        int rs = 0;

        int n = grid.length;
        int m = grid[0].length;

        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                int pre = grid[i - 1][j];
                int current = grid[i][j];

                if (current <= pre) {
                    rs += pre - current + 1;
                    grid[i][j] = pre + 1;
                }
            }
        }

        return rs;
    }
}
