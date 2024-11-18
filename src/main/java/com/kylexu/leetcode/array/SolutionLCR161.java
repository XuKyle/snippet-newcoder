package com.kylexu.leetcode.array;

/**
 * 某公司每日销售额记于整数数组 sales，请返回所有 连续 一或多天销售额总和的最大值。
 * <p>
 * 要求实现时间复杂度为 O(n) 的算法。
 * <p>
 * 示例 1:
 * <p>
 * 输入：sales = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：[4,-1,2,1] 此连续四天的销售总额最高，为 6。
 * 示例 2:
 * <p>
 * 输入：sales = [5,4,-1,7,8]
 * 输出：23
 * 解释：[5,4,-1,7,8] 此连续五天的销售总额最高，为 23。
 */
public class SolutionLCR161 {
    public static void main(String[] args) {
        int[] sales = new int[]{5, 4, -1, 7, 8};
        System.out.println(new SolutionLCR161().maxSales(sales));
    }

    public int maxSales(int[] sales) {
        int sum = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;

        for (int sale : sales) {
            if (sum >= 0) {
                sum += sale;
            } else {
                sum = sale;
            }
            max = Math.max(max, sum);
        }

        return max;
    }
}
