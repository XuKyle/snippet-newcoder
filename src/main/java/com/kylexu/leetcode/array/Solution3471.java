package com.kylexu.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 输入：nums = [3,9,2,1,7], k = 3
 */
public class Solution3471 {
    public static void main(String[] args) {
        int[] nums = {0, 50};
        int k = 1;
        int i = new Solution3471().largestInteger(nums, k);
        System.out.println("i = " + i);
    }

    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }

        Map<Integer, List<List<Integer>>> mock = new HashMap<>();

        for (int num : nums) {
            if (mock.containsKey(num)) {
                continue;
            }
            for (int i = 0; i < numList.size(); i++) {
                for (int j = i; j < n && j + k <= n; j += k) {
                    if (numList.subList(j, j + k).contains(num)) {
                        mock.computeIfAbsent(num, o -> new ArrayList<>()).add(numList.subList(j, j + k));
                    }
                }
            }
        }

        int max = Integer.MIN_VALUE;
        boolean find = false;

        for (Map.Entry<Integer, List<List<Integer>>> entry : mock.entrySet()) {
            if (entry.getValue().size() == 1) {
                find = true;
                max = Math.max(max, entry.getKey());
            }
        }
        if (!find) {
            return -1;
        }
        return max;
    }
}
