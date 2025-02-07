package com.kylexu.leetcode.str;

import java.util.HashMap;
import java.util.Map;

/**
 * 示例 1：
 * <p>
 * 输入：s = "2523533"
 * 输出："23"
 * <p>
 * 解释：
 * <p>
 * 数字 '2' 出现 2 次，数字 '3' 出现 3 次。"23" 中每个数字在 s 中出现的次数都恰好分别等于数字本身。所以输出 "23" 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "221"
 * <p>
 * 输出："21"
 * <p>
 * 解释：
 * <p>
 * 数字 '2' 出现 2 次，数字 '1' 出现 1 次。所以输出 "21" 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "22"
 * <p>
 * 输出：""
 * <p>
 * 解释：
 * <p>
 * 没有合法的相邻数字。
 */
public class Solution3438 {
    public static void main(String[] args) {
        String s = "222";
        System.out.println(new Solution3438().findValidPair(s));
    }

    public String findValidPair(String s) {
        Map<Character, Integer> counter = new HashMap<>();

        for (char c : s.toCharArray()) {
            counter.merge(c, 1, Integer::sum);
        }

        int n = s.length();
        for (int i = 0; i < n - 1; i++) {
            char current = s.charAt(i);
            char next = s.charAt(i + 1);
            if (current == next) {
                continue;
            }

            if (counter.get(current) == Character.getNumericValue(current) && counter.get(next) == Character.getNumericValue(next)) {
                return s.substring(i, i + 2);
            }
        }
        return "";
    }
}
