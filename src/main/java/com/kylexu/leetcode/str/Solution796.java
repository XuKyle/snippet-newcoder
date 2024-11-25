package com.kylexu.leetcode.str;

/**
 * 给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。
 * <p>
 * s 的 旋转操作 就是将 s 最左边的字符移动到最右边。
 * <p>
 * 例如, 若 s = 'abcde'，在旋转一次之后结果就是'bcdea' 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcde", goal = "cdeab"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "abcde", goal = "abced"
 * 输出: false
 */
public class Solution796 {
    public static void main(String[] args) {
        String s = "abcde";
        String goal = "abced";
        System.out.println(new Solution796().rotateString(s, goal));
    }

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        char startChar = goal.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == startChar) {
                String rotate = s.substring(i) + s.substring(0, i);
                if (rotate.equals(goal)) {
                    return true;
                }
            }
        }

        return false;
    }
}
