package com.kylexu.leetcode.str;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
 * <p>
 * 请你返回字符串 s 的 能量。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "leetcode"
 * 输出：2
 * 解释：子字符串 "ee" 长度为 2 ，只包含字符 'e' 。
 * 示例 2：
 * <p>
 * 输入：s = "abbcccddddeeeeedcba"
 * 输出：5
 * 解释：子字符串 "eeeee" 长度为 5 ，只包含字符 'e' 。
 */
public class Solution1446 {
    public static void main(String[] args) {
        String s = "abbcccddddeeeeedcba";
        System.out.println(new Solution1446().maxPower(s));
    }

    public int maxPower(String s) {
        int slow = 0;
        int fast = 0;

        int n = s.length();
        int rs = 0;

        while (fast < n) {
            if (s.charAt(fast) == s.charAt(slow)) {
                fast++;
            } else {
                slow = fast;
            }
            rs = Math.max(rs, fast - slow);
        }


        return rs;
    }
}
