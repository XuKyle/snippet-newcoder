package com.kylexu.leetcode.str;

/**
 * 给你一个字符串 s，请你返回 两个相同字符之间的最长子字符串的长度 ，计算长度时不含这两个字符。如果不存在这样的子字符串，返回 -1 。
 * <p>
 * 子字符串 是字符串中的一个连续字符序列。
 * 示例 1：
 * <p>
 * 输入：s = "aa"
 * 输出：0
 * 解释：最优的子字符串是两个 'a' 之间的空子字符串。
 * 示例 2：
 * <p>
 * 输入：s = "abca"
 * 输出：2
 * 解释：最优的子字符串是 "bc" 。
 * 示例 3：
 * <p>
 * 输入：s = "cbzxy"
 * 输出：-1
 * 解释：s 中不存在出现出现两次的字符，所以返回 -1 。
 */
public class Solution1624 {
    public static void main(String[] args) {
        String s = "cbzxy";
        System.out.println(new Solution1624().maxLengthBetweenEqualCharacters(s));
    }

    public int maxLengthBetweenEqualCharacters(String s) {
        int n = s.length();
        int rs = -1;

        int left = 0;
        while (left < n) {
            int right = n - 1;
            while (left < right && s.charAt(left) != s.charAt(right)) {
                right--;
            }
            if (s.charAt(left) == s.charAt(right)) {
                rs = Math.max(rs, right - left - 1);
            }
            left++;
        }

        return rs;
    }
}
