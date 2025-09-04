package com.kylexu.leetcode.matrix;

import java.util.Arrays;

public class Solution2500 {
    public static void main(String[] args) {
        int[][] grid = {{1, 2, 4}, {3, 3, 1}};
        int i = new Solution2500().deleteGreatestValue(grid);
        System.out.println("i = " + i);

    }

    public int deleteGreatestValue(int[][] grid) {
        for (int[] ints : grid) {
            Arrays.sort(ints);
        }

        int rs = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < m; j++) {
                max = Math.max(max, grid[j][i]);
            }
            rs += max;
        }

        return rs;
    }
}
