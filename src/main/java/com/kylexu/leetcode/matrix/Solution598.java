package com.kylexu.leetcode.matrix;

import java.util.Arrays;

public class Solution598 {
    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[][] ops = {
                {2, 2},
                {3, 3}
        };
        int i = new Solution598().maxCount(m, n, ops);
        System.out.println("i = " + i);
    }

    public int maxCount(int m, int n, int[][] ops) {
        int max = 0;
        int[][] matrix = new int[m][n];
        for (int[] op : ops) {
            int ai = op[0];
            int bi = op[1];

            for (int i = 0; i < ai; i++) {
                for (int j = 0; j < bi; j++) {
                    matrix[i][j] += 1;
                    max = Math.max(matrix[i][j], max);
                }
            }
        }

        int rs = 0;
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if (anInt == max) {
                    rs++;
                }
            }
        }

        return rs;
    }

}
