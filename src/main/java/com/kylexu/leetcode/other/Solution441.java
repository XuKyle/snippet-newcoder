package com.kylexu.leetcode.other;

/**
 * 你总共有 n 枚硬币，并计划将它们按阶梯状排列。
 * 对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。
 * 输入：n = 5
 * 输出：2
 * 解释：因为第三行不完整，所以返回 2 。
 * <p>
 * 给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。
 */
public class Solution441 {
    public static void main(String[] args) {
        System.out.println(new Solution441().arrangeCoins(8));
    }

    public int arrangeCoins(int n) {
        long sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += i;
            if (sum == n) {
                return i;
            } else if (sum > n) {
                return i - 1;
            }
        }

        return -1;
    }
}
