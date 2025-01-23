package com.kylexu.leetcode.str;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
 * <p>
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
 * <p>
 * 示例1:
 * <p>
 * 输入: pattern = "abba", s = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:pattern = "abba", s = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: pattern = "aaaa", s = "dog cat cat dog"
 * 输出: false
 */
public class Solution290 {
    public static void main(String[] args) {
        String pattern = "abc";
        String s = "dog cat dog";
        System.out.println(new Solution290().wordPattern(pattern, s));
    }

    public boolean wordPattern(String pattern, String s) {
        int n = pattern.length();
        Map<Character, String> mark = new HashMap<>();
        Map<String, Character> reversed = new HashMap<>();

        String[] split = s.split(" ");
        if (split.length != n) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            char c = pattern.charAt(i);

            if (reversed.containsKey(split[i]) && reversed.get(split[i]) != c) {
                return false;
            }

            if (mark.containsKey(c)) {
                if (!mark.get(c).equals(split[i])) {
                    return false;
                }
            } else {
                mark.put(c, split[i]);
                reversed.put(split[i], c);
            }
        }

        return true;
    }
}
