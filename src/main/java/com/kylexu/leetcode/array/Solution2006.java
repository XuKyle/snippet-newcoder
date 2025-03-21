package com.kylexu.leetcode.array;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回数对 (i, j) 的数目，满足 i < j 且 |nums[i] - nums[j]| == k 。
 * |x| 的值定义为：
 * <p>
 * 如果 x >= 0 ，那么值为 x 。
 * 如果 x < 0 ，那么值为 -x 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2,1], k = 1
 * 输出：4
 * 解释：差的绝对值为 1 的数对为：
 * - [1,2,2,1]
 * - [1,2,2,1]
 * - [1,2,2,1]
 * - [1,2,2,1]
 * 示例 2：
 * <p>
 * 输入：nums = [1,3], k = 3
 * 输出：0
 * 解释：没有任何数对差的绝对值为 3 。
 * 示例 3：
 * <p>
 * 输入：nums = [3,2,1,5,4], k = 2
 * 输出：3
 * 解释：差的绝对值为 2 的数对为：
 * - [3,2,1,5,4]
 * - [3,2,1,5,4]
 * - [3,2,1,5,4]
 */
public class Solution2006 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 1};
        int k = 1;
        System.out.println(new Solution2006().countKDifference(nums, k));
    }

    public int countKDifference(int[] nums, int k) {
        int rs = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    rs++;
                }
            }
        }

        return rs;
    }
}
