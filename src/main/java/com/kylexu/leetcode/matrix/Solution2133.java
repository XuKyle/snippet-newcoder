package com.kylexu.leetcode.matrix;

import java.util.Arrays;

public class Solution2133 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {3, 1, 2},
                {2, 3, 1}
        };
        System.out.println(new Solution2133().checkValid(matrix));
    }

    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            int[] tmp = new int[n];
            for (int j = 0; j < n; j++) {
                tmp[j] = matrix[j][i];
            }
            Arrays.sort(tmp);

            for (int j = 0; j < tmp.length; j++) {
                if (tmp[j] != j + 1) {
                    return false;
                }
            }
        }

        for (int[] ints : matrix) {
            Arrays.sort(ints);
            for (int i = 0; i < ints.length; i++) {
                if (ints[i] != i + 1) {
                    return false;
                }
            }
        }

        return true;
    }
}
