package com.kylexu.leetcode.str;

public class Solution67 {
    public static void main(String[] args) {
//        示例 1：
//
//        输入:a = "11", b = "1"
//        输出："100"
//        示例 2：
//
//        输入：a = "1010", b = "1011"
//        输出："10101"

        System.out.println(new Solution67().addBinary("1010", "1011"));
    }

    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder builder = new StringBuilder();

        for (int i = a.length() - 1, j = b.length() - 1;
             i >= 0 || j >= 0;
             i--, j--
        ) {
            int sum = carry;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;

            builder.append(sum % 2);
            carry = sum / 2;
        }
        if (carry == 1) {
            builder.append("1");
        }
        return builder.reverse().toString();
    }
}
