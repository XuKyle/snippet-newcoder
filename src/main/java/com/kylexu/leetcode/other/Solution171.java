package com.kylexu.leetcode.other;

/**
 * 输入: columnTitle = "A"
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: columnTitle = "AB"
 * 输出: 28
 * 示例 3:
 * <p>
 * 输入: columnTitle = "ZY"
 * 输出: 701
 */
public class Solution171 {
    public static void main(String[] args) {
        String columnTitle = "A";
        System.out.println(new Solution171().titleToNumber(columnTitle));
    }

    public int titleToNumber(String columnTitle) {
        int rs = 0;

        for (int i = 0; i < columnTitle.length(); i++) {
            int v = columnTitle.charAt(i) - 'A' + 1;
            rs = rs * 26 + v;
        }

        return rs;
    }
}
