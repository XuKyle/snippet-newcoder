package com.kylexu.leetcode.matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2432 {
    public static void main(String[] args) {
        int n = 10;
        int[][] logs = {
                {0, 3},
                {2, 5},
                {0, 9},
                {1, 15},
        };
        System.out.println(new Solution2432().hardestWorker(n, logs));
    }

    public int hardestWorker(int n, int[][] logs) {

        if (logs.length == 0) {
            return 0;
        }

        Map<Integer, List<Integer>> mark = new HashMap<>();
        int maxCost = Integer.MIN_VALUE;
        for (int i = 0; i < logs.length; i++) {
            int[] log = logs[i];
            int id = log[0];
            int start = i == 0 ? 0 : logs[i - 1][1];
            int end = log[1];
            maxCost = Math.max(maxCost, end - start);
            mark.computeIfAbsent(end - start, k -> new ArrayList<>()).add(id);
        }

        int rs = Integer.MAX_VALUE;
        List<Integer> list = mark.get(maxCost);
        for (Integer integer : list) {
            rs = Math.min(rs, integer);
        }

        return rs;
    }
}
