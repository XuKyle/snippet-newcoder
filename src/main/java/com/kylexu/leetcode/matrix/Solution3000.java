package com.kylexu.leetcode.matrix;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * 示例 1：
 * <p>
 * 输入：dimensions = [[9,3],[8,6]]
 * 输出：48
 * 解释：
 * 下标 = 0，长度 = 9，宽度 = 3。对角线长度 = sqrt(9 * 9 + 3 * 3) = sqrt(90) ≈ 9.487。
 * 下标 = 1，长度 = 8，宽度 = 6。对角线长度 = sqrt(8 * 8 + 6 * 6) = sqrt(100) = 10。
 * 因此，下标为 1 的矩形对角线更长，所以返回面积 = 8 * 6 = 48。
 * 示例 2：
 * <p>
 * 输入：dimensions = [[3,4],[4,3]]
 * 输出：12
 * 解释：两个矩形的对角线长度相同，为 5，所以最大面积 = 12。
 */
public class Solution3000 {
    public static void main(String[] args) {
        int[][] dimensions = {
                {2, 6},
                {5, 1},
                {3, 10},
                {8, 4}

//                        [[2,6],[5,1],[3,10],[8,4]]


        };
        int rs = new Solution3000().areaOfMaxDiagonal(dimensions);
        System.out.println("rs = " + rs);
    }

    public int areaOfMaxDiagonal(int[][] dimensions) {
        return Arrays.stream(dimensions)
                .sorted((o1, o2) -> {
                    int compare = Integer.compare(o1[0] * o1[0] + o1[1] * o1[1], o2[0] * o2[0] + o2[1] * o2[1]);
                    if (compare == 0) {
                        return -1 * Integer.compare(o1[0] * o1[1], o2[0] * o2[1]);
                    }
                    return -1 * compare;
                })
                .limit(1)
                .map(nums -> nums[0] * nums[1])
                .findFirst()
                .get();
    }
}
