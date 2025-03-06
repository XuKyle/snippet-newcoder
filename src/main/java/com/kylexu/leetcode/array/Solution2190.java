package com.kylexu.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class Solution2190 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 100, 200, 1, 100};
        int key = 1;
        System.out.println(new Solution2190().mostFrequent(nums, key));
    }

    public int mostFrequent(int[] nums, int key) {
        int n = nums.length;
        Map<Integer, Integer> mark = new HashMap<>();
        int max = 0;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == key) {
                mark.merge(nums[i + 1], 1, Integer::sum);

                max = Math.max(max, mark.get(nums[i + 1]));
            }
        }

        for (Map.Entry<Integer, Integer> entry : mark.entrySet()) {
            if (entry.getValue() == max) {
                return entry.getKey();
            }
        }

        return -1;
    }
}
