package com.kylexu.leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution997 {
    public static void main(String[] args) {
        int n = 3;
        int[][] trust = {
                {1, 2}, {2, 3}
        };
        System.out.println(new Solution997().findJudge(n, trust));
    }

    public int findJudge(int n, int[][] trust) {
        if (n == 1 && trust.length == 0) {
            return 1;
        }

        Map<Integer, Set<Integer>> trusted = new HashMap<>();

        for (int[] ints : trust) {
            int person = ints[0];
            int trustedPerson = ints[1];
            trusted.computeIfAbsent(trustedPerson, k -> new HashSet<>()).add(person);
        }
        for (int[] ints : trust) {
            trusted.remove(ints[0]);
        }

        if (trusted.size() != 1) {
            return -1;
        }

        for (Map.Entry<Integer, Set<Integer>> entry : trusted.entrySet()) {
            if (entry.getValue().size() == n - 1) {
                return entry.getKey();
            }
        }

        return -1;
    }
}
