package com.kylexu.leetcode.num;

public class Solution3658 {
    public static void main(String[] args) {
        int n = 4;
        int i = new Solution3658().gcdOfOddEvenSums(n);
        System.out.println("i = " + i);
    }

    public int gcdOfOddEvenSums(int n) {
        int odd = 0;
        int even = 0;
        for (int i = 1; i <= 2 * n; i++) {
            if (i % 2 == 0) {
                even += i;
            } else {
                odd += i;
            }
        }

        return gcd(even, odd);
    }

    private int gcd(int even, int odd) {
        if (odd == 0) {
            return even;
        }
        return gcd(odd, even % odd);
    }
}
