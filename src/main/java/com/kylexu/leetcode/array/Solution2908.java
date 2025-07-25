package com.kylexu.leetcode.array;

public class Solution2908 {
    public static void main(String[] args) {
        int[] nums = {8, 6, 1, 5, 3};
        int i = new Solution2908().minimumSum(nums);
        System.out.println("i = " + i);
    }

    public int minimumSum(int[] nums) {
        int rs = Integer.MAX_VALUE;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] < nums[j] && nums[j] > nums[k]) {
                        rs = Math.min(rs, nums[i] + nums[j] + nums[k]);
                    }
                }
            }
        }

        return rs == Integer.MAX_VALUE ? -1 : rs;
    }
}
