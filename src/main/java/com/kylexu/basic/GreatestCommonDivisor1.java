package com.kylexu.basic;

public class GreatestCommonDivisor1 {
    public static void main(String[] args) {
        System.out.println(getGreatestCommonDivisor(25,5));
        System.out.println(getGreatestCommonDivisor(100,80));
    }

    private static int getGreatestCommonDivisor(int a, int b) {
        int big = Math.max(a, b);
        int small = Math.min(a, b);

        int common = 1;

        for (int i = 1; i <= small; i++) {
            if (big%i == 0&& small%i ==0) {
                common=i;
            }
        }

        return common;
    }
}
