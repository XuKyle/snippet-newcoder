package com.kylexu.leetcode.array;

/**
 * 示例 1：
 * 输入：nums = [1,2,4]
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * 由于 nums 是循环的，nums[0] 和 nums[2] 是相邻的，它们之间的绝对差值是最大值 |4 - 1| = 3 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [-5,-10,-5]
 * <p>
 * 输出：5
 * <p>
 * 解释：
 * <p>
 * 相邻元素 nums[0] 和 nums[1] 之间的绝对差值为最大值 |-5 - (-10)| = 5 。
 */
public class Solution3423 {
    public static void main(String[] args) {
        int[] nums = new int[]{-5, -10, -5};
        int rs = new Solution3423().maxAdjacentDistance(nums);
        System.out.println("rs = " + rs);
    }

    public int maxAdjacentDistance(int[] nums) {
        int rs = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                rs = Math.max(rs, Math.abs(nums[i] - nums[0]));
            } else {
                rs = Math.max(rs, Math.abs(nums[i] - nums[i + 1]));
            }
        }

        return rs;
    }
}
