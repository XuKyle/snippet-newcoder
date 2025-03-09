package com.kylexu.leetcode.array;

import java.util.Arrays;


public class Solution1389 {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int[] index = new int[]{0};
        int[] targetArray = new Solution1389().createTargetArray(nums, index);
        System.out.println("targetArray = " + Arrays.toString(targetArray));
    }

    public int[] createTargetArray(int[] nums, int[] index) {
        int n = nums.length;
        int[] rs = new int[n];
        Arrays.fill(rs, -1);

        for (int i = 0; i < n; i++) {
            int currentIndex = index[i];

            if (rs[currentIndex] != -1) {
                System.arraycopy(rs, currentIndex, rs, currentIndex + 1, n - currentIndex - 1);
            }
            rs[currentIndex] = nums[i];
        }

        return rs;
    }
}
