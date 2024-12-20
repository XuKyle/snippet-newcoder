package com.kylexu.leetcode.str;

/**
 * 给你一个仅由 0 和 1 组成的二进制字符串 s 。
 * 如果子字符串中 所有的 0 都在 1 之前 且其中 0 的数量等于 1 的数量，则认为 s 的这个子字符串是平衡子字符串。请注意，空子字符串也视作平衡子字符串。
 * 返回  s 中最长的平衡子字符串长度。
 * <p>
 * 子字符串是字符串中的一个连续字符序列。
 * 示例 1：
 * <p>
 * 输入：s = "01000111"
 * 输出：6
 * 解释：最长的平衡子字符串是 "000111" ，长度为 6 。
 * 示例 2：
 * <p>
 * 输入：s = "00111"
 * 输出：4
 * 解释：最长的平衡子字符串是 "0011" ，长度为  4 。
 * 示例 3：
 * <p>
 * 输入：s = "111"
 * 输出：0
 * 解释：除了空子字符串之外不存在其他平衡子字符串，所以答案为 0 。
 */
public class Solution2609 {
    public static void main(String[] args) {
        String s = "001";
        System.out.println(new Solution2609().findTheLongestBalancedSubstring(s));
    }

    public int findTheLongestBalancedSubstring(String s) {
        int left = 0, right = 0, zeroCount = 0, oneCount = 0, rs = 0;
        while (right < s.length()) {
            while (right < s.length() && s.charAt(right) != '1') {
                right++;
            }
            zeroCount = right - left;
            left = right;
            while (right < s.length() && s.charAt(right) != '0') {
                right++;
            }
            oneCount = right - left;
            left = right;


            rs = Math.max(rs, Math.min(zeroCount, oneCount) * 2);
        }
        return rs;
    }
}
