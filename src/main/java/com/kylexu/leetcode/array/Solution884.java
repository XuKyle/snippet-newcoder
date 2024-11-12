package com.kylexu.leetcode.array;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 句子 是一串由空格分隔的单词。每个 单词 仅由小写字母组成。
 * <p>
 * 如果某个单词在其中一个句子中恰好出现一次，在另一个句子中却 没有出现 ，那么这个单词就是 不常见的 。
 * <p>
 * 给你两个 句子 s1 和 s2 ，返回所有 不常用单词 的列表。返回列表中单词可以按 任意顺序 组织。
 */
public class Solution884 {
    public String[] uncommonFromSentences(String s1, String s2) {
        String s = s1 + " " + s2;

        return Arrays.stream(s.split(" "))
                .map(String::trim)
                .collect(Collectors.toMap(a -> a, a -> 1, Integer::sum))
                .entrySet()
                .stream()
                .filter(m -> m.getValue() == 1)
                .map(Map.Entry::getKey)
                .toArray(String[]::new);
    }
}
