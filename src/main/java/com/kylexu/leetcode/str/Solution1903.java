package com.kylexu.leetcode.str;

/**
 * 给你一个字符串 num ，表示一个大整数。请你在字符串 num 的所有 非空子字符串 中找出 值最大的奇数 ，并以字符串形式返回。如果不存在奇数，则返回一个空字符串 "" 。
 * <p>
 * 子字符串 是字符串中的一个连续的字符序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = "52"
 * 输出："5"
 * 解释：非空子字符串仅有 "5"、"2" 和 "52" 。"5" 是其中唯一的奇数。
 * 示例 2：
 * <p>
 * 输入：num = "4206"
 * 输出：""
 * 解释：在 "4206" 中不存在奇数。
 * 示例 3：
 * <p>
 * 输入：num = "35427"
 * 输出："35427"
 * 解释："35427" 本身就是一个奇数。
 */
public class Solution1903 {
    public static void main(String[] args) {
        System.out.println(new Solution1903().largestOddNumber("52"));
    }

    public String largestOddNumber(String num) {
        int right = num.length() - 1;
        int n = num.charAt(right) - '0';

        while (n % 2 == 0) {
            right--;
            if (right < 0) {
                break;
            }
            n = num.charAt(right) - '0';
        }

        return num.substring(0, right + 1);
    }
}
