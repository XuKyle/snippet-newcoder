package com.kylexu.leetcode.str;

/**
 * 示例 1：
 * <p>
 * 输入：s = "egcfe"
 * 输出："efcfe"
 * 解释：将 "egcfe" 变成回文字符串的最小操作次数为 1 ，修改 1 次得到的字典序最小回文字符串是 "efcfe"，只需将 'g' 改为 'f' 。
 * 示例 2：
 * <p>
 * 输入：s = "abcd"
 * 输出："abba"
 * 解释：将 "abcd" 变成回文字符串的最小操作次数为 2 ，修改 2 次得到的字典序最小回文字符串是 "abba" 。
 * 示例 3：
 * <p>
 * 输入：s = "seven"
 * 输出："neven"
 * 解释：将 "seven" 变成回文字符串的最小操作次数为 1 ，修改 1 次得到的字典序最小回文字符串是 "neven" 。
 */
public class Solution2697 {
    public static void main(String[] args) {
        String s = "egcfe";
        String rs = new Solution2697().makeSmallestPalindrome(s);
        System.out.println("rs = " + rs);
    }

    public String makeSmallestPalindrome(String s) {
        char[] rs = s.toCharArray();

        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (rs[l] > rs[r]) {
                rs[l] = rs[r];
            } else if (rs[l] < rs[r]) {
                rs[r] = rs[l];
            }
            l++;
            r--;
        }

        return new String(rs);
    }
}
