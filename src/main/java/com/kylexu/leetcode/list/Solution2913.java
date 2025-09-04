package com.kylexu.leetcode.list;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2913 {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 1);
        int i = new Solution2913().sumCounts(nums);
        System.out.println("i = " + i);
    }

    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        final int MOD = (int) 1e9 + 7;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int j = i; j < n; j++) {
                map.merge(nums.get(j), 1, Integer::sum);
                sum += map.size()*map.size();
                sum %= MOD;
            }
        }

        return (int) sum;
    }
}
