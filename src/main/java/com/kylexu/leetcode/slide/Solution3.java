package com.kylexu.leetcode.slide;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串
 * 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Solution3 {
    public static void main(String[] args) {
        System.out.println(new Solution3().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution3().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Solution3().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new Solution3().lengthOfLongestSubstring("au"));
    }


    public int lengthOfLongestSubstring(String s) {
        Set<Character> sets = new HashSet<>();
        int rs = 0;

        for (int left = 0, right = 0; right < s.length(); right++) {
            char current = s.charAt(right);
            while (sets.contains(current)) {
                sets.remove(s.charAt(left));
                left++;
            }

            sets.add(current);
            rs = Math.max(rs, right - left + 1);
        }

        return rs;
    }
}
