package com.kylexu.leetcode.array;

/**
 * 给你一个字符串数组 words ，找出并返回数组中的 第一个回文字符串 。如果不存在满足要求的字符串，返回一个 空字符串 "" 。
 * <p>
 * 回文字符串 的定义为：如果一个字符串正着读和反着读一样，那么该字符串就是一个 回文字符串 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["abc","car","ada","racecar","cool"]
 * 输出："ada"
 * 解释：第一个回文字符串是 "ada" 。
 * 注意，"racecar" 也是回文字符串，但它不是第一个。
 * 示例 2：
 * <p>
 * 输入：words = ["notapalindrome","racecar"]
 * 输出："racecar"
 * 解释：第一个也是唯一一个回文字符串是 "racecar" 。
 * 示例 3：
 * <p>
 * 输入：words = ["def","ghi"]
 * 输出：""
 * 解释：不存在回文字符串，所以返回一个空字符串。
 */
public class Solution2108 {
    public static void main(String[] args) {
        String[] words = new String[]{"def", "ghi"};
        System.out.println(new Solution2108().firstPalindrome(words));
    }

    public String firstPalindrome(String[] words) {
        for (String word : words) {
            if (new StringBuilder(word).reverse().toString().equals(word)) {
                return word;
            }
        }
        return "";
    }
}
