package com.kylexu.leetcode.num;

/**
 * 给你一个整数 n。
 * <p>
 * 返回 n2 的 十六进制表示 和 n3 的 三十六进制表示 拼接成的字符串。
 * <p>
 * 十六进制 数定义为使用数字 0 – 9 和大写字母 A - F 表示 0 到 15 的值。
 * <p>
 * 三十六进制 数定义为使用数字 0 – 9 和大写字母 A - Z 表示 0 到 35 的值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 13
 * <p>
 * 输出： "A91P1"
 * <p>
 * 解释：
 * <p>
 * n2 = 13 * 13 = 169。在十六进制中，它转换为 (10 * 16) + 9 = 169，对应于 "A9"。
 * n3 = 13 * 13 * 13 = 2197。在三十六进制中，它转换为 (1 * 362) + (25 * 36) + 1 = 2197，对应于 "1P1"。
 * 连接两个结果得到 "A9" + "1P1" = "A91P1"。
 */
public class Solution3602 {
    public static void main(String[] args) {
        int n = 13;
        String s = new Solution3602().concatHex36(n);
        System.out.println("s = " + s);
    }

    public String concatHex36(int n) {
        return hex16(n) + hex36(n);
    }

    private String hex16(int n) {
        int num = n * n;
        return Integer.toHexString(num).toUpperCase();
    }

    private String hex36(int n) {
        long num = (long) n * n * n;
        StringBuilder rs = new StringBuilder();
        while (num != 0) {
            long cur = num % 36;
            if (cur <= 9) {
                rs.append(cur);
            } else {
                char ch = (char) ('A' + cur - 10);
                rs.append(ch);
            }
            num = num / 36;
        }
        return rs.reverse().toString();
    }
}
