package com.kylexu.leetcode.matrix;

import java.util.Arrays;

/**
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：[[1]]
 */
public class Solution59 {
    public static void main(String[] args) {
        int n = 4;
        int[][] ints = new Solution59().generateMatrix(n);
        System.out.println("ints = " + Arrays.deepToString(ints));
    }

    public int[][] generateMatrix(int n) {
        int[][] rs = new int[n][n];

        int startX = 0;
        int startY = 0;
        int offset = 1;

        int i = 0;
        int j = 0;

        int loop = 1;
        int value = 1;

        while (loop <= n / 2) {
            for (j = startY; j < n - offset; j++) {
                rs[startX][j] = value++;
            }

            for (i = startX; i < n - offset; i++) {
                rs[i][j] = value++;
            }

            for (; j > startY; j--) {
                rs[i][j] = value++;
            }

            for (; i > startX; i--) {
                rs[i][j] = value++;
            }

            startX++;
            startY++;
            loop++;
            offset++;
        }

        if (n % 2 != 0) {
            rs[startY][startY] = value++;
        }

        return rs;
    }
}
