package com.kylexu.leetcode.num;

/**
 * 示例 1：
 * 输入：nums = [-4,-2,1,4,8]
 * 输出：1
 * 解释：
 * -4 到 0 的距离为 |-4| = 4 。
 * -2 到 0 的距离为 |-2| = 2 。
 * 1 到 0 的距离为 |1| = 1 。
 * 4 到 0 的距离为 |4| = 4 。
 * 8 到 0 的距离为 |8| = 8 。
 * 所以，数组中距离 0 最近的数字为 1 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,-1,1]
 * 输出：1
 * 解释：1 和 -1 都是距离 0 最近的数字，所以返回较大值 1 。
 */
public class Solution2239 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, -1, 1};
        System.out.println(new Solution2239().findClosestNumber(nums));
    }

    public int findClosestNumber(int[] nums) {
        int minGap = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        for (int num : nums) {
            if (Math.abs(num) < minGap) {
                minGap = Math.abs(num);
                maxValue = num;
            } else if (Math.abs(num) == minGap) {
                maxValue = Math.max(maxValue, num);
            }
        }

        return maxValue;
    }
}
