package com.kylexu.leetcode.array;

public class Solution3162 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 4, 12};
        int[] nums2 = {2, 4};
        int k = 3;

//        如果 nums1[i] 可以除尽 nums2[j] * k，则称数对 (i, j) 为 优质数对（0 <= i <= n - 1, 0 <= j <= m - 1）。
//
//        返回 优质数对 的总数。
        int i = new Solution3162().numberOfPairs(nums1, nums2, k);
        System.out.println("i = " + i);
    }

    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int rs = 0;

        for (int a : nums1) {
            for (int b : nums2) {
                if (a % (b * k) == 0) {
                    rs++;
                }
            }
        }

        return rs;
    }
}
