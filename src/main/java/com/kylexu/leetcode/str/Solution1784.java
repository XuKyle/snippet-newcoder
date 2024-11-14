package com.kylexu.leetcode.str;

/**
 * 给你一个二进制字符串 s ，该字符串 不含前导零 。
 * <p>
 * 如果 s 包含 零个或一个由连续的 '1' 组成的字段 ，返回 true​​​ 。否则，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "1001"
 * 输出：false
 * 解释：由连续若干个 '1' 组成的字段数量为 2，返回 false
 * 示例 2：
 * <p>
 * 输入：s = "110"
 * 输出：true
 */
public class Solution1784 {
    public static void main(String[] args) {
        // 垃圾题目，没啥意义。
        System.out.println(new Solution1784().checkOnesSegment("110"));
    }

    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }
}
