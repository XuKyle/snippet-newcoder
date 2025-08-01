package com.kylexu.leetcode.array;

public class Solution2475 {
    public static void main(String[] args) {
        int[] nums = {4, 4, 2, 4, 3};
        int i = new Solution2475().unequalTriplets(nums);
        System.out.println("i = " + i);
    }

    public int unequalTriplets(int[] nums) {
        int rs = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    continue;
                }
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] == nums[k] || nums[j] == nums[k]) {
                        continue;
                    }
                    rs++;
                }
            }
        }

        return rs;
    }
}
