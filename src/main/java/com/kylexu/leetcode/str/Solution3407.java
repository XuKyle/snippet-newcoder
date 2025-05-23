package com.kylexu.leetcode.str;

import java.util.Arrays;

/**
 * 给你一个字符串 s 和一个模式字符串 p ，其中 p 恰好 包含 一个 '*' 符号。
 * <p>
 * p 中的 '*' 符号可以被替换为零个或多个字符组成的任意字符序列。
 * 如果 p 可以变成 s 的 子字符串，那么返回 true ，否则返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "leetcode", p = "ee*e"
 * <p>
 * 输出：true
 * <p>
 * 解释：
 * <p>
 * 将 '*' 替换为 "tcod" ，子字符串 "eetcode" 匹配模式串。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "car", p = "c*v"
 * <p>
 * 输出：false
 * <p>
 * 解释：
 * <p>
 * 不存在匹配模式串的子字符串。
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "luck", p = "u*"
 * <p>
 * 输出：true
 * <p>
 * 解释：
 * <p>
 * 子字符串 "u" ，"uc" 和 "uck" 都匹配模式串。
 */
public class Solution3407 {
    public static void main(String[] args) {

//        "luck"
//        p =
//                "u*"

        String s = "luck";
        String p = "u*";
        boolean rs = new Solution3407().hasMatch(s, p);
        System.out.println("rs = " + rs);
    }

    public boolean hasMatch(String s, String p) {
        if (p.equals("*")) {
            return true;
        }
        
        String[] split = p.split("\\*");
        String head = split[0];
        if (split.length == 1) {
            return s.contains(head);
        }
        String tail = split[1];

        int headIndex = s.indexOf(head);
        if (headIndex == -1 || headIndex + head.length() >= s.length()) {
            return false;
        }
        int tailIndex = s.substring(headIndex + head.length()).indexOf(tail);
        return tailIndex != -1;
    }
}
