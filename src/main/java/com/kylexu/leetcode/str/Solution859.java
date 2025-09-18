package com.kylexu.leetcode.str;

import java.util.ArrayList;
import java.util.List;

/**
 * 示例 1：
 * <p>
 * 输入：s = "ab", goal = "ba"
 * 输出：true
 * 解释：你可以交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 相等。
 * 示例 2：
 * <p>
 * 输入：s = "ab", goal = "ab"
 * 输出：false
 * 解释：你只能交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 不相等。
 * 示例 3：
 * <p>
 * 输入：s = "aa", goal = "aa"
 * 输出：true
 * 解释：你可以交换 s[0] = 'a' 和 s[1] = 'a' 生成 "aa"，此时 s 和 goal 相等。
 *
 */
public class Solution859 {
    public static void main(String[] args) {
        String s = "aa";
        String goal = "aa";
        boolean rs = new Solution859().buddyStrings(s, goal);
        System.out.println("rs = " + rs);
    }

    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        if (s.equals(goal)) {
            long count = s.chars().boxed().distinct().count();
            if (count == s.length()) {
                return false;
            }
            return true;
        }

        int n = s.length();
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                index.add(i);
            }
        }
        if (index.size() != 2) {
            return false;
        }

        int l = index.get(0);
        int r = index.get(1);

        if (goal.charAt(r) == s.charAt(l) && goal.charAt(l) == s.charAt(r)) {
            return true;
        }

        return false;
    }
}
