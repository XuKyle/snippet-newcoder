package com.kylexu.leetcode.str;

/**
 * 示例 1：
 * 输入：s = "00110011"
 * 输出：6
 * 解释：6 个子串满足具有相同数量的连续 1 和 0 ："0011"、"01"、"1100"、"10"、"0011" 和 "01" 。
 * 注意，一些重复出现的子串（不同位置）要统计它们出现的次数。
 * 另外，"00110011" 不是有效的子串，因为所有的 0（还有 1 ）没有组合在一起。
 * 示例 2：
 * <p>
 * 输入：s = "10101"
 * 输出：4
 * 解释：有 4 个子串："10"、"01"、"10"、"01" ，具有相同数量的连续 1 和 0 。
 */
public class Solution696 {
    public static void main(String[] args) {
        String s = "10101";
        System.out.println(new Solution696().countBinarySubstrings(s));
    }

    public int countBinarySubstrings(String s) {
        int n = s.length();
        int rs = 0;

        for (int i = 0; i < n; i++) {
            char current = s.charAt(i);
            int currentEnd = i + 1;
            while (currentEnd < n && s.charAt(currentEnd) == current) {
                currentEnd++;
            }

            if (currentEnd + (currentEnd - i) > n) {
                continue;
            }

            for (int j = currentEnd; j < currentEnd + (currentEnd - i); j++) {
                if (s.charAt(j) != current) {
                    if (j == currentEnd + (currentEnd - i) - 1) {
                        rs++;
                    }
                } else {
                    break;
                }
            }
        }

        return rs;
    }
}
