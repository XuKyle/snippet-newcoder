package com.kylexu.leetcode.str;

/**
 * 对于字符串 s 和 t，只有在 s = t + t + t + ... + t + t（t 自身连接 1 次或多次）时，我们才认定 “t 能除尽 s”。
 * 给定两个字符串 str1 和 str2 。返回 最长字符串 x，要求满足 x 能除尽 str1 且 x 能除尽 str2 。
 * 示例 1：
 * 输入：str1 = "ABCABC", str2 = "ABC"
 * 输出："ABC"
 * 示例 2：
 * <p>
 * 输入：str1 = "ABABAB", str2 = "ABAB"
 * 输出："AB"
 * 示例 3：
 * <p>
 * 输入：str1 = "LEET", str2 = "CODE"
 * 输出：""
 */
public class Solution1071 {
    public static void main(String[] args) {
        String str1 = "LEET";
        String str2 = "CODE";
        System.out.println(new Solution1071().gcdOfStrings(str1, str2));
    }

    public String gcdOfStrings(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();

        String shortStr = n1 >= n2 ? str2 : str1;
        String longStr = n1 >= n2 ? str1 : str2;

        for (int i = shortStr.length(); i > 0; i--) {
            String currentStr = shortStr.substring(0, i);
            if (n1 % currentStr.length() == 0 && n2 % currentStr.length() == 0) {
                int shortRepeatCount = shortStr.length() / currentStr.length();
                int longRepeatCount = longStr.length() / currentStr.length();

                if (currentStr.repeat(shortRepeatCount).equals(shortStr) && currentStr.repeat(longRepeatCount).equals(longStr)) {
                    return currentStr;
                }
            }
        }


        return "";
    }
}
