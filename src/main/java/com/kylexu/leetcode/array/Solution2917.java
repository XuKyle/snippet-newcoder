package com.kylexu.leetcode.array;

import java.util.Arrays;

public class Solution2917 {
    public static void main(String[] args) {
        int[] nums = {10, 8, 5, 9, 11, 6, 8};
        int k = 1;
        int kOr = new Solution2917().findKOr(nums, k);
        System.out.println("kOr = " + kOr);
    }

    public int findKOr(int[] nums, int k) {
        int n = 0;
        for (int num : nums) {
            n = Math.max(n, Integer.toBinaryString(num).length());
        }

        int[] mark = new int[n];
        for (int num : nums) {
            String binaryString = Integer.toBinaryString(num);
            for (int i = binaryString.length() - 1, j = 0; i >= 0; i--, j++) {
                if (binaryString.charAt(i) == '1') {
                    mark[n - 1 - j] += 1;
                }
            }
        }

        int rs = 0;
        for (int j : mark) {
            if (j >= k) {
                rs = rs * 2 + 1;
            } else {
                rs = rs * 2;
            }
        }
        return rs;
    }
}
