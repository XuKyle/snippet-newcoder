package com.kylexu.leetcode.tree;

public class Solution2045 {
    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2, 3};
        int[] num2 = new int[]{2, 4};
        System.out.println(new Solution2045().getCommon(num1, num2));
    }

    public int getCommon(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return -1;
        }

        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length && nums1[i] != nums2[j]) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        if (i >= nums1.length || j >= nums2.length) {
            return -1;
        }

        return nums1[i];
    }
}
