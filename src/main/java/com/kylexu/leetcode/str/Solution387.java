package com.kylexu.leetcode.str;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 * 示例 1：
 * <p>
 * 输入: s = "leetcode"
 * 输出: 0
 * 示例 2:
 * <p>
 * 输入: s = "loveleetcode"
 * 输出: 2
 * 示例 3:
 * <p>
 * 输入: s = "aabb"
 * 输出: -1
 */
public class Solution387 {
    public static void main(String[] args) {
        String s = "aabb";
        System.out.println(new Solution387().firstUniqChar(s));
    }

    public int firstUniqChar(String s) {
        Map<Integer, Long> count = s.chars().boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (int i = 0; i < s.length(); i++) {
            int numericValue = s.charAt(i);
            if (count.get(numericValue) == 1) {
                return i;
            }
        }
        return -1;
    }
}
