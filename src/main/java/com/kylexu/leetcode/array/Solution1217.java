package com.kylexu.leetcode.array;

/**
 * 输入：position = [1,2,3]
 * 输出：1
 * 解释：第一步:将位置3的筹码移动到位置1，成本为0。
 * 第二步:将位置2的筹码移动到位置1，成本= 1。
 * 总成本是1。
 * 示例 2：
 * <p>
 * 输入：position = [2,2,2,3,3]
 * 输出：2
 * 解释：我们可以把位置3的两个筹码移到位置2。每一步的成本为1。总成本= 2。
 * 示例 3:
 * <p>
 * 输入：position = [1,1000000000]
 * 输出：1
 */
public class Solution1217 {
    public static void main(String[] args) {
        int[] position = new int[]{1, 1000000000};
        System.out.println(new Solution1217().minCostToMoveChips(position));
    }

    public int minCostToMoveChips(int[] position) {
        int oddSum = 0;
        int evenSum = 0;

        for (int currentIndex : position) {
            if (currentIndex % 2 == 0) {
                evenSum += 1;
            } else {
                oddSum += 1;
            }
        }

        return Math.min(oddSum, evenSum);
    }
}
