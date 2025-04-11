package com.kylexu.leetcode.num;

public class Solution190 {
    public static void main(String[] args) {
        int n = 43261596;
        int i = new Solution190().reverseBits(n);
        System.out.println("i = " + i);
    }

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        String binaryString = Integer.toBinaryString(n);
        while (binaryString.length() != 32) {
            binaryString = '0' + binaryString;
        }

        String reversed = new StringBuilder(binaryString).reverse().toString();
        return (int) Long.parseLong(reversed, 2);
    }
}
