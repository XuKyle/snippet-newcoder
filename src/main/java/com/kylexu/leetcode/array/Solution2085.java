package com.kylexu.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 示例 1：
 * <p>
 * 输入：words1 = ["leetcode","is","amazing","as","is"], words2 = ["amazing","leetcode","is"]
 * 输出：2
 * 解释：
 * - "leetcode" 在两个数组中都恰好出现一次，计入答案。
 * - "amazing" 在两个数组中都恰好出现一次，计入答案。
 * - "is" 在两个数组中都出现过，但在 words1 中出现了 2 次，不计入答案。
 * - "as" 在 words1 中出现了一次，但是在 words2 中没有出现过，不计入答案。
 * 所以，有 2 个字符串在两个数组中都恰好出现了一次。
 * 示例 2：
 * <p>
 * 输入：words1 = ["b","bb","bbb"], words2 = ["a","aa","aaa"]
 * 输出：0
 * 解释：没有字符串在两个数组中都恰好出现一次。
 * 示例 3：
 * <p>
 * 输入：words1 = ["a","ab"], words2 = ["a","a","a","ab"]
 * 输出：1
 * 解释：唯一在两个数组中都出现一次的字符串是 "ab" 。
 */
public class Solution2085 {
    public static void main(String[] args) {
        String[] word1 = new String[]{"leetcode", "is", "amazing", "as", "is"};
        String[] word2 = new String[]{"amazing", "leetcode", "is"};
        System.out.println(new Solution2085().countWords(word1, word2));
    }

    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> wc1 = new HashMap<>();
        Map<String, Integer> wc2 = new HashMap<>();

        for (String word : words1) {
            wc1.merge(word, 1, Integer::sum);
        }

        for (String word : words2) {
            wc2.merge(word, 1, Integer::sum);
        }

        int rs = 0;
        for (Map.Entry<String, Integer> entry : wc1.entrySet()) {
            if (entry.getValue() == 1 && wc2.getOrDefault(entry.getKey(), 0) == 1) {
                rs++;
            }
        }
        return rs;
    }
}
