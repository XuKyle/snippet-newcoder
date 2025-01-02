package com.kylexu.leetcode.array;

import java.util.*;

/**
 * 输入：nums = [4,3,10,9,8]
 * 输出：[10,9]
 * 解释：子序列 [10,9] 和 [10,8] 是最小的、满足元素之和大于其他各元素之和的子序列。但是 [10,9] 的元素之和最大。
 */
public class Solution1403 {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 4, 7, 6, 7};
        List<Integer> rs = new Solution1403().minSubsequence(nums);
        System.out.println("rs = " + rs);
    }

    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        List<Integer> rs = new ArrayList<>();
        int tempSum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (tempSum <= sum / 2) {
                rs.add(nums[i]);
            }
            tempSum += nums[i];
        }

        return rs;
    }
}
