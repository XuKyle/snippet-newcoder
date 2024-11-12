package com.kylexu.leetcode.stack;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "()"
 * <p>
 * 输出：true
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "()[]{}"
 * <p>
 * 输出：true
 */
public class Solution20 {
    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        System.out.println(solution20.isValid("()[]{}"));
        System.out.println(solution20.isValid("([])"));
        System.out.println(solution20.isValid("(]"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] array = s.toCharArray();
        for (char c : array) {
            if (isLeftBracket(c)) {
                stack.add(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (isPair(pop, c)) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isLeftBracket(char c) {
        return '(' == c || '{' == c || '[' == c;
    }

    private boolean isPair(char left, char right) {
        if ('(' == left && ')' == right) {
            return true;
        } else if ('{' == left && '}' == right) {
            return true;
        } else if ('[' == left && ']' == right) {
            return true;
        }
        return false;
    }
}
