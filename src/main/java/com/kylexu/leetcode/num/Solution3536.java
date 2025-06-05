package com.kylexu.leetcode.num;

import java.util.Arrays;

public class Solution3536 {
    public static void main(String[] args) {
        int n = 124;
        int i = new Solution3536().maxProduct(n);
        System.out.println("i = " + i);
    }

    public int maxProduct(int n) {
        int length = String.valueOf(n).length();
        int[] nums = new int[length];

        int i = 0;
        while (n != 0) {
            nums[i++] = n % 10;
            n = n / 10;
        }

        Arrays.sort(nums);

        return nums[length - 1] * nums[length - 2];
    }
}
