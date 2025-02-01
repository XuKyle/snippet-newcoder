package com.kylexu.leetcode.str;

import java.util.HashMap;
import java.util.Map;

public class Solution1189 {
    public static void main(String[] args) {
        String text = "loonbalxballpoon";
        System.out.println(new Solution1189().maxNumberOfBalloons(text));
    }

    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> counter = new HashMap<>();

        for (char c : text.toCharArray()) {
            counter.merge(c, 1, Integer::sum);
        }

        int rs = Integer.MAX_VALUE;
        for (char c : "balloon".toCharArray()) {
            if ('l' == c || 'o' == c) {
                rs = Math.min(counter.getOrDefault(c, 0) / 2, rs);
            } else {
                rs = Math.min(counter.getOrDefault(c, 0), rs);
            }
        }

        return rs;
    }
}
