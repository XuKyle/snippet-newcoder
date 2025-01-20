package com.kylexu.leetcode.str;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个字符串 s，最多 可以从中删除一个字符。
 * 请你判断 s 是否能成为回文字符串：如果能，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：s = "aba"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "abca"
 * 输出：true
 * 解释：你可以删除字符 'c' 。
 * 示例 3：
 * <p>
 * 输入：s = "abc"
 * 输出：false
 */
public class Solution680 {
    public static void main(String[] args) {
        String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuclmgmqfvnbgtapekouga";
        String b = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuclmgmqfvnbgtapekouga";
        System.out.println(new StringBuilder(s).reverse().toString());
        System.out.println(new Solution680().validPalindrome(s));
    }

    private boolean first = true;

    public boolean validPalindrome(String s) {
//        String reversed = new StringBuilder(s).reverse().toString();
//
//        if (first) {
//            if (reversed.equals(s)) {
//                return true;
//            }
//        } else {
//            return reversed.equals(s);
//        }
//
//        int left = 0;
//        int right = s.length();
//
//        while (left != right && left + 1 != right) {
//            if (s.charAt(left) != s.charAt(right)){
//
//            }
//        }
//

        //
        return true;
    }
}
