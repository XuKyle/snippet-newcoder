package com.kylexu.leetcode.num;

/**
 * 示例 1：
 * 输入：n = 4
 * 输出：10
 * 解释：第 4 天后，总额为 1 + 2 + 3 + 4 = 10 。
 * 示例 2：
 * <p>
 * 输入：n = 10
 * 输出：37
 * 解释：第 10 天后，总额为 (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4) = 37 。注意到第二个星期一，Hercy 存入 2 块钱。
 * 示例 3：
 * <p>
 * 输入：n = 20
 * 输出：96
 * 解释：第 20 天后，总额为 (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4 + 5 + 6 + 7 + 8) + (3 + 4 + 5 + 6 + 7 + 8) = 96 。
 */
public class Solution1716 {
    public static void main(String[] args) {
        int n = 20;
        System.out.println(new Solution1716().totalMoney(n));
    }

    public int totalMoney(int n) {
        int rs = 0;
        for (int i = 0; i < n; i++) {
            int multi = i / 7;
            rs += multi + (i % 7 + 1);
        }
        return rs;
    }
}
