package com.kylexu.leetcode.str;

/**
 * 示例 1：
 * <p>
 * 输入：word = "abcdefd", ch = "d"
 * 输出："dcbaefd"
 * 解释："d" 第一次出现在下标 3 。
 * 反转从下标 0 到下标 3（含下标 3）的这段字符，结果字符串是 "dcbaefd" 。
 * 示例 2：
 * <p>
 * 输入：word = "xyxzxe", ch = "z"
 * 输出："zxyxxe"
 * 解释："z" 第一次也是唯一一次出现是在下标 3 。
 * 反转从下标 0 到下标 3（含下标 3）的这段字符，结果字符串是 "zxyxxe" 。
 * 示例 3：
 * <p>
 * 输入：word = "abcd", ch = "z"
 * 输出："abcd"
 * 解释："z" 不存在于 word 中。
 * 无需执行反转操作，结果字符串是 "abcd" 。
 */
public class Solution2000 {
    public static void main(String[] args) {
        String word = "abcdefd";
        char ch = 'd';
        System.out.println(new Solution2000().reversePrefix(word, ch));
    }

    public String reversePrefix(String word, char ch) {
        int indexed = word.indexOf(ch);
        return new StringBuilder(word.substring(0, indexed + 1)).reverse().append(word.substring(indexed + 1)).toString();
    }
}
