package com.kylexu.leetcode.array;

import java.util.Arrays;

public class Solution1929 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2, 1};
        int[] rs = new Solution1929().getConcatenation(nums);
        System.out.println("rs = " + Arrays.toString(rs));
    }

    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] rs = new int[n * 2];

        for (int i = 0; i < rs.length; i++) {
            rs[i] = nums[i % n];
        }

        return rs;
    }
}
