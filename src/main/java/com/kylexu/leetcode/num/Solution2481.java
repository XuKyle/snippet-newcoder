package com.kylexu.leetcode.num;

public class Solution2481 {
    public static void main(String[] args) {
        int n = 10;
        int i = new Solution2481().numberOfCuts(n);
        System.out.println("i = " + i);
    }

    public int numberOfCuts(int n) {
        if (n == 1) {
            return 0;
        }
        if (n % 2 == 0) {
            return n / 2;
        }

        return n;
    }
}
