package com.kylexu.leetcode.array;

import java.util.Arrays;

public class Solution2515 {
    public static void main(String[] args) {
        String[] words = {"hello", "i", "am", "leetcode", "hello"};
        String target = "hello";
        int startIndex = 1;
        int i = new Solution2515().closestTarget(words, target, startIndex);
        System.out.println("i = " + i);
    }

    public int closestTarget(String[] words, String target, int startIndex) {
        boolean found = false;
        for (String word : words) {
            if (target.equals(word)) {
                found = true;
                break;
            }
        }
        if (!found) {
            return -1;
        }

        int n = words.length;
        String[] adjust = new String[n];
        for (int i = startIndex; i < startIndex + n; i++) {
            adjust[i - startIndex] = words[i % n];
        }

        int left = -1;
        int right = -1;
        for (int i = 0; i < n; i++) {
            if (adjust[i].equals(target)) {
                left = i;
                break;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (adjust[i].equals(target)) {
                right = i;
                break;
            }
        }

        return Math.min(left, n - right);
    }
}
