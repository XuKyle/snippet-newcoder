package com.kylexu.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;

public class Solution1751 {
    public static void main(String[] args) {
        int[][] events = {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}, {4, 4, 4}};
        int k = 3;
        int i = new Solution1751().maxValue(events, k);
        System.out.println("i = " + i);
    }

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[1]));
        int n = events.length;
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 0; i < n; i++) {
            int p = lowerBound(events, events[i][0]);
            for (int j = 1; j <= k; j++) {
                dp[i + 1][j] = Math.max(dp[i][j], dp[p][j - 1] + events[i][2]);
            }
        }

        return dp[n][k];
    }

    private int lowerBound(int[][] events, int target) {
        int left = 0, right = events.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (events[mid][1] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
