package com.kylexu.leetcode.matrix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 */
public class Solution73 {
    public static void main(String[] args) {
//        输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
//        输出：[[1,0,1],[0,0,0],[1,0,1]]

        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        System.out.println("matrix before = " + Arrays.deepToString(matrix));
        new Solution73().setZeroes(matrix);
        System.out.println("matrix after = " + Arrays.deepToString(matrix));
    }

    public void setZeroes(int[][] matrix) {
        Set<Integer> hang = new HashSet<>();
        Set<Integer> lie = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            int[] innerMatrix = matrix[i];
            for (int j = 0; j < innerMatrix.length; j++) {
                if (innerMatrix[j] == 0) {
                    hang.add(i);
                    lie.add(j);
                }
            }
        }

        for (Integer h : hang) {
            Arrays.fill(matrix[h], 0);
        }

        for (int[] ints : matrix) {
            for (int i = 0; i < ints.length; i++) {
                if (lie.contains(i)) {
                    ints[i] = 0;
                }
            }
        }
    }
}
