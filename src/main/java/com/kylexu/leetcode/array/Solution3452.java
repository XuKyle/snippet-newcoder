package com.kylexu.leetcode.array;

/**
 * 示例 1：
 * 输入： nums = [1,3,2,1,5,4], k = 2
 * <p>
 * 输出： 12
 * <p>
 * 解释：
 * <p>
 * 好的数字包括 nums[1] = 3，nums[4] = 5 和 nums[5] = 4，因为它们严格大于下标 i - k 和 i + k 处的数字。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [2,1], k = 1
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * 唯一的好数字是 nums[0] = 2，因为它严格大于 nums[1]。
 */
public class Solution3452 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2, 1, 5, 4};
        int k = 2;
        int i = new Solution3452().sumOfGoodNumbers(nums, k);
        System.out.println("i = " + i);
    }

    public int sumOfGoodNumbers(int[] nums, int k) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            boolean flag = true;
            if (i - k >= 0 && current <= nums[i - k]) {
                flag = false;
            }
            if (i + k < nums.length && current <= nums[i + k]) {
                flag = false;
            }

            if (flag) {
                sum += current;
            }
        }
        return sum;
    }
}
