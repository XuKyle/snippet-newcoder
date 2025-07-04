package com.kylexu.leetcode.array;

import java.util.Arrays;

public class Solution307 {
    public static void main(String[] args) {
        int k = 10;
        int[] operations = {0, 1, 0, 1};
        char c = new Solution307().kthCharacter(k, operations);
        System.out.println("c = " + c);
    }

    public char kthCharacter(long k, int[] operations) {

        int res = 0;
        for (int i = 63 - Long.numberOfLeadingZeros(k - 1); i >= 0; i--) {
            if (k > 1L << i) {
                res += operations[i];
                k -= 1L << i;
            }
        }
        return (char) ('a' + res % 26);

//        int size = (int) Math.pow(2, operations.length);
//        char[] rs = new char[size];
//        rs[0] = 'a';
//
//        int length = 1;
//        for (int i = 0; i < operations.length; i++) {
//            int operation = operations[i];
//            for (int j = 0; j < length; j++) {
//                if (operation == 0) {
//                    rs[j + length] = rs[j];
//                } else {
//                    rs[j + length] = (char) (rs[j] + 1);
//                }
//            }
//            length = length * 2;
//        }
//
//        return rs[(int) k - 1];
    }
}
