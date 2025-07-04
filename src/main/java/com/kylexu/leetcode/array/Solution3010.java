package com.kylexu.leetcode.array;

public class Solution3010 {
    public static void main(String[] args) {
        int[] nums = {10, 3, 1, 1};
        int i = new Solution3010().minimumCost(nums);
        System.out.println("i = " + i);
    }

    public int minimumCost(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min1) {
                min2 = min1;
                min1 = nums[i];
            } else if (nums[i] < min2) {
                min2 = nums[i];
            }
        }

        return nums[0] + min1 + min2;
    }
}
