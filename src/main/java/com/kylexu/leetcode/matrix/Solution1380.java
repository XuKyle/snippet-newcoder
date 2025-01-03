package com.kylexu.leetcode.matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;

/**
 * 给你一个 m x n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
 * 幸运数 是指矩阵中满足同时下列两个条件的元素：
 * <p>
 * 在同一行的所有元素中最小
 * 在同一列的所有元素中最大
 * 示例 1：
 * 输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]
 * 输出：[15]
 * 解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
 * 输出：[12]
 * 解释：12 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
 * 示例 3：
 * <p>
 * 输入：matrix = [[7,8],[1,2]]
 * 输出：[7]
 * 解释：7 是唯一的幸运数字，因为它是行中的最小值，列中的最大值。
 */
public class Solution1380 {
    public static void main(String[] args) {
//        int[][] matrix = {
//                {3, 7, 8},
//                {9, 11, 13},
//                {15, 16, 17}
//        };

        int[][] matrix = {
                {1, 10, 4, 2},
                {9, 3, 8, 7},
                {15, 16, 17, 12}
        };
        List<Integer> luckied = new Solution1380().luckyNumbers(matrix);
        System.out.println("luckied = " + luckied);
    }

    public List<Integer> luckyNumbers(int[][] matrix) {
        HashMap<Integer, Integer> lineLow = new HashMap<>();
        HashMap<Integer, Integer> columnHigh = new HashMap<>();

        for (int i = 0; i < matrix.length; i++) {
            int[] matrixj = matrix[i];
            for (int j = 0; j < matrixj.length; j++) {
                int current = matrixj[j];
                lineLow.merge(i, current, Math::min);
                columnHigh.merge(j, current, Math::max);
            }
        }

        List<Integer> rs = new ArrayList<>();
        for (Integer value : lineLow.values()) {
            if (columnHigh.containsValue(value)) {
                rs.add(value);
            }
        }

        return rs;
    }
}
