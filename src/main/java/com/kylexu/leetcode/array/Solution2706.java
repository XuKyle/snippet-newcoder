package com.kylexu.leetcode.array;

import java.util.Arrays;

public class Solution2706 {
    public static void main(String[] args) {
        int[] prices = {98, 54, 6, 34, 66, 63, 52, 39};
        int money = 62;
        int rs = new Solution2706().buyChoco(prices, money);
        System.out.println("rs = " + rs);
    }

    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);

        if (prices[0] + prices[1] > money) {
            return money;
        } else {
            return money - prices[0] - prices[1];
        }
    }
}
