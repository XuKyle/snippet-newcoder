package com.kylexu.leetcode.str;

/**
 * 句子仅由小写字母（'a' 到 'z'）、数字（'0' 到 '9'）、连字符（'-'）、标点符号（'!'、'.' 和 ','）以及空格（' '）组成。
 * 每个句子可以根据空格分解成 一个或者多个 token ，这些 token 之间由一个或者多个空格 ' ' 分隔。
 * <p>
 * 如果一个 token 同时满足下述条件，则认为这个 token 是一个有效单词：
 * <p>
 * 仅由小写字母、连字符和/或标点（不含数字）组成。
 * 至多一个 连字符 '-' 。如果存在，连字符两侧应当都存在小写字母（"a-b" 是一个有效单词，但 "-ab" 和 "ab-" 不是有效单词）。
 * 至多一个 标点符号。如果存在，标点符号应当位于 token 的 末尾 。
 * 这里给出几个有效单词的例子："a-b."、"afad"、"ba-c"、"a!" 和 "!" 。
 * <p>
 * 给你一个字符串 sentence ，请你找出并返回 sentence 中 有效单词的数目 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：sentence = "cat and  dog"
 * 输出：3
 * 解释：句子中的有效单词是 "cat"、"and" 和 "dog"
 * 示例 2：
 * <p>
 * 输入：sentence = "!this  1-s b8d!"
 * 输出：0
 * 解释：句子中没有有效单词
 * "!this" 不是有效单词，因为它以一个标点开头
 * "1-s" 和 "b8d" 也不是有效单词，因为它们都包含数字
 * 示例 3：
 * <p>
 * 输入：sentence = "alice and  bob are playing stone-game10"
 * 输出：5
 * 解释：句子中的有效单词是 "alice"、"and"、"bob"、"are" 和 "playing"
 * "stone-game10" 不是有效单词，因为它含有数字
 */
public class Solution2047 {
    public static void main(String[] args) {
//        "a-b."、"afad"、"!"、"a!" 和 "!" 。
        String sentence = ".";
        System.out.println(new Solution2047().countValidWords(sentence));
    }

    public int countValidWords(String sentence) {
        int rs = 0;

        for (String s : sentence.split("\\s+")) {
            if (check(s)) {
                rs++;
            }
        }

        return rs;
    }

    private boolean check(String s) {
//* 仅由小写字母、连字符和/或标点（不含数字）组成。
// * 至多一个 连字符 '-' 。如果存在，连字符两侧应当都存在小写字母（"a-b" 是一个有效单词，但 "-ab" 和 "ab-" 不是有效单词）。
// * 至多一个 标点符号。如果存在，标点符号应当位于 token 的 末尾 。
// * 这里给出几个有效单词的例子："a-b."、"afad"、"ba-c"、"a!" 和 "!" 。
        int n = s.length();
        if ("!".equals(s) || ".".equals(s) || ",".equals(s)) {
            return true;
        }
        if (n < 1) {
            return false;
        }
        if (!lowercaseLetters(s.charAt(0))) {
            return false;
        }

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '!' || s.charAt(i) == '.' || s.charAt(i) == ',') {
                if (i != n - 1) {
                    return false;
                }
            } else if (s.charAt(i) == '-') {
                if (i == 0 || i == n - 1) {
                    return false;
                }

                if (!lowercaseLetters(s.charAt(i - 1)) || !lowercaseLetters(s.charAt(i + 1))) {
                    return false;
                }

                if (cnt != 0) {
                    return false;
                }
                cnt++;
            } else if (!lowercaseLetters(s.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    private boolean lowercaseLetters(Character c) {
        return c >= 97 && c <= 122;
    }
}
