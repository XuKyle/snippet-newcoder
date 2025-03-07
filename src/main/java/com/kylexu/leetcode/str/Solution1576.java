package com.kylexu.leetcode.str;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个仅包含小写英文字母和 '?' 字符的字符串 s，请你将所有的 '?' 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符。
 * 注意：你 不能 修改非 '?' 字符。
 * 题目测试用例保证 除 '?' 字符 之外，不存在连续重复的字符。
 * 在完成所有转换（可能无需转换）后返回最终的字符串。如果有多个解决方案，请返回其中任何一个。可以证明，在给定的约束条件下，答案总是存在的。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "?zs"
 * 输出："azs"
 * 解释：该示例共有 25 种解决方案，从 "azs" 到 "yzs" 都是符合题目要求的。只有 "z" 是无效的修改，因为字符串 "zzs" 中有连续重复的两个 'z' 。
 * 示例 2：
 * <p>
 * 输入：s = "ubv?w"
 * 输出："ubvaw"
 * 解释：该示例共有 24 种解决方案，只有替换成 "v" 和 "w" 不符合题目要求。因为 "ubvvw" 和 "ubvww" 都包含连续重复的字符。
 */
public class Solution1576 {
    public static void main(String[] args) {
        String s = "ubv?w";
        System.out.println(new Solution1576().modifyString(s));
    }

    public String modifyString(String s) {
        char[] array = s.toCharArray();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == '?') {
                array[i] = adjust(array, i - 1, i + 1);
            }
        }

        return new String(array);
    }

    private char adjust(char[] array, int preIndex, int nextIndex) {
        Set<Character> cant = new HashSet<>();
        if (preIndex >= 0) {
            cant.add(array[preIndex]);
        }

        if (nextIndex < array.length) {
            cant.add(array[nextIndex]);
        }

        char rs = 'a';
        while (cant.contains(rs)) {
            rs = (char) (rs + 1);
        }

        return rs;
    }
}
