package com.kylexu.leetcode.num;

/**
 * 示例 1：
 * <p>
 * 输入：x = 2, y = 7
 * <p>
 * 输出："Alice"
 * <p>
 * 解释：
 * <p>
 * 游戏一次操作后结束：
 * <p>
 * Alice 拿走 1 枚价值为 75 的硬币和 4 枚价值为 10 的硬币。
 * 示例 2：
 * <p>
 * 输入：x = 4, y = 11
 * <p>
 * 输出："Bob"
 * <p>
 * 解释：
 * <p>
 * 游戏 2 次操作后结束：
 * <p>
 * Alice 拿走 1 枚价值为 75 的硬币和 4 枚价值为 10 的硬币。
 * Bob 拿走 1 枚价值为 75 的硬币和 4 枚价值为 10 的硬币。
 */
public class Solution3222 {
    public static void main(String[] args) {
        int x = 4, y = 11;
        String rs = new Solution3222().winningPlayer(x, y);
        System.out.println("rs = " + rs);
    }

    public String winningPlayer(int x, int y) {
        // 给你两个 正 整数 x 和 y ，分别表示价值为 75 和 10 的硬币的数目。
        // Alice 和 Bob 正在玩一个游戏。每一轮中，Alice 先进行操作，Bob 后操作。
        // 每次操作中，玩家需要拿走价值 总和 为 115 的硬币。如果一名玩家无法执行此操作，那么这名玩家 输掉 游戏。
        boolean flag = true;
        while (x >= 1 && y >= 4) {
            x -= 1;
            y -= 4;
            flag = !flag;
        }

        if (flag) {
            return "Bob";
        }
        return "Alice";
    }
}
