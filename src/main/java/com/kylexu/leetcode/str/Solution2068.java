package com.kylexu.leetcode.str;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 示例 1：
 * <p>
 * 输入：word1 = "aaaa", word2 = "bccb"
 * 输出：false
 * 解释：字符串 "aaaa" 中有 4 个 'a' ，但是 "bccb" 中有 0 个 'a' 。
 * 两者之差为 4 ，大于上限 3 。
 * 示例 2：
 * <p>
 * 输入：word1 = "abcdeef", word2 = "abaaacc"
 * 输出：true
 * 解释：word1 和 word2 中每个字母出现频率之差至多为 3 ：
 * - 'a' 在 word1 中出现了 1 次，在 word2 中出现了 4 次，差为 3 。
 * - 'b' 在 word1 中出现了 1 次，在 word2 中出现了 1 次，差为 0 。
 * - 'c' 在 word1 中出现了 1 次，在 word2 中出现了 2 次，差为 1 。
 * - 'd' 在 word1 中出现了 1 次，在 word2 中出现了 0 次，差为 1 。
 * - 'e' 在 word1 中出现了 2 次，在 word2 中出现了 0 次，差为 2 。
 * - 'f' 在 word1 中出现了 1 次，在 word2 中出现了 0 次，差为 1 。
 */
public class Solution2068 {
    public static void main(String[] args) {
        String word1 = "abcdeef";
        String word2 = "abaaacc";
        System.out.println(new Solution2068().checkAlmostEquivalent(word1, word2));
    }

    public boolean checkAlmostEquivalent(String word1, String word2) {
        Set<Character> allCharacter = new HashSet<>();
        Map<Character, Integer> word1Count = new HashMap<>();
        Map<Character, Integer> word2Count = new HashMap<>();


        for (int i = 0; i < word1.length(); i++) {
            allCharacter.add(word1.charAt(i));
            word1Count.merge(word1.charAt(i), 1, Integer::sum);
        }

        for (int i = 0; i < word2.length(); i++) {
            allCharacter.add(word2.charAt(i));
            word2Count.merge(word2.charAt(i), 1, Integer::sum);
        }

        for (Character c : allCharacter) {
            if (Math.abs(word1Count.getOrDefault(c, 0) - word2Count.getOrDefault(c, 0)) > 3) {
                return false;
            }
        }

        return true;
    }
}
