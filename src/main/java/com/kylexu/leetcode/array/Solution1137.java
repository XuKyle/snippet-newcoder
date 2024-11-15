package com.kylexu.leetcode.array;

/**
 * 泰波那契序列 Tn 定义如下：
 * <p>
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * <p>
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 * 示例 1：
 * <p>
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * 示例 2：
 * <p>
 * 输入：n = 25
 * 输出：1389537
 */
public class Solution1137 {
    public static void main(String[] args) {
        System.out.println(new Solution1137().tribonacci(4));
        System.out.println(new Solution1137().tribonacci(25));
    }

    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;

        int[] ints = new int[n + 1];
        ints[0] = 0;
        ints[1] = 1;
        ints[2] = 1;

        for (int i = 3; i < n + 1; i++) {
            ints[i] = ints[i - 1] + ints[i - 2] + ints[i - 3];
        }

        return ints[n];
    }
}
