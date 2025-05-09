package com.kylexu.leetcode.str;

/**
 * 给你一个用字符串表示的正整数 num ，请你以字符串形式返回不含尾随零的整数 num 。
 * 示例 1：
 * <p>
 * 输入：num = "51230100"
 * 输出："512301"
 * 解释：整数 "51230100" 有 2 个尾随零，移除并返回整数 "512301" 。
 * 示例 2：
 * <p>
 * 输入：num = "123"
 * 输出："123"
 * 解释：整数 "123" 不含尾随零，返回整数 "123" 。
 */
public class Solution2710 {
    public static void main(String[] args) {
        String num = "00";
        System.out.println(new Solution2710().removeTrailingZeros(num));
    }

    public String removeTrailingZeros(String num) {
        int right = num.length() - 1;

        while (right >= 0 && num.charAt(right) == '0') {
            right--;
        }

        return num.substring(0, ++right);
    }
}
