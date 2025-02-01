package com.kylexu.leetcode.str;

import java.util.HashMap;
import java.util.Map;

public class Solution409 {
    public static void main(String[] args) {
        String s = "a";
        System.out.println(new Solution409().longestPalindrome(s));
    }

    public int longestPalindrome(String s) {
        Map<Character, Integer> memo = new HashMap<>();
        for (char c : s.toCharArray()) {
            memo.merge(c, 1, Integer::sum);
        }


        boolean flag = false;
        int pairCount = 0;
        for (Map.Entry<Character, Integer> entry : memo.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                flag = true;
            }

            int cnt = entry.getValue() / 2;
            pairCount += cnt;
        }

        if (flag) {
            return pairCount * 2 + 1;
        } else {
            return pairCount * 2;
        }
    }
}
