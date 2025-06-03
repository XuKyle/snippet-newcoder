package com.kylexu.leetcode.list;

import java.util.List;

/**
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4,4,4,4,5,6,7], k = 5
 * <p>
 * 输出：true
 * <p>
 * 解释：
 * <p>
 * 从下标 2 开始的子数组为 [7, 8, 9]，它是严格递增的。
 * 从下标 5 开始的子数组为 [2, 3, 4]，它也是严格递增的。
 * 两个子数组是相邻的，因此结果为 true。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4,4,4,4,5,6,7], k = 5
 * <p>
 * 输出：false
 */
public class Solution3349 {
    public static void main(String[] args) {
        List<Integer> nums = List.of(5, 8, -2, -1);
        int k = 2;

        boolean b = new Solution3349().hasIncreasingSubarrays(nums, k);
        System.out.println("b = " + b);
    }

    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        for (int i = 0; i <= nums.size() - 2 * k; i++) {
            List<Integer> left = nums.subList(i, i + k);
            List<Integer> right = nums.subList(i + k, i + 2 * k);
            if (increasing(left) && increasing(right)) {
                return true;
            }
        }

        return false;
    }

    private boolean increasing(List<Integer> nums) {
        if (nums.size() == 1) {
            return true;
        }

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) <= nums.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
}
