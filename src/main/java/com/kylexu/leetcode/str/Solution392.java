package com.kylexu.leetcode.str;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 * 进阶：
 * <p>
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 * <p>
 * 致谢：
 * <p>
 * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 */
public class Solution392 {
    public static void main(String[] args) {
        System.out.println(new Solution392().isSubsequence("abc", "ahbgdc"));
        System.out.println(new Solution392().isSubsequence("axc", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        int i = 0;
        int j = 0;

        while (j < t.length()) {
            char current = s.charAt(i);
            if (t.charAt(j) != current) {
                j++;
            } else {
                i++;
                j++;
            }
            if (i == s.length()) {
                break;
            }
        }

        return i == s.length();
    }
}
