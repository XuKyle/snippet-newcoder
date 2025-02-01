package com.kylexu.leetcode.str;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 示例 1：
 * 输入：words = ["abba","baba","bbaa","cd","cd"]
 * 输出：["abba","cd"]
 * 解释：
 * 获取结果数组的方法之一是执行下述步骤：
 * - 由于 words[2] = "bbaa" 和 words[1] = "baba" 是字母异位词，选择下标 2 并删除 words[2] 。
 * 现在 words = ["abba","baba","cd","cd"] 。
 * - 由于 words[1] = "baba" 和 words[0] = "abba" 是字母异位词，选择下标 1 并删除 words[1] 。
 * 现在 words = ["abba","cd","cd"] 。
 * - 由于 words[2] = "cd" 和 words[1] = "cd" 是字母异位词，选择下标 2 并删除 words[2] 。
 * 现在 words = ["abba","cd"] 。
 * 无法再执行任何操作，所以 ["abba","cd"] 是最终答案。
 * 示例 2：
 * <p>
 * 输入：words = ["a","b","c","d","e"]
 * 输出：["a","b","c","d","e"]
 * 解释：
 * words 中不存在互为字母异位词的两个相邻字符串，所以无需执行任何操作。
 */
public class Solution2273 {
    public static void main(String[] args) {
        String[] words = new String[]{"abba", "baba", "bbaa", "cd", "cd"};
        System.out.println(new Solution2273().removeAnagrams(words));
    }

    public List<String> removeAnagrams(String[] words) {
        List<Integer> mark = new ArrayList<>();
        int n = words.length;

        for (int i = 0; i < n; i++) {
            if (mark.contains(i)) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if (ectopicWords(words[i], words[j])) {
                    mark.add(j);
                } else {
                    break;
                }
            }
        }

        List<String> rs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mark.contains(i)) {
                continue;
            }
            rs.add(words[i]);
        }

        return rs;
    }

    private boolean ectopicWords(String left, String right) {
        if (left.length() != right.length()) {
            return false;
        }

        Map<Character, Integer> leftCounter = new HashMap<>();
        for (char c : left.toCharArray()) {
            leftCounter.merge(c, 1, Integer::sum);
        }

        for (char c : right.toCharArray()) {
            if (leftCounter.containsKey(c)) {
                if (leftCounter.get(c) <= 0) {
                    return false;
                } else {
                    leftCounter.put(c, leftCounter.get(c) - 1);
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
