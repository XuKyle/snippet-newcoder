package com.kylexu.leetcode.tree;

import java.util.Arrays;
import java.util.Set;

/**
 * 给你一个由若干单词组成的句子 sentence ，单词间由空格分隔。每个单词仅由大写和小写英文字母组成。
 * <p>
 * 请你将句子转换为 “山羊拉丁文（Goat Latin）”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。山羊拉丁文的规则如下：
 * <p>
 * 如果单词以元音开头（'a', 'e', 'i', 'o', 'u'），在单词后添加"ma"。
 * 例如，单词 "apple" 变为 "applema" 。
 * 如果单词以辅音字母开头（即，非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
 * 例如，单词 "goat" 变为 "oatgma" 。
 * 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从 1 开始。
 * 例如，在第一个单词后添加 "a" ，在第二个单词后添加 "aa" ，以此类推。
 * 返回将 sentence 转换为山羊拉丁文后的句子。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：sentence = "I speak Goat Latin"
 * 输出："Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 * 示例 2：
 * <p>
 * 输入：sentence = "The quick brown fox jumped over the lazy dog"
 * 输出："heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 */
public class Solution824 {
    public static void main(String[] args) {
        String sentence = "I speak Goat Latin";
        System.out.println(new Solution824().toGoatLatin(sentence));
    }

    public String toGoatLatin(String sentence) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        StringBuilder rs = new StringBuilder();
        String[] words = sentence.split("\\s+");

        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            if (vowels.contains(currentWord.charAt(0))) {
                currentWord += "ma";
            } else {
                currentWord = currentWord.substring(1) + currentWord.charAt(0) + "ma";
            }
            currentWord += "a".repeat(i + 1);
            rs.append(currentWord);
            if (i != words.length - 1) {
                rs.append(" ");
            }
        }

        return rs.toString();
    }
}
