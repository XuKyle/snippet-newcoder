package com.kylexu.leetcode.str;

import java.util.HashMap;
import java.util.Map;

public class Solution2287 {
    public static void main(String[] args) {
        String s = "abcba";
        String target = "abc";
        System.out.println(new Solution2287().rearrangeCharacters(s, target));
    }

    public int rearrangeCharacters(String s, String target) {
        Map<Character, Integer> counter = new HashMap<>();
        for (char c : target.toCharArray()) {
            counter.merge(c, 1, Integer::sum);
        }

        Map<Character, Integer> candidate = new HashMap<>();
        for (char c : s.toCharArray()) {
            candidate.merge(c, 1, Integer::sum);
        }

        int rs = Integer.MAX_VALUE;

        for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();

            Integer candidateOrDefault = candidate.getOrDefault(key, 0);

            rs = Math.min(candidateOrDefault / value, rs);
        }

        return rs;
    }
}
