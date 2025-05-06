package com.kylexu.leetcode.str;

/**
 * 示例 1：
 * <p>
 * 输入：s = "ababa"
 * 输出：1
 * 解释：字符串本身就是回文序列，只需要删除一次。
 * 示例 2：
 * <p>
 * 输入：s = "abb"
 * 输出：2
 * 解释："abb" -> "bb" -> "".
 * 先删除回文子序列 "a"，然后再删除 "bb"。
 * 示例 3：
 * <p>
 * 输入：s = "baabb"
 * 输出：2
 * 解释："baabb" -> "b" -> "".
 * 先删除回文子序列 "baab"，然后再删除 "b"。
 */
public class Solution1332 {
    public static void main(String[] args) {
        String s = "ababa";
        int i = new Solution1332().removePalindromeSub(s);
        System.out.println("i = " + i);
    }

    public int removePalindromeSub(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        if (isPalindrom(s)) {
            return 1;
        }

        if (s.contains("a") && s.contains("b")) {
            return 2;
        }

        return 1;

//        if (s == null || s.isEmpty()) {
//            return 0;
//        }
//        if (isPalindrom(s)) {
//            return 1;
//        }
//        //
//        return 1;
    }

    private boolean isPalindrom(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}
