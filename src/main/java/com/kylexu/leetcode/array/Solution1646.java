package com.kylexu.leetcode.array;

import java.util.Arrays;

public class Solution1646 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(new Solution1646().getMaximumGenerated(n));
    }

    public int getMaximumGenerated(int n) {
        if (n <= 1) {
            return n;
        }

        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;

        int rs = 1;
        for (int i = 2; i < n + 1; i++) {
            if (i % 2 == 0) {
                nums[i] = nums[i / 2];
            } else {
                nums[i] = nums[i / 2] + nums[i / 2 + 1];
            }
            rs = Math.max(rs, nums[i]);
        }

        return rs;
    }
}
