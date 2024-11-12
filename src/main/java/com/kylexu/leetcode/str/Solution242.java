package com.kylexu.leetcode.str;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的
 * 字母异位词
 * 。
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 */
public class Solution242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> rs = new HashMap<>();
        for (char tmp : s.toCharArray()) {
            rs.merge(tmp, 1, Integer::sum);
        }

        for (char tmp : t.toCharArray()) {
            if (rs.containsKey(tmp)) {
                if (rs.get(tmp) > 0) {
                    rs.put(tmp, rs.get(tmp) - 1);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
