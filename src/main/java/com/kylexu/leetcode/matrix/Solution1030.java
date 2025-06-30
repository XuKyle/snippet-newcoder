package com.kylexu.leetcode.matrix;

import java.util.Arrays;
import java.util.Comparator;

public class Solution1030 {
    public static void main(String[] args) {
        int rows = 2;
        int cols = 3;
        int rCenter = 1;
        int cCenter = 2;
        int[][] ints = new Solution1030().allCellsDistOrder(rows, cols, rCenter, cCenter);
        System.out.println("ints = " + Arrays.deepToString(ints));
    }

    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] rs = new int[rows * cols][2];

        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rs[index][0] = i;
                rs[index][1] = j;

                index++;
            }
        }

        Arrays.sort(rs, new Comparator<int[]>() {
            @Override
            public int compare(int[] left, int[] right) {
//                单元格(r1, c1) 和 (r2, c2) 之间的距离为|r1 - r2| + |c1 - c2|。
                return Integer.compare(
                        Math.abs(left[0] - rCenter) + Math.abs(left[1] - cCenter),
                        Math.abs(right[0] - rCenter) + Math.abs(right[1] - cCenter)
                );
            }
        });

        return rs;
    }
}
