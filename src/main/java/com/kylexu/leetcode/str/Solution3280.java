package com.kylexu.leetcode.str;

import java.util.Arrays;

/**
 * 示例 1：
 * <p>
 * 输入： date = "2080-02-29"
 * <p>
 * 输出： "100000100000-10-11101"
 * 100000100000, 10 和 11101 分别是 2080, 02 和 29 的二进制表示。
 * <p>
 * 示例 2：
 * 输入： date = "1900-01-01"
 * 输出： "11101101100-1-1"
 */
public class Solution3280 {
    public static void main(String[] args) {
        String date = "1900-01-01";
        System.out.println(new Solution3280().convertDateToBinary(date));

        System.out.println(new Solution3280().toBinary("10"));
    }

    public String convertDateToBinary(String date) {
        String[] split = date.split("-");
        StringBuilder rs = new StringBuilder();

        for (int i = 0; i < split.length; i++) {
            rs.append(toBinary(split[i]));
            if (i != split.length - 1) {
                rs.append("-");
            }
        }

        return rs.toString();
    }

    public String toBinary(String str) {
        int integer = Integer.parseInt(str);
        StringBuilder rs = new StringBuilder();
        while (integer != 0) {
            rs.append(integer % 2);
            integer = integer / 2;
        }
        return rs.reverse().toString();
    }
}
