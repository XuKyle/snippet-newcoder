package com.kylexu.leetcode.num;

/**
 * 示例 1：
 * <p>
 * 输入：n = 12
 * <p>
 * 输出：true
 * <p>
 * 解释：
 * <p>
 * Alice 第一次操作中移除 10 个石头，剩下 2 个石头给 Bob 。
 * Bob 无法移除 9 个石头，所以 Alice 赢下游戏。
 * 示例 2：
 * <p>
 * 输入：n = 1
 * <p>
 * 输出：false
 * <p>
 * 解释：
 * <p>
 * Alice 无法移除 10 个石头，所以 Alice 输掉游戏。
 */
public class Solution3360 {
    public static void main(String[] args) {
        int n = 1;
        boolean b = new Solution3360().canAliceWin(n);
        System.out.println("b = " + b);
    }

    public boolean canAliceWin(int n) {
        int current = 10;
        boolean flag = true;

        while (true) {
            if (flag) {
                if (n >= current) {
                    n -= current;
                    current--;
                    flag = false;
                } else {
                    return false;
                }
            } else {
                if (n >= current) {
                    n -= current;
                    current--;
                    flag = true;
                } else {
                    return true;
                }
            }
        }
    }
}
