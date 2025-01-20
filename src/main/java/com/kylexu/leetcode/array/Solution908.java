package com.kylexu.leetcode.array;

public class Solution908 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 6};
        int k = 3;
        System.out.println(new Solution908().smallestRangeI(nums, k));
    }

    public int smallestRangeI(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        if (max - min >= 2 * k) {
            return max - min - 2 * k;
        }

        return 0;
    }
}
