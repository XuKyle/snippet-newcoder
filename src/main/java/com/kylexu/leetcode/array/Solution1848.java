package com.kylexu.leetcode.array;

public class Solution1848 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 5, start = 3;
        int minDistance = new Solution1848().getMinDistance(nums, target, start);
        System.out.println("minDistance = " + minDistance);
    }

    public int getMinDistance(int[] nums, int target, int start) {
        int rs = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                rs = Math.min(rs, Math.abs(i - start));
            }
        }

        return rs;
    }
}
