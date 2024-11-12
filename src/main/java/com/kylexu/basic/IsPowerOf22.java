package com.kylexu.basic;

public class IsPowerOf22 {
    public static void main(String[] args) {
        System.out.println(isPowerOf2(24));
        System.out.println(isPowerOf2(1024));
    }

    private static boolean isPowerOf2(int n) {
        return (n & (n - 1)) == 0;
    }
}
