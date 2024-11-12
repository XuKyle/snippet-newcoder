package com.kylexu.basic;

public class GreatestCommonDivisor3 {
    public static void main(String[] args) {
        System.out.println(getGreatestCommonDivisor(25, 5));
        System.out.println(getGreatestCommonDivisor(100, 80));
    }

    private static int getGreatestCommonDivisor(int a, int b) {
        int big = Math.max(a, b);
        int small = Math.min(a, b);

        if (big == small) {
            return small;
        }

        return getGreatestCommonDivisor(big - small, small);
    }
}
