package com.kylexu.leetcode.str;

import java.util.Arrays;

/**
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * 示例:
 * <p>
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 */
public class Solution434 {
    public static void main(String[] args) {
        String s = "    foo    bar";
        System.out.println(new Solution434().countSegments(s));
    }

    public int countSegments(String s) {
        if (s.trim().isEmpty()) {
            return 0;
        }
        String[] split = s.trim().split(" +");
        System.out.println("split = " + Arrays.toString(split));
        return split.length;
    }
}
