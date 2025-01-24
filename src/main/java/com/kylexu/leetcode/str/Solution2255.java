package com.kylexu.leetcode.str;

/**
 * 示例 1：
 * 输入：words = ["a","b","c","ab","bc","abc"], s = "abc"
 * 输出：3
 * 解释：
 * words 中是 s = "abc" 前缀的字符串为：
 * "a" ，"ab" 和 "abc" 。
 * 所以 words 中是字符串 s 前缀的字符串数目为 3 。
 * 示例 2：
 * <p>
 * 输入：words = ["a","a"], s = "aa"
 * 输出：2
 * 解释：
 * 两个字符串都是 s 的前缀。
 * 注意，相同的字符串可能在 words 中出现多次，它们应该被计数多次。
 */
public class Solution2255 {
    public static void main(String[] args) {
        String[] words = new String[]{"feh","w","w","lwd","c","s","vk","zwlv","n","w","sw","qrd","w","w","mqe","w","w","w","gb","w","qy","xs","br","w","rypg","wh","g","w","w","fh","w","w","sccy"};
        String s = "w";
        System.out.println(new Solution2255().countPrefixes(words, s));
    }

    public int countPrefixes(String[] words, String s) {
        int rs = 0;
        for (String word : words) {
            if (s.startsWith(word)) {
                rs++;
            }
        }

        return rs;
    }
}
