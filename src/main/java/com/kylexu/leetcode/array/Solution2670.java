package com.kylexu.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution2670 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int[] rs = new Solution2670().distinctDifferenceArray(nums);
        System.out.println("rs = " + Arrays.toString(rs));
    }

    public int[] distinctDifferenceArray(int[] nums) {
        int[] rs = new int[nums.length];

        for (int i = 0; i < rs.length; i++) {
            Set<Integer> left = new HashSet<>();
            Set<Integer> right = new HashSet<>();

            for (int j = 0; j <= i; j++) {
                left.add(nums[j]);
            }
            for (int j = i + 1; j < nums.length; j++) {
                right.add(nums[j]);
            }
            rs[i] = left.size() - right.size();
        }

        return rs;
    }
}
