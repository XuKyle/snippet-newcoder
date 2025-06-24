package com.kylexu.leetcode.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3033 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, -1}, {4, -1, 6}, {7, 8, 9}
        };
        int[][] ints = new Solution3033().modifiedMatrix(matrix);
        System.out.println("ints = " + Arrays.deepToString(ints));
    }

    public int[][] modifiedMatrix(int[][] matrix) {
        List<Integer> rs = new ArrayList<>();

        for (int i = 0; i < matrix[0].length; i++) {
            int t = -1;
            for (int[] ints : matrix) {
                t = Math.max(t, ints[i]);
            }
            rs.add(t);
        }

        for (int i = 0; i < matrix.length; i++) {
            int[] inner = matrix[i];
            for (int j = 0; j < inner.length; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = rs.get(j);
                }
            }
        }

        return matrix;
    }
}
