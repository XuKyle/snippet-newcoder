package com.kylexu.leetcode.array;

/**
 * 如果数组是单调递增或单调递减的，那么它是 单调 的。
 * 如果对于所有 i <= j，nums[i] <= nums[j]，那么数组 nums 是单调递增的。 如果对于所有 i <= j，nums[i]> = nums[j]，那么数组 nums 是单调递减的。
 * 当给定的数组 nums 是单调数组时返回 true，否则返回 false。
 * 示例 1：
 * 输入：nums = [1,2,2,3]
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：nums = [6,5,4,4]
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：nums = [1,3,2]
 * 输出：false
 */
public class Solution896 {
    public static void main(String[] args) {
        int[] nums = new int[]{6, 5, 4, 4};
        System.out.println(new Solution896().isMonotonic(nums));
    }

    public boolean isMonotonic(int[] nums) {
        boolean first = false;
        boolean ascending = false;

        for (int i = 1; i < nums.length; i++) {
            if (!first && nums[i] != nums[i - 1]) {
                first = true;
                ascending = nums[i] > nums[i - 1];
                continue;
            }

            if (nums[i] == nums[i - 1]) {

            } else if ((nums[i] > nums[i - 1]) == ascending) {

            } else {
                return false;
            }
        }
        return true;
    }
}
