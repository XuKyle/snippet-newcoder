package com.kylexu.leetcode.num;

/**
 * 给你两个整数 n 和 t 。请你返回大于等于 n 的 最小 整数，且该整数的 各数位之积 能被 t 整除。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 10, t = 2
 * <p>
 * 输出：10
 * <p>
 * 解释：
 * <p>
 * 10 的数位乘积为 0 ，可以被 2 整除，所以它是大于等于 10 且满足题目要求的最小整数。
 */
public class Solution3345 {
    public static void main(String[] args) {
        int n = 15;
        int t = 3;
        int i = new Solution3345().smallestNumber(n, t);
        System.out.println("i = " + i);
    }

    public int smallestNumber(int n, int t) {
        for (int i = n; i < Integer.MAX_VALUE; i++) {
            if (digitProduct(i) % t == 0) {
                return i;
            }
        }

        return -1;
    }

    public int digitProduct(int n) {
        int rs = 1;
        while (n != 0) {
            rs *= n % 10;
            n = n / 10;
        }
        return rs;
    }
}
