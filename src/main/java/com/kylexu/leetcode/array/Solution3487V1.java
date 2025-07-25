package com.kylexu.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution3487V1 {
    public static void main(String[] args) {
        int[] nums = {-100};
        int i = new Solution3487V1().maxSum(nums);
        System.out.println("i = " + i);
    }

    public int maxSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (nums[n - 1] <= 0) {
            return nums[n - 1];
        }

        int rs = 0;
        Set<Integer> holder = new HashSet<>();

        for (int num : nums) {
            if (holder.contains(num)) {
                continue;
            }

            if (num <= 0) {
                continue;
            }
            rs += num;
            holder.add(num);
        }

        return rs;
    }
}
