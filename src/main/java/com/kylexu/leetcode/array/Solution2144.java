package com.kylexu.leetcode.array;

import java.util.Arrays;

/**
 * 示例 1：
 * <p>
 * 输入：cost = [1,2,3]
 * 输出：5
 * 解释：我们购买价格为 2 和 3 的糖果，然后免费获得价格为 1 的糖果。
 * 总开销为 2 + 3 = 5 。这是开销最小的 唯一 方案。
 * 注意，我们不能购买价格为 1 和 3 的糖果，并免费获得价格为 2 的糖果。
 * 这是因为免费糖果的价格必须小于等于购买的 2 个糖果价格的较小值。
 * 示例 2：
 * <p>
 * 输入：cost = [6,5,7,9,2,2]
 * 输出：23
 * 解释：最小总开销购买糖果方案为：
 * - 购买价格为 9 和 7 的糖果
 * - 免费获得价格为 6 的糖果
 * - 购买价格为 5 和 2 的糖果
 * - 免费获得价格为 2 的最后一个糖果
 * 因此，最小总开销为 9 + 7 + 5 + 2 = 23 。
 * 示例 3：
 * <p>
 * 输入：cost = [5,5]
 * 输出：10
 * 解释：由于只有 2 个糖果，我们需要将它们都购买，而且没有免费糖果。
 * 所以总最小开销为 5 + 5 = 10 。
 */
public class Solution2144 {
    public static void main(String[] args) {
        int[] cost = new int[]{1, 2, 3};
        System.out.println(new Solution2144().minimumCost(cost));
    }

    public int minimumCost(int[] cost) {
        Arrays.sort(cost);

        int n = cost.length;

        int rs = 0;
        for (int i = n - 1; i >= 0; i -= 3) {
            rs += cost[i];
            if (i > 0) {
                rs += cost[i - 1];
            }
        }

        return rs;
    }
}
