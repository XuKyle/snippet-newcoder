package com.kylexu.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1560 {
    public static void main(String[] args) {
        int n = 4;
        int[] rounds = {1, 3, 1, 2};
        List<Integer> integers = new Solution1560().mostVisited(n, rounds);
        System.out.println("integers = " + integers);
    }

    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> rs = new ArrayList<>();

        int[] circle = new int[n];
        for (int i = 0; i < rounds.length - 1; i++) {
            int currentStart = rounds[i] - 1;
            if (i != 0) {
                currentStart++;
            }
            int currentEnd = rounds[i + 1] - 1;

            if (currentEnd < currentStart) {
                currentEnd += n;
            }

            while (currentStart <= currentEnd) {
                circle[currentStart % (n)]++;
                currentStart++;
            }
        }

        int max = 0;
        for (int i : circle) {
            max = Math.max(i, max);
        }

        for (int i = 0; i < circle.length; i++) {
            if (circle[i] == max) {
                rs.add(i + 1);
            }
        }
        return rs;
    }
}
