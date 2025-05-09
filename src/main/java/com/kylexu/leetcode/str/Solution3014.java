package com.kylexu.leetcode.str;

public class Solution3014 {
    public static void main(String[] args) {
        String word = "xycdefghij";
        int i = new Solution3014().minimumPushes(word);
        System.out.println("i = " + i);
    }

    public int minimumPushes(String word) {
        int n = word.length();
        int rs = 0;

        if (n <= 8) {
            return n;
        }
        if (n <= 16) {
            return 8 + (n - 8) * 2;
        }
        if (n <= 24) {
            return 8 + 16 + (n - 16) * 3;
        }

        return 8 + 16 + 24 + (n - 24) * 4;
    }
}
