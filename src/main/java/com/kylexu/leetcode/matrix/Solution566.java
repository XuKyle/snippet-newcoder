package com.kylexu.leetcode.matrix;

import java.util.Arrays;

public class Solution566 {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 2},
                {3, 4},
        };
        int r = 4, c = 1;
        int[][] ints = new Solution566().matrixReshape(mat, r, c);
        System.out.println("ints = " + Arrays.deepToString(ints));
    }

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;

        if (m * n != r * c) {
            return mat;
        }
        if (m == r && n == c) {
            return mat;
        }

        int[][] rs = new int[r][c];
        int index = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int rIndex = index / n;
                int cIndex = index % n;

                rs[i][j] = mat[rIndex][cIndex];
                index++;
            }
        }

        return rs;
    }
}
