package com.kylexu.leetcode.str;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 示例 1：
 * <p>
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 * <p>
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 * <p>
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 */
public class Solution93 {
    public static void main(String[] args) {
        String s = "25525511135";
        List<String> rs = new Solution93().restoreIpAddresses(s);
        System.out.println("rs = " + rs);
    }

    List<String> rs = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        StringBuilder sb = new StringBuilder(s);
        backtracking(sb, 0, 0);
        return rs;
    }

    private void backtracking(StringBuilder s, int startIndex, int dotCount) {
        if (dotCount == 3) {
            if (isValid(s, startIndex, s.length() - 1)) {
                rs.add(s.toString());
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (isValid(s, startIndex, i)) {
                s.insert(i + 1, '.');
                backtracking(s, i + 2, dotCount + 1);
                s.deleteCharAt(i + 1);
            } else {
                break;
            }
        }
    }

    private boolean isValid(StringBuilder s, int start, int end) {
        if (start > end) return false;
        if (s.charAt(start) == '0' && start != end) return false;
        int num = 0;
        for (int i = start; i <= end; i++) {
            int digit = s.charAt(i) - '0';
            num = num * 10 + digit;
            if (num > 255) return false;
        }
        return true;
    }
}
