package com.kylexu.leetcode.num;

import java.util.Arrays;

public class Solution1304 {
    public static void main(String[] args) {
        int n = 5;
        int[] ints = new Solution1304().sumZero(n);
        System.out.println(Arrays.toString(ints));
    }

    public int[] sumZero(int n) {
        int[] rs = new int[n];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (i != n - 1) {
                rs[i] = i + 1;
                sum += i + 1;
            } else {
                rs[i] = -1 * sum;
            }
        }

        return rs;
    }
}
