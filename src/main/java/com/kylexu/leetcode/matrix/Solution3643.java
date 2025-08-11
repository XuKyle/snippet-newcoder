package com.kylexu.leetcode.matrix;

import java.util.Arrays;

public class Solution3643 {
    public static void main(String[] args) {
//        输入： grid = [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]], x = 1, y = 0, k = 3
//
//        输出： [[1,2,3,4],[13,14,15,8],[9,10,11,12],[5,6,7,16]]
        int[][] grid = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int x = 1, y = 0, k = 3;
        int[][] ints = new Solution3643().reverseSubmatrix(grid, x, y, k);
        System.out.println("ints = " + Arrays.deepToString(ints));
    }

    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] rs = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 反转区域
                if (i >= x && i < x + k && j >= y && j < y + k) {
                    int ri = x + (k - (i - x) - 1);
//                    System.out.println("ri = " + ri);
                    rs[i][j] = grid[ri][j];
                } else {
                    rs[i][j] = grid[i][j];
                }
            }
        }

        return rs;
    }
}
