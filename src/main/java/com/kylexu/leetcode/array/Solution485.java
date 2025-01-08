package com.kylexu.leetcode.array;

/**
 * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 * 示例 2:
 * <p>
 * 输入：nums = [1,0,1,1,0,1]
 * 输出：2
 */
public class Solution485 {
    public static void main(String[] args) {
        var nums = new int[]{1, 0, 1, 1, 0, 1};
        System.out.println(new Solution485().findMaxConsecutiveOnes(nums));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int rs = 0;
        int left = 0;
        int right = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                left = i;
                right = left + 1;
                while (right < nums.length && nums[right] == 1) {
                    right++;
                }
                rs = Math.max(rs, right - left);
            } else {
                left++;
            }
        }

        return rs;
    }
}
