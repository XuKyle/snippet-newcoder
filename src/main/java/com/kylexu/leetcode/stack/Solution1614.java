package com.kylexu.leetcode.stack;

import java.util.LinkedList;

/**
 * 示例 1：
 * 输入：s = "(1+(2*3)+((8)/4))+1"
 * <p>
 * 输出：3
 * <p>
 * 解释：数字 8 在嵌套的 3 层括号中。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "(1)+((2))+(((3)))"
 * <p>
 * 输出：3
 * <p>
 * 解释：数字 3 在嵌套的 3 层括号中。
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "()(())((()()))"
 * <p>
 * 输出：3
 */
public class Solution1614 {
    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        int i = new Solution1614().maxDepth(s);
        System.out.println("i = " + i);
    }

    public int maxDepth(String s) {
        int max = 0;
        LinkedList<Character> rs = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                rs.push(c);
            } else if (c == ')') {
                rs.removeLast();
            }
            max = Math.max(max, rs.size());
        }
        return max;
    }
}
