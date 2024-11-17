package com.kylexu.leetcode.company.jd;

public class Solution121 {
    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};
        System.out.println(new Solution121().maxProfit(nums));
    }

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int max = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }
            max = Math.max(max, price - minPrice);
        }
        return max;
    }

//    public int maxProfit(int[] prices) {
//        int max = 0;
//
//        for (int i = 0; i < prices.length; i++) {
//            for (int j = i; j < prices.length; j++) {
//                if (prices[j] - prices[i] > max) {
//                    max = prices[j] - prices[i];
//                }
//            }
//        }
//        return max;
//    }
}
