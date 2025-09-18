package com.kylexu.leetcode.array;

import java.util.Arrays;

public class Solution3674 {
    public static void main(String[] args) {
        int[] nums = {5, 5, 5};
        int i = new Solution3674().minOperations(nums);
        System.out.println("i = " + i);
    }

    public int minOperations(int[] nums) {
        long count = Arrays.stream(nums).distinct().count();
        return count == 1 ? 0 : 1;
    }
}
