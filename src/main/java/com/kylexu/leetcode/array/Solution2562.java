package com.kylexu.leetcode.array;

public class Solution2562 {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 14, 13, 8, 12};
        long rs = new Solution2562().findTheArrayConcVal(nums);
        System.out.println("rs = " + rs);
    }

    public long findTheArrayConcVal(int[] nums) {
        long rs = 0;
        int n = nums.length;
        for (int i = 0; i < n / 2; i++) {
            rs += Integer.parseInt(nums[i] + "" + nums[n - i - 1]);
        }

        if (n % 2 != 0) {
            rs += nums[((n - 1) / 2)];
        }
        return rs;
    }
}
