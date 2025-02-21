package com.kylexu.leetcode.str;

/**
 * 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 * 示例 2:
 * <p>
 * 输入： s = "Mr Ding"
 * 输出："rM gniD"
 */
public class Solution557 {
    public static void main(String[] args) {
        String s = "Mr Ding";
        System.out.println(new Solution557().reverseWords(s));
    }

    public String reverseWords(String s) {
        StringBuilder rs = new StringBuilder();
        String[] split = s.split("\\s+");

        for (int i = 0; i < split.length; i++) {
            String word = split[i];
            rs.append(new StringBuilder(word).reverse());
            if (i != split.length - 1) {
                rs.append(" ");
            }
        }

        return rs.toString();
    }
}
