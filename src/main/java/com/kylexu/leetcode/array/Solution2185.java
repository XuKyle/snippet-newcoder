package com.kylexu.leetcode.array;

/**
 * 给你一个字符串数组 words 和一个字符串 pref 。
 * 返回 words 中以 pref 作为 前缀 的字符串的数目。
 * 字符串 s 的 前缀 就是  s 的任一前导连续字符串。
 * 示例 1：
 * <p>
 * 输入：words = ["pay","attention","practice","attend"], pref = "at"
 * 输出：2
 * 解释：以 "at" 作为前缀的字符串有两个，分别是："attention" 和 "attend" 。
 * 示例 2：
 * <p>
 * 输入：words = ["leetcode","win","loops","success"], pref = "code"
 * 输出：0
 * 解释：不存在以 "code" 作为前缀的字符串。
 */
public class Solution2185 {
    public static void main(String[] args) {
        String[] words = new String[]{"pay", "attention", "practice", "attend"};
        String pref = "at";
        System.out.println(new Solution2185().prefixCount(words, pref));
    }

    public int prefixCount(String[] words, String pref) {
        int cnt = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                cnt++;
            }
        }
        return cnt;
    }
}
