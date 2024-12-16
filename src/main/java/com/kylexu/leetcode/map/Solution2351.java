package com.kylexu.leetcode.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给你一个由小写英文字母组成的字符串 s ，请你找出并返回第一个出现 两次 的字母。
 * 注意：
 * 如果 a 的 第二次 出现比 b 的 第二次 出现在字符串中的位置更靠前，则认为字母 a 在字母 b 之前出现两次。
 * s 包含至少一个出现两次的字母。
 * 示例 1：
 * <p>
 * 输入：s = "abccbaacz"
 * 输出："c"
 * 解释：
 * 字母 'a' 在下标 0 、5 和 6 处出现。
 * 字母 'b' 在下标 1 和 4 处出现。
 * 字母 'c' 在下标 2 、3 和 7 处出现。
 * 字母 'z' 在下标 8 处出现。
 * 字母 'c' 是第一个出现两次的字母，因为在所有字母中，'c' 第二次出现的下标是最小的。
 * 示例 2：
 * <p>
 * 输入：s = "abcdd"
 * 输出："d"
 * 解释：
 * 只有字母 'd' 出现两次，所以返回 'd' 。
 */
public class Solution2351 {
    public static void main(String[] args) {
        String s = "abcdd";
        System.out.println(new Solution2351().repeatedCharacter(s));
    }

    public char repeatedCharacter(String s) {
        Set<Character> memo = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (memo.contains(c)) {
                return c;
            }
            memo.add(c);
        }
        return 'a';
    }
}
