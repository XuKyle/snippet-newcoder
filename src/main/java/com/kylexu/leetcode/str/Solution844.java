package com.kylexu.leetcode.str;

/**
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 * <p>
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * 示例 1：
 * <p>
 * 输入：s = "ab#c", t = "ad#c"
 * 输出：true
 * 解释：s 和 t 都会变成 "ac"。
 * 示例 2：
 * <p>
 * 输入：s = "ab##", t = "c#d#"
 * 输出：true
 * 解释：s 和 t 都会变成 ""。
 * 示例 3：
 * <p>
 * 输入：s = "a#c", t = "b"
 * 输出：false
 */
public class Solution844 {
    public boolean backspaceCompare(String s, String t) {
        return backSpace(s).equals(backSpace(t));
    }

    private String backSpace(String str) {
        StringBuilder rs = new StringBuilder();

        for (char c : str.toCharArray()) {
            if ('#' != c) {
                rs.append(c);
            } else {
                if (!rs.isEmpty()) {
                    rs.deleteCharAt(rs.length() - 1);
                }
            }
        }

        return rs.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution844().backSpace("y#f#o##f"));
        System.out.println(new Solution844().backSpace("ab##"));

        boolean compare = new Solution844().backspaceCompare("ab#c", "ad#c");
        System.out.println("compare = " + compare);
    }
}
