package com.kylexu.leetcode.binary;

public class Solution693 {
    public static void main(String[] args) {
        int n = 11;
        System.out.println(new Solution693().hasAlternatingBits(n));
    }

    public boolean hasAlternatingBits(int n) {
        String binaryString = Integer.toBinaryString(n);

        char last = ' ';
        char[] charArray = binaryString.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (i == 0) {
                last = c;
            } else {
                if (c == last) {
                    return false;
                } else {
                    last = c;
                }
            }
        }

        return true;
    }
}
