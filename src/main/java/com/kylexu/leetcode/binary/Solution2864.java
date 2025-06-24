package com.kylexu.leetcode.binary;

/**
 * 示例 1：
 * <p>
 * 输入：s = "010"
 * 输出："001"
 * 解释：因为字符串 s 中仅有一个 '1' ，其必须出现在最后一位上。所以答案是 "001" 。
 * 示例 2：
 * <p>
 * 输入：s = "0101"
 * 输出："1001"
 * 解释：其中一个 '1' 必须出现在最后一位上。而由剩下的数字可以生产的最大数字是 "100" 。所以答案是 "1001" 。
 */
public class Solution2864 {
    public static void main(String[] args) {
        String s = "0101";
        String s1 = new Solution2864().maximumOddBinaryNumber(s);
        System.out.println("s1 = " + s1);
    }

    public String maximumOddBinaryNumber(String s) {
        int n = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                n++;
            }
        }

        StringBuilder rs = new StringBuilder();
        rs.append("1".repeat(Math.max(0, n - 1)));
        rs.append("0".repeat(Math.max(0, s.length() - n)));
        rs.append('1');

        return rs.toString();
    }
}
