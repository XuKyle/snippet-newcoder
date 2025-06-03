package com.kylexu.leetcode.num;

public class Solution3560 {
    public static void main(String[] args) {
        int n = 6, m = 5, k = 5;
        long l = new Solution3560().minCuttingCost(n, m, k);
        System.out.println("l = " + l);
    }

    public long minCuttingCost(int n, int m, int k) {
        return cutCost(n, k) + cutCost(m, k);
    }

    private long cutCost(int m, int k) {
        if (m < k) {
            return 0;
        }

        return 0;
    }
}
