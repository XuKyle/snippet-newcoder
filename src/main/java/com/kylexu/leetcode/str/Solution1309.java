package com.kylexu.leetcode.str;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为一些小写英文字符：
 * 字符（'a' - 'i'）分别用（'1' - '9'）表示。
 * 字符（'j' - 'z'）分别用（'10#' - '26#'）表示。
 * 返回映射之后形成的新字符串。
 * <p>
 * 题目数据保证映射始终唯一。
 * 示例 1：
 * 输入：s = "10#11#12"
 * 输出："jkab"
 * 解释："j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
 * 示例 2：
 * <p>
 * 输入：s = "1326#"
 * 输出："acz"
 */
public class Solution1309 {
    private static Map<String, Character> mp = new HashMap<>();

    static {
        for (int i = 0; i < 26; i++) {
            if (i < 9) {
                mp.put(String.valueOf(i + 1), (char) ('a' + i));
            } else {
                mp.put((i + 1) + "#", (char) ('a' + i));
            }
        }
    }

    public static void main(String[] args) {
        String s = "10#11#12";
        System.out.println(new Solution1309().freqAlphabets(s));
    }

    public String freqAlphabets(String s) {
        int n = s.length();
        int start = n - 1;
        int end = n;

        StringBuilder rs = new StringBuilder();
        while (start >= 0) {
            if (s.charAt(start) == '#') {
                start = Math.max(0, start - 2);
            }
            String substring = s.substring(start, end);
            rs.append(mp.get(substring));

            end = start;
            start--;
        }

        return rs.reverse().toString();
    }
}
