package com.kylexu.leetcode.recursion;

/**
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给定 n ，请计算 F(n) 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 */
public class Solution509 {
    public int fib(int n) {
        if(n == 0 || n ==1){
            return  n;
        }

        int[] rs= new int[n + 1];

        rs[0] = 0;
        rs[1] = 1;

        for (int i = 2; i <= n; i++) {
            rs[i] = rs[i-1] + rs[i-2];
        }

        return rs[n];
    }
}
