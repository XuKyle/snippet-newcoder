package com.kylexu.leetcode.str;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 */
public class Solution394 {
    /**
     * 示例 1：
     * <p>
     * 输入：s = "3[a]2[bc]"
     * 输出："aaabcbc"
     * 示例 2：
     * <p>
     * 输入：s = "3[a2[c]]"
     * 输出："accaccacc"
     * 示例 3：
     * <p>
     * 输入：s = "2[abc]3[cd]ef"
     * 输出："abcabccdcdcdef"
     * 示例 4：
     * <p>
     * 输入：s = "abc3[cd]xyz"
     * 输出："abccdcdcdxyz"
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new Solution394().decodeString("3[a]2[bc]"));
        System.out.println(new Solution394().decodeString("2[abc]3[cd]ef"));
        System.out.println(new Solution394().decodeString("abc3[cd]xyz"));
        System.out.println(new Solution394().decodeString("100[leetcode]"));
    }

    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        char[] array = s.toCharArray();

        StringBuilder innerString = new StringBuilder();

        for (char c : array) {
            if ("]".equals(String.valueOf(c))) {
                Character pop = stack.pop();
                while (pop != '[') {
                    innerString.append(pop);
                    pop = stack.pop();
                }

                Character peeked = stack.peek();
                StringBuilder numBuilder = new StringBuilder();
                while (Character.isDigit(peeked)) {
                    numBuilder.append(stack.pop());
                    if (stack.isEmpty()) {
                        break;
                    }
                    peeked = stack.peek();
                }
                int num = Integer.parseInt(numBuilder.reverse().toString());

                List<Character> list = new ArrayList<Character>();

                char[] charArray = innerString.reverse().toString().toCharArray();
                for (int j = 0; j < num; j++) {
                    for (char c1 : charArray) {
                        stack.push(c1);
                    }
                }
                innerString = new StringBuilder();
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
