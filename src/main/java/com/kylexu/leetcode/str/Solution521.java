package com.kylexu.leetcode.str;

import java.util.HashSet;
import java.util.Set;

/**
 * 示例 1：
 * <p>
 * 输入: a = "aba", b = "cdc"
 * 输出: 3
 * 解释: 最长特殊序列可为 "aba" (或 "cdc")，两者均为自身的子序列且不是对方的子序列。
 * 示例 2：
 * <p>
 * 输入：a = "aaa", b = "bbb"
 * 输出：3
 * 解释: 最长特殊序列是 "aaa" 和 "bbb" 。
 * 示例 3：
 * <p>
 * 输入：a = "aaa", b = "aaa"
 * 输出：-1
 * 解释: 字符串 a 的每个子序列也是字符串 b 的每个子序列。同样，字符串 b 的每个子序列也是字符串 a 的子序列。
 */
public class Solution521 {
    public static void main(String[] args) {
        String a = "aba";
        String b = "cdc";
        System.out.println(new Solution521().findLUSlength(a, b));
    }

    public int findLUSlength(String a, String b) {
        if (a.length() != b.length()) {
            return Math.max(a.length(), b.length());
        }

        if (a.equals(b)) {
            return -1;
        }

        return a.length();
    }
}
