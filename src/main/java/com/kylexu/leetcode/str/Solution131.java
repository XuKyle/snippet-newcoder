package com.kylexu.leetcode.str;

import java.util.ArrayList;
import java.util.List;

/**
 * 示例 1：
 * <p>
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 * <p>
 * 输入：s = "a"
 * 输出：[["a"]]
 */
public class Solution131 {
    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> partition = new Solution131().partition(s);
        System.out.println("partition = " + partition);
    }

    List<List<String>> rs = new ArrayList<>();

    public List<List<String>> partition(String s) {
// todo
        return rs;
    }

    private boolean isPalindrome(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}
