package com.kylexu.leetcode.str;

/**
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * <p>
 * 字母和数字都属于字母数字字符。
 * <p>
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出：true
 * 解释："amanaplanacanalpanama" 是回文串。
 * 示例 2：
 * <p>
 * 输入：s = "race a car"
 * 输出：false
 * 解释："raceacar" 不是回文串。
 */
public class Solution125 {
    public boolean isPalindrome(String s) {
        String trim = s.toLowerCase().trim();
        if (trim.isEmpty()) {
            return true;
        }
        int left = 0;
        int right = trim.length() - 1;

        while (left < right) {
            while (!Character.isLetterOrDigit(trim.charAt(left)) && left < right) {
                left++;
            }

            while (!Character.isLetterOrDigit(trim.charAt(right)) && left < right) {
                right--;
            }

            if (trim.charAt(left) == trim.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution125().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new Solution125().isPalindrome("race a car"));
    }
}
