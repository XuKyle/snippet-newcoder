package com.kylexu.leetcode.slide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的
 * 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * 示例 2:
 * <p>
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 */
public class Solution438 {
    public static void main(String[] args) {
        System.out.println(new Solution438().findAnagrams("cbaebabacd", "abc"));
        System.out.println(new Solution438().findAnagrams("abab", "ab"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();

        if (pLength > sLength) {
            return List.of();
        }

        List<Integer> rs = new ArrayList<>();

        int[] sArray = new int[26];
        int[] pArray = new int[26];
        for (int i = 0; i < pLength; i++) {
            sArray[s.charAt(i) - 'a']++;
            pArray[p.charAt(i) - 'a']++;
        }

        if (Arrays.equals(sArray, pArray)) {
            rs.add(0);
        }

        for (int i = 0; i < sLength - pLength; i++) {
            sArray[s.charAt(i) - 'a']--;
            sArray[s.charAt(i + pLength) - 'a']++;

            if (Arrays.equals(sArray, pArray)) {
                rs.add(i + 1);
            }
        }

        return rs;
    }
}
