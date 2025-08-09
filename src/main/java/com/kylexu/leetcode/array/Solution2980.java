package com.kylexu.leetcode.array;

public class Solution2980 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        boolean b = new Solution2980().hasTrailingZeros(nums);
        System.out.println("b = " + b);
    }

    public boolean hasTrailingZeros(int[] nums) {
        int rs = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                rs++;
            }
        }

        return rs >= 2;
    }
}
