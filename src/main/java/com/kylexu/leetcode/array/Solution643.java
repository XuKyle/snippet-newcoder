package com.kylexu.leetcode.array;

public class Solution643 {
    public static void main(String[] args) {
//        int[] nums = new int[]{1, 12, -5, -6, 50, 3};
        int[] nums = new int[]{5};
        int k = 1;
        System.out.println(new Solution643().findMaxAverage(nums, k));
    }


    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;

        int left = 0;
        int right = k;

        int acc = 0;
        int max = 0;

        for (int i = 0; i < k; i++) {
            max += nums[i];
            acc += nums[i];
        }

        while (right < n) {
            acc = acc - nums[left] + nums[right];
            max = Math.max(max, acc);
            right++;
            left++;
        }

        return max * 1.0 / k;
    }
}
