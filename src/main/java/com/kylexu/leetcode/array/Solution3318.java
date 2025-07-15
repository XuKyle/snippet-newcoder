package com.kylexu.leetcode.array;

import java.util.Arrays;

/**
 * 给你一个由 n 个整数组成的数组 nums，以及两个整数 k 和 x。
 * <p>
 * 数组的 x-sum 计算按照以下步骤进行：
 * <p>
 * 统计数组中所有元素的出现次数。
 * 仅保留出现次数最多的前 x 个元素的每次出现。如果两个元素的出现次数相同，则数值 较大 的元素被认为出现次数更多。
 * 计算结果数组的和。
 * 注意，如果数组中的不同元素少于 x 个，则其 x-sum 是数组的元素总和。
 * <p>
 * 返回一个长度为 n - k + 1 的整数数组 answer，其中 answer[i] 是 子数组 nums[i..i + k - 1] 的 x-sum。
 * <p>
 * 子数组 是数组内的一个连续 非空 的元素序列。
 */
public class Solution3318 {
    public static void main(String[] args) {
        // nums = [1,1,2,2,3,4,2,3], k = 6, x = 2
        int[] nums = {1, 1, 2, 2, 3, 4, 2, 3};
        int k = 6;
        int x = 2;
        int[] xSum = new Solution3318().findXSum(nums, k, x);
        System.out.println("xSum = " + Arrays.toString(xSum));
    }

    public int[] findXSum(int[] nums, int k, int x) {

        return new int[]{};
    }
}
