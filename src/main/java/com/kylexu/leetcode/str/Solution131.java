package com.kylexu.leetcode.str;

import java.util.ArrayList;
import java.util.LinkedList;
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
    LinkedList<String> path = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0, new StringBuilder());
        return rs;
    }

    private void backtracking(String s, int startIndex, StringBuilder stringBuilder) {
        if (startIndex == s.length()) {
            rs.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            stringBuilder.append(s.charAt(i));
            if (isPalindrome(stringBuilder.toString())) {
                path.add(stringBuilder.toString());
                backtracking(s, i + 1, new StringBuilder());
                path.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
