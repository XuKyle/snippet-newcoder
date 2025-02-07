package com.kylexu.leetcode.array;

public class Solution3427 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 1, 2};
        System.out.println(new Solution3427().subarraySum(nums));
    }

    public int subarraySum(int[] nums) {
        int n = nums.length;

        int rs = 0;
        for (int i = 0; i < n; i++) {
            int start = Math.max(0, i - nums[i]);
            for (int j = start; j <= i; j++) {
                rs += nums[j];
            }
        }
        return rs;
    }
}
