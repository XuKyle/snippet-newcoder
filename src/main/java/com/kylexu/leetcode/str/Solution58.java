package com.kylexu.leetcode.str;

public class Solution58 {
    public static void main(String[] args) {
        System.out.println(new Solution58().lengthOfLastWord("Hello World"));
        System.out.println(new Solution58().lengthOfLastWord("   fly me   to   the moon  "));
    }

    public int lengthOfLastWord(String s) {
        s = s.trim();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                return s.length() - i - 1;
            }
        }
        return s.length();
    }
}
