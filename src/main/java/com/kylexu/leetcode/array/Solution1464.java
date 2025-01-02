package com.kylexu.leetcode.array;

public class Solution1464 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 5, 2};
        System.out.println(new Solution1464().maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        int rs = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int temp = (nums[i] - 1) * (nums[j] - 1);
                if (temp > rs) {
                    rs = temp;
                }
            }
        }

        return rs;
    }
}
