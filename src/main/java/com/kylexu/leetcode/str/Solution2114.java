package com.kylexu.leetcode.str;

/**
 * 输入：sentences = ["alice and bob love leetcode", "i think so too", "this is great thanks very much"]
 * 输出：6
 * 解释：
 * - 第一个句子 "alice and bob love leetcode" 总共有 5 个单词。
 * - 第二个句子 "i think so too" 总共有 4 个单词。
 * - 第三个句子 "this is great thanks very much" 总共有 6 个单词。
 * 所以，单个句子中有最多单词数的是第三个句子，总共有 6 个单词。
 * 示例 2：
 * <p>
 * 输入：sentences = ["please wait", "continue to fight", "continue to win"]
 * 输出：3
 * 解释：可能有多个句子有相同单词数。
 * 这个例子中，第二个句子和第三个句子（加粗斜体）有相同数目的单词数。
 */
public class Solution2114 {
    public static void main(String[] args) {
        String[] sentences = new String[]{"alice and bob love leetcode", "i think so too", "this is great thanks very much"};
        System.out.println(new Solution2114().mostWordsFound(sentences));
    }

    public int mostWordsFound(String[] sentences) {
        int rs = 0;

        for (String sentence : sentences) {
            rs = Math.max(rs, sentence.split(" ").length);
        }

        return rs;
    }
}
