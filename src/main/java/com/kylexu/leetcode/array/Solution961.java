package com.kylexu.leetcode.array;

import java.util.Arrays;

public class Solution961 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 2, 5, 3, 2};
        System.out.println(new Solution961().repeatedNTimes(nums));
    }

    public int repeatedNTimes(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;

        int mid = n / 2 - 1;

        if (nums[mid] == nums[mid + 1]) {
            return nums[mid];
        }

        if (nums[0] == nums[mid]) {
            return nums[0];
        }

        return nums[n - 1];
    }
}
