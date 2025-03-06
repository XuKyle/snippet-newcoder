package com.kylexu.leetcode.array;

import java.util.*;

public class Solution2248 {
    public static void main(String[] args) {
//        int[][] nums = new int[][]{
//                {3, 1, 2, 4, 5},
//                {1, 2, 3, 4},
//                {3, 4, 5, 6},
//        };

        int[][] nums = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
        };

        List<Integer> rs = new Solution2248().intersection(nums);
        System.out.println("rs = " + rs);
    }

    public List<Integer> intersection(int[][] nums) {
        List<Integer> rs = new ArrayList<>();

        Map<Integer, Integer> mark = new HashMap<>();
        for (int[] num : nums) {
            for (int i : num) {
                mark.merge(i, 1, Integer::sum);
            }
        }

        for (Map.Entry<Integer, Integer> entry : mark.entrySet()) {
            if (entry.getValue() == nums.length) {
                rs.add(entry.getKey());
            }
        }

        return rs.stream().sorted().toList();
    }
}
