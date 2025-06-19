package com.kylexu.leetcode.matrix;

/**
 * matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 */
public class Solution766 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 1, 2, 3},
                {9, 5, 1, 2},
        };

        boolean toeplitzMatrix = new Solution766().isToeplitzMatrix(matrix);
        System.out.println("toeplitzMatrix = " + toeplitzMatrix);
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // 横向
        for (int i = 0; i < n; i++) {
            int current = matrix[0][i];
            for (int j = 1; j < m && i + j < n; j++) {
                int next = matrix[j][i + j];
                if (next != current) {
                    return false;
                }
            }
        }

        // 纵向
        for (int i = 1; i < m; i++) {
            int current = matrix[i][0];
            for (int j = 1; j < n && j + i < m; j++) {
                int next = matrix[i + j][j];
                if (current != next) {
                    return false;
                }
            }
        }

        return true;
    }
}
