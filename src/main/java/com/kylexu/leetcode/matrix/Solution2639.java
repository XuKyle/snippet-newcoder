package com.kylexu.leetcode.matrix;

import java.util.Arrays;

public class Solution2639 {
    public static void main(String[] args) {
//        输入：grid = [[-15,1,3],[15,7,12],[5,6,-2]]
        int[][] grid = {
                {-15, 1, 3},
                {15, 7, 12},
                {5, 6, -2},
        };
        int[] columnWidth = new Solution2639().findColumnWidth(grid);
        System.out.println("columnWidth = " + Arrays.toString(columnWidth));
    }

    public int[] findColumnWidth(int[][] grid) {
        int n = grid[0].length;
        int[] rs = new int[n];

        int m = grid.length;

        for (int i = 0; i < n; i++) {
            int maxWidth = 0;
            for (int[] ints : grid) {
                int num = ints[i];
                maxWidth = Math.max(String.valueOf(num).length(), maxWidth);
            }
            rs[i] = maxWidth;
        }
        
        return rs;
    }
}
