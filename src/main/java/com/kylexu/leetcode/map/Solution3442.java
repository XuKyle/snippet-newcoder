package com.kylexu.leetcode.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个由小写英文字母组成的字符串 s 。请你找出字符串中两个字符的出现频次之间的 最大 差值，这两个字符需要满足：
 * <p>
 * 一个字符在字符串中出现 偶数次 。
 * 另一个字符在字符串中出现 奇数次 。
 * 返回 最大 差值，计算方法是出现 奇数次 字符的次数 减去 出现 偶数次 字符的次数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aaaaabbc"
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * 字符 'a' 出现 奇数次 ，次数为 5 ；字符 'b' 出现 偶数次 ，次数为 2 。
 * 最大差值为 5 - 2 = 3 。
 * 示例 2：
 * <p>
 * 输入：s = "abcabcab"
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * 字符 'a' 出现 奇数次 ，次数为 3 ；字符 'c' 出现 偶数次 ，次数为 2 。
 * 最大差值为 3 - 2 = 1 。
 */
public class Solution3442 {
    public static void main(String[] args) {
        String s = "tzt";
        System.out.println(new Solution3442().maxDifference(s));
    }

    public int maxDifference(String s) {
        Map<Character, Integer> mark = new HashMap<>();

        for (char c : s.toCharArray()) {
            mark.merge(c, 1, Integer::sum);
        }

        int maxOdd = Integer.MIN_VALUE;
        int minEven = Integer.MAX_VALUE;

        for (Map.Entry<Character, Integer> entry : mark.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                minEven = Math.min(minEven, entry.getValue());
            } else {
                maxOdd = Math.max(maxOdd, entry.getValue());
            }
        }

        return maxOdd - minEven;
    }
}
