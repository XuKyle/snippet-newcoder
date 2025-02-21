package com.kylexu.leetcode.array;

import java.util.Arrays;

public class Solution2206 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(new Solution2206().divideArray(nums));
    }

    public boolean divideArray(int[] nums) {
        int n = nums.length;
        if (n % 2 != 0) {
            return false;
        }

        Arrays.sort(nums);

        for (int i = 0; i < n; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return false;
            }
        }

        return true;
    }
}
