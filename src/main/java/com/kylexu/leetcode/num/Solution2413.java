package com.kylexu.leetcode.num;

public class Solution2413 {
    public static void main(String[] args) {
        System.out.println(new Solution2413().smallestEvenMultiple(6));
    }

    public int smallestEvenMultiple(int n) {
        return n % 2 == 0 ? n : 2 * n;
    }
}
