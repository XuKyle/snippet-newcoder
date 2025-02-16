package com.kylexu.leetcode.str;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个下标从 0 开始的字符串 word ，字符串只包含小写英文字母。你需要选择 一个 下标并 删除 下标处的字符，使得 word 中剩余每个字母出现 频率 相同。
 * <p>
 * 如果删除一个字母后，word 中剩余所有字母的出现频率都相同，那么返回 true ，否则返回 false 。
 * <p>
 * 注意：
 * <p>
 * 字母 x 的 频率 是这个字母在字符串中出现的次数。
 * 你 必须 恰好删除一个字母，不能一个字母都不删除。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：word = "abcc"
 * 输出：true
 * 解释：选择下标 3 并删除该字母：word 变成 "abc" 且每个字母出现频率都为 1 。
 * 示例 2：
 * <p>
 * 输入：word = "aazz"
 * 输出：false
 * 解释：我们必须删除一个字母，所以要么 "a" 的频率变为 1 且 "z" 的频率为 2 ，要么两个字母频率反过来。所以不可能让剩余所有字母出现频率相同。
 */
public class Solution2423 {
    public static void main(String[] args) {
        String word = "abbcc";
        System.out.println(new Solution2423().equalFrequency(word));
    }

    public boolean equalFrequency(String word) {
        Map<Character, Integer> mark = new HashMap<>();
        for (char c : word.toCharArray()) {
            mark.merge(c, 1, Integer::sum);
        }

        if (mark.size() == 1) {
            return true;
        }

        int max = 0;
        int min = Integer.MAX_VALUE;

        for (Map.Entry<Character, Integer> entry : mark.entrySet()) {
            max = Math.max(max, entry.getValue());
            min = Math.min(min, entry.getValue());
        }

        if (max == 1 && min == 1) {
            return true;
        }

        if (max == min) {
            return false;
        }

        int maxCnt = 0;
        int minCnt = 0;
        for (Map.Entry<Character, Integer> entry : mark.entrySet()) {
            if (entry.getValue() == max) {
                maxCnt++;
            } else if (entry.getValue() == min) {
                minCnt++;
            } else {
                return false;
            }

        }

        return maxCnt == 1 || minCnt == 1;
    }
}
