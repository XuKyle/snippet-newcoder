package com.kylexu.leetcode.array;

public class Solution2932 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int i = new Solution2932().maximumStrongPairXor(nums);
        System.out.println("i = " + i);
    }

    public int maximumStrongPairXor(int[] nums) {
        int n = nums.length;
        int rs = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (Math.abs(nums[i] - nums[j]) <= Math.min(nums[i], nums[j])) {
                    int temp = 0;
                    if (i != j) {
                        temp = nums[i] ^ nums[j];
                    }
                    rs = Math.max(rs, temp);
                }
            }
        }

        return rs;
    }
}
