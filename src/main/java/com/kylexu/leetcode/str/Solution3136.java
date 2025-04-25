package com.kylexu.leetcode.str;

import java.util.Set;

/**
 * 有效单词 需要满足以下几个条件：
 * <p>
 * 至少 包含 3 个字符。
 * 由数字 0-9 和英文大小写字母组成。（不必包含所有这类字符。）
 * 至少 包含一个 元音字母 。
 * 至少 包含一个 辅音字母 。
 * 给你一个字符串 word 。如果 word 是一个有效单词，则返回 true ，否则返回 false 。
 * <p>
 * 注意：
 * <p>
 * 'a'、'e'、'i'、'o'、'u' 及其大写形式都属于 元音字母 。
 * 英文中的 辅音字母 是指那些除元音字母之外的字母。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：word = "234Adas"
 * <p>
 * 输出：true
 * <p>
 * 解释：
 * <p>
 * 这个单词满足所有条件。
 */
public class Solution3136 {
    public static void main(String[] args) {
        String word = "AhI";
        boolean valid = new Solution3136().isValid(word);
        System.out.println("valid = " + valid);
    }

    public boolean isValid(String word) {
//         * 至少 包含 3 个字符。
        if (word.length() < 3) {
            return false;
        }

// * 由数字 0-9 和英文大小写字母组成。（不必包含所有这类字符。）
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
        int aCount = 0;
        int bCount = 0;
        for (char c : word.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                if (set.contains(c)) {
                    aCount++;
                } else {
                    bCount++;
                }
            } else if (Character.isDigit(c)) {

            } else {
                return false;
            }
        }

        return aCount > 0 && bCount > 0;
    }
}
