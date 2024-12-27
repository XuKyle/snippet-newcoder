package com.kylexu.leetcode.str;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你两个字符串 s 和 t，每个字符串中的字符都不重复，且 t 是 s 的一个排列。
 * 排列差 定义为 s 和 t 中每个字符在两个字符串中位置的绝对差值之和。
 * 返回 s 和 t 之间的 排列差 。
 * <p>
 * 示例 1：
 * 输入：s = "abc", t = "bac"
 * 输出：2
 * <p>
 * 解释：
 * 对于 s = "abc" 和 t = "bac"，排列差是：
 * <p>
 * "a" 在 s 中的位置与在 t 中的位置之差的绝对值。
 * "b" 在 s 中的位置与在 t 中的位置之差的绝对值。
 * "c" 在 s 中的位置与在 t 中的位置之差的绝对值。
 * 即，s 和 t 的排列差等于 |0 - 1| + |1 - 0| + |2 - 2| = 2。
 * 示例 2：
 * 输入：s = "abcde", t = "edbac"
 * <p>
 * 输出：12
 * 解释： s 和 t 的排列差等于 |0 - 3| + |1 - 2| + |2 - 4| + |3 - 1| + |4 - 0| = 12。
 */
public class Solution3146 {
    public static void main(String[] args) {
        String s = "abcde";
        String t = "edbac";
        System.out.println(new Solution3146().findPermutationDifference(s, t));
    }

    public int findPermutationDifference(String s, String t) {
        Map<Character, Integer> loc = new HashMap<>();
        char[] array = t.toCharArray();
        for (int i = 0; i < t.length(); i++) {
            loc.put(array[i], i);
        }

        int rs = 0;
        for (int i = 0; i < s.length(); i++) {
            rs += Math.abs(i - loc.get(s.charAt(i)));
        }
        return rs;
    }
}
