package com.kylexu.leetcode.str;

import java.util.HashMap;
import java.util.Map;

public class Solution1160 {
    public static void main(String[] args) {
        String[] words = new String[]{"hello", "world", "leetcode"};
        String chars = "welldonehoneyr";
        System.out.println(new Solution1160().countCharacters(words, chars));
    }

    public int countCharacters(String[] words, String chars) {
        int rs = 0;

        Map<Character, Integer> mark = new HashMap<>();
        for (char c : chars.toCharArray()) {
            mark.merge(c, 1, Integer::sum);
        }

        for (String word : words) {
            Map<Character, Integer> currentMark = new HashMap<>();
            for (char c : word.toCharArray()) {
                currentMark.merge(c, 1, Integer::sum);
            }

            boolean flag = true;
            for (Map.Entry<Character, Integer> entry : currentMark.entrySet()) {
                if (!mark.containsKey(entry.getKey()) || mark.get(entry.getKey()) < entry.getValue()) {
                    flag = false;
                }
            }

            if (flag) {
                rs += word.length();
            }
        }

        return rs;
    }
}
