package com.kylexu.leetcode.num;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1399 {
    public static void main(String[] args) {
        int n = 13;
        System.out.println(new Solution1399().countLargestGroup(n));
    }

    public int countLargestGroup(int n) {
        Map<Integer, List<Integer>> mark = new HashMap<>();
        int maxSize = 0;

        for (int i = 1; i <= n; i++) {
            int sum = sumDigit(i);
            mark.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
            maxSize = Math.max(maxSize, mark.get(sum).size());
        }

        int rs = 0;
        for (Map.Entry<Integer, List<Integer>> entry : mark.entrySet()) {
            if (entry.getValue().size() == maxSize) {
                rs++;
            }
        }

        return rs;
    }

    private int sumDigit(int n) {
        int rs = 0;
        while (n != 0) {
            rs += n % 10;
            n = n / 10;
        }
        return rs;
    }
}
