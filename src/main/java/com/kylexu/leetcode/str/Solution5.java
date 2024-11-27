package com.kylexu.leetcode.str;

/**
 * 给你一个字符串 s，找到 s 中最长的
 * 回文*
 * 子串
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 */
public class Solution5 {
    public String longestPalindrome(String s) {
        int maxLength = 0;
        int n = s.length();
        int maxStart = 0;

        for (int i = 0; i < n; i++) {
            int left = i;
            int right = i;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > maxLength) {
                    maxStart = left;
                    maxLength = right - left + 1;
                }
                left--;
                right++;
            }

            left = i;
            right = i + 1;

            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > maxLength) {
                    maxStart = left;
                    maxLength = right - left + 1;
                }
                left--;
                right++;
            }
        }

        return s.substring(maxStart, maxStart + maxLength);
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(new Solution5().longestPalindrome(s));
    }
}
