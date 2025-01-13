package com.kylexu.leetcode.num;

/**
 * 给你两个正整数 a 和 b ，返回 a 和 b 的 公 因子的数目。
 * 如果 x 可以同时整除 a 和 b ，则认为 x 是 a 和 b 的一个 公因子 。
 * <p>
 * 示例 1：
 * 输入：a = 12, b = 6
 * 输出：4
 * 解释：12 和 6 的公因子是 1、2、3、6 。
 * 示例 2：
 * <p>
 * 输入：a = 25, b = 30
 * 输出：2
 * 解释：25 和 30 的公因子是 1、5 。
 */
public class Solution2427 {
    public static void main(String[] args) {
        int a = 25;
        int b = 30;
        System.out.println(new Solution2427().commonFactors(a, b));
    }


    public int commonFactors(int a, int b) {
        int rs = 0;

        int min = Math.min(a, b);
        for (int i = 1; i <= min; i++) {
            if (a % i == 0 && b % i == 0) {
                rs++;
            }
        }

        return rs;
    }
}
