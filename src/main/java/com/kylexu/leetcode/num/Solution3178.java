package com.kylexu.leetcode.num;

import java.util.Arrays;

/**
 * 输入：n = 3, k = 5
 * <p>
 * 输出：1
 */
public class Solution3178 {
    public static void main(String[] args) {
        int n = 3;
        int k = 5;
        System.out.println(new Solution3178().numberOfChild(n, k));
    }

    public int numberOfChild(int n, int k) {
        int current = 0;
        boolean forward = true;
        for (int i = 1; i <= k; i++) {
            if (forward) {
                if (current == n - 1) {
                    forward = false;
                    current--;
                } else {
                    current++;
                }
            } else {
                if (current == 0) {
                    forward = true;
                    current++;
                } else {
                    current--;
                }
            }
        }

        return current;
    }
}
