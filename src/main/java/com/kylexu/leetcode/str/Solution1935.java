package com.kylexu.leetcode.str;

import java.util.HashSet;
import java.util.Set;

/**
 * 示例 1：
 * <p>
 * 输入：text = "hello world", brokenLetters = "ad"
 * 输出：1
 * 解释：无法输入 "world" ，因为字母键 'd' 已损坏。
 * 示例 2：
 * <p>
 * 输入：text = "leet code", brokenLetters = "lt"
 * 输出：1
 * 解释：无法输入 "leet" ，因为字母键 'l' 和 't' 已损坏。
 * 示例 3：
 * <p>
 * 输入：text = "leet code", brokenLetters = "e"
 * 输出：0
 * 解释：无法输入任何单词，因为字母键 'e' 已损坏。
 */
public class Solution1935 {
    public static void main(String[] args) {
        String text = "hello world";
        String brokenLetters = "ad";
        System.out.println(new Solution1935().canBeTypedWords(text, brokenLetters));
    }

    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> sets = new HashSet<>();
        for (char c : brokenLetters.toCharArray()) {
            sets.add(c);
        }

        int all = 0;
        int rs = 0;
        for (String word : text.split(" ")) {
            all++;
            for (Character set : sets) {
                if (word.indexOf(set) != -1) {
                    rs++;
                    break;
                }
            }
        }

        return all - rs;
    }
}
