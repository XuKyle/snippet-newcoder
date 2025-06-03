package com.kylexu.leetcode.num;

/**
 * 示例 1：
 * <p>
 * 输入：numOnes = 3, numZeros = 2, numNegOnes = 0, k = 2
 * 输出：2
 * 解释：袋子中的物品分别标记为 {1, 1, 1, 0, 0} 。取 2 件标记为 1 的物品，得到的数字之和为 2 。
 * 可以证明 2 是所有可行方案中的最大值。
 */
public class Solution2600 {
    public static void main(String[] args) {
        int numOnes = 3, numZeros = 2, numNegOnes = 7, k = 7;
        int rs = new Solution2600().kItemsWithMaximumSum(numOnes, numZeros, numNegOnes, k);
        System.out.println("rs = " + rs);
    }

    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (numOnes >= k) {
            return k;
        }

        if (numOnes + numZeros >= k) {
            return numOnes;
        }

        return numOnes - (k - numOnes - numZeros);
    }
}
