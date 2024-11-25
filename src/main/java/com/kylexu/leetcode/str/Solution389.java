package com.kylexu.leetcode.str;

/**
 * 给定两个字符串 s 和 t ，它们只包含小写字母。
 * <p>
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * <p>
 * 请找出在 t 中被添加的字母。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * 示例 2：
 * <p>
 * 输入：s = "", t = "y"
 * 输出："y"
 */
public class Solution389 {
    public static void main(String[] args) {
        String word1 = "abcd";
        String word2 = "abcde";
        System.out.println(new Solution389().findTheDifference(word1, word2));
    }

    public char findTheDifference(String s, String t) {
        int[] target = new int[26];
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            target[index]++;
        }

        for (char c : t.toCharArray()) {
            target[c - 'a']--;
            if (target[c - 'a'] < 0) {
                return c;
            }
        }

        return 'a';
    }
}
