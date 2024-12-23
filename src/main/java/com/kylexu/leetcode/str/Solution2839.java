package com.kylexu.leetcode.str;

import java.util.HashMap;
import java.util.Map;

/**
 * 2839. 判断通过操作能否让字符串相等 I
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个字符串 s1 和 s2 ，两个字符串的长度都为 4 ，且只包含 小写 英文字母。
 * <p>
 * 你可以对两个字符串中的 任意一个 执行以下操作 任意 次：
 * <p>
 * 选择两个下标 i 和 j 且满足 j - i = 2 ，然后 交换 这个字符串中两个下标对应的字符。
 * 如果你可以让字符串 s1 和 s2 相等，那么返回 true ，否则返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s1 = "abcd", s2 = "cdab"
 * 输出：true
 * 解释： 我们可以对 s1 执行以下操作：
 * - 选择下标 i = 0 ，j = 2 ，得到字符串 s1 = "cbad" 。
 * - 选择下标 i = 1 ，j = 3 ，得到字符串 s1 = "cdab" = s2 。
 * 示例 2：
 * <p>
 * 输入：s1 = "abcd", s2 = "dacb"
 * 输出：false
 * 解释：无法让两个字符串相等。
 */
public class Solution2839 {
    public static void main(String[] args) {
        String s1 = "qnde";
        String s2 = "flsi";
        System.out.println(new Solution2839().canBeEqual(s1, s2));
    }

    public boolean canBeEqual(String s1, String s2) {
        return ((s1.charAt(0) == s2.charAt(0) && s1.charAt(2) == s2.charAt(2)) || (s1.charAt(0) == s2.charAt(2) && s1.charAt(2) == s2.charAt(0))) &&
                ((s1.charAt(1) == s2.charAt(1) && s1.charAt(3) == s2.charAt(3)) || (s1.charAt(1) == s2.charAt(3) && s1.charAt(3) == s2.charAt(1)));

    }
}
