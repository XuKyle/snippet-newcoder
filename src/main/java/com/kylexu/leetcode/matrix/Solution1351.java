package com.kylexu.leetcode.matrix;

/**
 * 给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非严格递减顺序排列。 请你统计并返回 grid 中 负数 的数目。
 * 示例 1：
 * <p>
 * 输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * 输出：8
 * 解释：矩阵中共有 8 个负数。
 * 示例 2：
 * <p>
 * 输入：grid = [[3,2],[1,0]]
 * 输出：0
 */
public class Solution1351 {
    public static void main(String[] args) {
        int[][] grid = {
                {4, 3, 2, -1},
                {3, 2, 1, -1},
                {1, 1, -1, -2},
                {-1, -1, -2, -3}
        };
        System.out.println(new Solution1351().countNegatives(grid));

    }

    public int countNegatives(int[][] grid) {
        int rs = 0;

        for (int[] ints : grid) {
            int n = ints.length;
            for (int i = 0; i < n; i++) {
                if (ints[i] < 0) {
                    rs += (n - i);
                    break;
                }
            }
        }

        return rs;
    }
}
