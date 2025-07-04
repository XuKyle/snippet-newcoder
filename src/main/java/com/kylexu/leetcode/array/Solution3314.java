package com.kylexu.leetcode.array;

import java.util.Arrays;
import java.util.List;

public class Solution3314 {
    public static void main(String[] args) {
        List<Integer> nums = List.of(2, 3, 5, 7);
        int[] rs = new Solution3314().minBitwiseArray(nums);
        System.out.println("rs = " + Arrays.toString(rs));
    }

    public int[] minBitwiseArray(List<Integer> nums) {
        int[] rs = new int[nums.size()];

        for (int i = 0; i < nums.size(); i++) {
            Integer target = nums.get(i);

            for (int j = 1; j < target; j++) {
                int t = j | (j + 1);
                if (t == target) {
                    rs[i] = j;
                    break;
                }
                if (j == target - 1) {
                    rs[i] = -1;
                }
            }
        }

        return rs;
    }
}
