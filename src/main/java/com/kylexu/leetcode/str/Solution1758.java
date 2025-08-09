package com.kylexu.leetcode.str;

public class Solution1758 {
    public static void main(String[] args) {
        String s = "1111";
        int i = new Solution1758().minOperations(s);
        System.out.println("i = " + i);
    }

    public int minOperations(String s) {
        int a = 0;
        int b = 0;

        char[] charArray = s.toCharArray();

//        01
        for (int i = 0; i < charArray.length; i++) {
            if (i % 2 == 0) {
                if (charArray[i] == '0') {
                    b++;
                } else {
                    a++;
                }
            }

            if (i % 2 == 1) {
                if (charArray[i] == '1') {
                    b++;
                } else {
                    a++;
                }
            }
        }

//        10

        return Math.min(a, b);
    }
}
