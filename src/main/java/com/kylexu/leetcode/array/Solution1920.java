package com.kylexu.leetcode.array;

import java.util.Arrays;

/**
 * 示例 1：
 * <p>
 * 输入：nums = [0,2,1,5,3,4]
 * 输出：[0,1,2,4,5,3]
 * 解释：数组 ans 构建如下：
 * ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
 * = [nums[0], nums[2], nums[1], nums[5], nums[3], nums[4]]
 * = [0,1,2,4,5,3]
 * 示例 2：
 * <p>
 * 输入：nums = [5,0,1,2,3,4]
 * 输出：[4,5,0,1,2,3]
 * 解释：数组 ans 构建如下：
 * ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
 * = [nums[5], nums[0], nums[1], nums[2], nums[3], nums[4]]
 * = [4,5,0,1,2,3]
 */
public class Solution1920 {
    public static void main(String[] args) {
        int[] nums = {0, 2, 1, 5, 3, 4};
        int[] ints = new Solution1920().buildArray(nums);
        System.out.println("ints = " + Arrays.toString(ints));
    }

    public int[] buildArray(int[] nums) {
        int[] rs = new int[nums.length];

        for (int i = 0; i < rs.length; i++) {
            rs[i] = nums[nums[i]];
        }

        return rs;
    }
}
