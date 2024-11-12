package com.kylexu.leetcode.str;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * <p>
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 * 示例 2：
 * <p>
 * 输入：num1 = "456", num2 = "77"
 * 输出："533"
 */
public class Solution415 {
    public static void main(String[] args) {
        System.out.println(new Solution415().addStrings("11", "123"));
        System.out.println(new Solution415().addStrings("456", "77"));
    }

    public String addStrings(String num1, String num2) {
        StringBuilder rs = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1;
             i >= 0 || j >= 0 || carry > 0;
             i--, j--) {

            int a = i < 0 ? 0 : num1.charAt(i) - '0';
            int b = j < 0 ? 0 : num2.charAt(j) - '0';

            int left = (a + b + carry) % 10;
            rs.append(left);
            carry = (a + b + carry) / 10;
        }
        return rs.reverse().toString();
    }
}
