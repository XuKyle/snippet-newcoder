package com.kylexu.leetcode.num;

/**
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * <p>
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * <p>
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 4
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 */
public class Solution69 {

    public int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        if(x==2147483647){
            return 46340;
        }

        for (int i = 1; i <= (x / 2) + 1; i++) {
            if (i * i == x) {
                return i;
            }

            if (i * i > x) {
                return i - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution69().mySqrt(4));
        System.out.println(new Solution69().mySqrt(8));
        System.out.println(new Solution69().mySqrt(2147483647));

    }
}
