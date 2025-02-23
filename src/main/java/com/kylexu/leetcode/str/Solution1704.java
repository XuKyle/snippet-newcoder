package com.kylexu.leetcode.str;

import java.util.Arrays;
import java.util.List;

public class Solution1704 {
    public static void main(String[] args) {
        String s = "textbook";
        System.out.println(new Solution1704().halvesAreAlike(s));
    }

    public boolean halvesAreAlike(String s) {
        int n = s.length();

        List<Character> list = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        int num = 0;
        for (int i = 0; i < n; i++) {
            if (list.contains(s.charAt(i))) {
                if (i < n / 2) {
                    num++;
                } else {
                    num--;
                }
            }
        }
        return num == 0;
    }
}