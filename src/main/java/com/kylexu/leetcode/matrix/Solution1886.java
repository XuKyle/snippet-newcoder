package com.kylexu.leetcode.matrix;

import java.util.Arrays;

public class Solution1886 {
    public static void main(String[] args) {
        int[][] mat = {{0, 0}, {0, 1}};
        int[][] target = {{0, 0}, {1, 0}};
        boolean rotation = new Solution1886().findRotation(mat, target);
        System.out.println("rotation = " + rotation);
    }

    public boolean findRotation(int[][] mat, int[][] target) {
        boolean rs = false;

        if (same(mat, target)) {
            return true;
        }

        // 左转
        int n = mat.length;
        int[][] mat1 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat1[i][j] = mat[n - 1 - j][i];
            }
        }
        System.out.println("mat1 = " + Arrays.deepToString(mat1));
        if (same(mat1, target)) {
            return true;
        }

        // 左转2
        int[][] mat2 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat2[i][j] = mat[n - i - 1][n - j - 1];
            }
        }
        System.out.println("mat2 = " + Arrays.deepToString(mat2));
        if (same(mat2, target)) {
            return true;
        }

        // 左转3
        int[][] mat3 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat3[i][j] = mat[j][n - i - 1];
            }
        }
        System.out.println("mat3 = " + Arrays.deepToString(mat3));
        if (same(mat3, target)) {
            return true;
        }


        return rs;
    }

    boolean same(int[][] mat, int[][] target) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != target[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
