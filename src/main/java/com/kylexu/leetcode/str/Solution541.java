package com.kylexu.leetcode.str;

/**
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * 示例 2：
 * <p>
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 */
public class Solution541 {

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        String rs = new Solution541().reverseStr(s, k);
        System.out.println("rs = " + rs);
    }

    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] array = s.toCharArray();

        for (int i = 0; i < n; i += 2 * k) {
            reverse(array, i, Math.min(i + k, n) - 1);
        }
        return new String(array);
    }

    public void reverse(char[] chars, int left, int right) {
        char temp = chars[right];
        chars[right] = chars[left];
        chars[left] = temp;
    }
}
