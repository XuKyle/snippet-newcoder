package com.kylexu.leetcode.array;

public class Solution2176 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        int k = 2;
        System.out.println(new Solution2176().countPairs(nums, k));
    }

    public int countPairs(int[] nums, int k) {
        int rs = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && i * j % k == 0) {
                    rs++;
                }
            }
        }
        return rs;
    }
}
