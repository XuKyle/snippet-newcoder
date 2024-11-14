package com.kylexu.leetcode.str;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 一个字符串如果没有 三个连续 相同字符，那么它就是一个 好字符串 。
 * <p>
 * 给你一个字符串 s ，请你从 s 删除 最少 的字符，使它变成一个 好字符串 。
 * <p>
 * 请你返回删除后的字符串。题目数据保证答案总是 唯一的 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "leeetcode"
 * 输出："leetcode"
 * 解释：
 * 从第一组 'e' 里面删除一个 'e' ，得到 "leetcode" 。
 * 没有连续三个相同字符，所以返回 "leetcode" 。
 * 示例 2：
 * <p>
 * 输入：s = "aaabaaaa"
 * 输出："aabaa"
 * 解释：
 * 从第一组 'a' 里面删除一个 'a' ，得到 "aabaaaa" 。
 * 从第二组 'a' 里面删除两个 'a' ，得到 "aabaa" 。
 * 没有连续三个相同字符，所以返回 "aabaa" 。
 * 示例 3：
 * <p>
 * 输入：s = "aab"
 * 输出："aab"
 * 解释：没有连续三个相同字符，所以返回 "aab" 。
 */
public class Solution1957 {

    public String makeFancyString(String s) {
        int left = 0;
        char current = s.charAt(left);

        List<Character> rs = new ArrayList<>();
        rs.add(current);

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == current) {
                if ((i - left + 1) >= 3) {

                } else {
                    rs.add(s.charAt(i));
                }
            } else {
                left = i;
                current = s.charAt(i);
                rs.add(current);
            }
        }

        return rs.stream().map(String::valueOf).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println(new Solution1957().makeFancyString("aaabaaaa"));
    }
}


