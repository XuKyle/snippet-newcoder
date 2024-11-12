package com.kylexu.basic;

public class IsPowerOf21 {
    public static void main(String[] args) {
        System.out.println(isPowerOf2(24));
        System.out.println(isPowerOf2(1024));
    }

    private static boolean isPowerOf2(int n) {
        int temp = 1;

        while (temp <= n) {
            if (n == temp) {
                return true;
            }
            temp <<= 1;
        }
        return false;
    }
}
