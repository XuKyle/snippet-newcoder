package com.kylexu.leetcode.num;

public class Solution7 {
    public static void main(String[] args) {
        int x = -123;
        int reverse = new Solution7().reverse(x);
        System.out.println("reverse = " + reverse);
    }

    public int reverse(int x) {
        boolean flag = x < 0;
        x = Math.abs(x);
        long rs = 0;

        while (x > 0) {
            rs = rs * 10 + x % 10;
            x = x / 10;
        }

        if (flag) {
            rs = rs * -1;
        }

        if (rs > Integer.MAX_VALUE || rs < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) rs;
    }
}
