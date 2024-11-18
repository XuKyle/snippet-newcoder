package com.kylexu.leetcode.array;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * <p>
 * 返回这三个数的和。
 * <p>
 * 假定每组输入只存在恰好一个解。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2)。
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 * 解释：与 target 最接近的和是 0（0 + 0 + 0 = 0）。
 */
public class Solution16 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, -4};
        System.out.println(new Solution16().threeSumClosest(nums, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int n = nums.length;
        int result = 0;
        int near = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1, k = n - 1; j < k; ) {
                int sum = nums[i] + nums[j] + nums[k];
                if (near > Math.abs(sum - target)) {
                    near = Math.abs(sum - target);
                    result = sum;
                }

                if (sum > target) {
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    return sum;
                }
            }
        }

        return result;
    }
}
