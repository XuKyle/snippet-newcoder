package com.kylexu.leetcode.str;

/**
 * 示例 1：
 * <p>
 * 输入：s = "leetcode"
 * <p>
 * 输出：true
 * <p>
 * 解释：子字符串 "ee" 的长度为 2，它也出现在 reverse(s) == "edocteel" 中。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "abcba"
 * <p>
 * 输出：true
 * <p>
 * 解释：所有长度为 2 的子字符串 "ab"、"bc"、"cb"、"ba" 也都出现在 reverse(s) == "abcba" 中。
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "abcd"
 * <p>
 * 输出：false
 * <p>
 * 解释：字符串 s 中不存在满足「在其反转后的字符串中也出现」且长度为 2 的子字符串。
 */
public class Solution3083 {
    public static void main(String[] args) {
        String s = "abcd";
        boolean rs = new Solution3083().isSubstringPresent(s);
        System.out.println("rs = " + rs);
    }

    public boolean isSubstringPresent(String s) {
        String resersed = new StringBuilder(s).reverse().toString();

        for (int i = 0; i < s.length() - 1; i++) {
            String sub = s.substring(i, i + 2);

            if (s.contains(sub) && resersed.contains(sub)) {
                return true;
            }
        }

        return false;
    }
}
