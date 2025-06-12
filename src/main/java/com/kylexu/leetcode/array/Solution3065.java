package com.kylexu.leetcode.array;

public class Solution3065 {
    public static void main(String[] args) {
        int[] nums = {2, 11, 10, 1, 3};
        int k = 10;
        int rs = new Solution3065().minOperations(nums, k);
        System.out.println("rs = " + rs);
    }

    public int minOperations(int[] nums, int k) {
        int cnt = 0;
        for (int num : nums) {
            if (num < k) {
                cnt++;
            }
        }
        return cnt;
    }
}
