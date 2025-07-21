package com.kylexu.leetcode.array;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution274 {
    public static void main(String[] args) {
        int[] citations = {100};
        int i = new Solution274().hIndex(citations);
        System.out.println("i = " + i);
    }

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        Map<Integer, Integer> counter = new HashMap<>();
        int n = citations.length;
        for (int i = 0; i < citations.length; i++) {
            int citation = citations[i];
            if (counter.containsKey(citation)) {
                continue;
            }
            counter.put(citation, n - i);
        }
//        System.out.println("counter = " + counter);

        int rs = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            rs = Math.max(rs, Math.min(entry.getKey(), entry.getValue()));
        }
        return rs;
    }
}
