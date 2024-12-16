package com.kylexu.leetcode.str;

/**
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 * <p>
 * 全部字母都是大写，比如 "USA" 。
 * 单词中所有字母都不是大写，比如 "leetcode" 。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google" 。
 * 给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：word = "USA"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：word = "FlaG"
 * 输出：false
 */
public class Solution520 {
    public static void main(String[] args) {
        String word = "USA";
        System.out.println(new Solution520().detectCapitalUse(word));

    }

    public boolean detectCapitalUse(String word) {
        if (word.equals(word.toUpperCase())) {
            return true;
        }

        if (word.equals(word.toLowerCase())) {
            return true;
        }

        char[] array = word.toCharArray();
        if (array[0] >= 'A' && array[0] <= 'Z') {
            for (int i = 1; i < array.length; i++) {
                if (array[i] >= 'a' && array[i] <= 'z') {

                } else {
                    return false;
                }
            }

            return true;
        }

        return false;
    }
}
