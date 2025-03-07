package com.kylexu.leetcode.num;

/**
 * 输入：numBottles = 9, numExchange = 3
 * 输出：13
 * 解释：你可以用 3 个空瓶兑换 1 瓶水。
 * 所以最多能喝到 9 + 3 + 1 = 13 瓶水。
 * <p>
 * 输入：numBottles = 15, numExchange = 4
 * 输出：19
 * 解释：你可以用 4 个空瓶兑换 1 瓶水。
 * 所以最多能喝到 15 + 3 + 1 = 19 瓶水。
 */
public class Solution1518 {
    public static void main(String[] args) {
        int numBottles = 9;
        int numExchange = 3;
        System.out.println(new Solution1518().numWaterBottles(numBottles, numExchange));
    }

    public int numWaterBottles(int numBottles, int numExchange) {
        int rs = 0;

        int left = numBottles;
        rs += left;

        while (left >= numExchange) {
            rs += left / numExchange;
            left = (left / numExchange) + (left % numExchange);
        }

        return rs;
    }
}
