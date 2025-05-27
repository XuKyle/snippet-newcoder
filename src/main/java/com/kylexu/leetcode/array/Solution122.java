package com.kylexu.leetcode.array;

/**
 * 示例 1：
 * <p>
 * 输入：prices = [7,1,5,3,6,4]
 * 输出：7
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4。
 * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3。
 * 最大总利润为 4 + 3 = 7 。
 * 示例 2：
 * <p>
 * 输入：prices = [1,2,3,4,5]
 * 输出：4
 * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4。
 * 最大总利润为 4 。
 * 示例 3：
 * <p>
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 交易无法获得正利润，所以不参与交易可以获得最大利润，最大利润为 0。
 */
public class Solution122 {
    public static void main(String[] args) {
        int[] prices = {7, 6, 4, 3, 1};
        int rs = new Solution122().maxProfit(prices);
        System.out.println("rs = " + rs);
    }

    public int maxProfit(int[] prices) {
        int rs = 0;

        int start = 0;
        for (int i = start + 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                if (prices[i - 1] > prices[start]) {
                    rs += prices[i - 1] - prices[start];
                }
                start = i;
            }

            if (i == prices.length - 1) {
                if (prices[i] > prices[start]) {
                    rs += prices[i] - prices[start];
                }
            }
        }

        return rs;
    }
}
