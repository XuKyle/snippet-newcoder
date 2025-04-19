package com.kylexu.leetcode.array;

import java.util.*;

/**
 * 输入：items1 = [[1,1],[4,5],[3,8]], items2 = [[3,1],[1,5]]
 * 输出：[[1,6],[3,9],[4,5]]
 * 解释：
 */
public class Solution2436 {
    public static void main(String[] args) {
        int[][] item1 = {
                {1, 1},
                {4, 5},
                {3, 8}
        };
        int[][] item2 = {
                {3, 1},
                {1, 5}
        };
        List<List<Integer>> lists = new Solution2436().mergeSimilarItems(item1, item2);
        System.out.println("lists = " + lists);
    }

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> memo = new HashMap<>();
        for (int[] ints : items1) {
            memo.merge(ints[0], ints[1], Integer::sum);
        }
        for (int[] ints : items2) {
            memo.merge(ints[0], ints[1], Integer::sum);
        }

        return memo.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> List.of(entry.getKey(), entry.getValue()))
                .toList();
    }
}
