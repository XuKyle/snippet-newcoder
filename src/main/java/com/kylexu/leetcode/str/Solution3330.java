package com.kylexu.leetcode.str;

import java.util.ArrayList;
import java.util.List;

/**
 * 示例 1：
 * <p>
 * 输入：word = "abbcccc"
 * <p>
 * 输出：5
 * <p>
 * 解释：
 * <p>
 * 可能的字符串包括："abbcccc" ，"abbccc" ，"abbcc" ，"abbc" 和 "abcccc" 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：word = "abcd"
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * 唯一可能的字符串是 "abcd" 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：word = "aaaa"
 * <p>
 * 输出：4
 */
public class Solution3330 {
    public int possibleStringCount(String word) {
        List<Integer> rs = new ArrayList<>();
        int n = word.length();

        int left = 0;
        for (int i = 0; i < n; i++) {
            if (word.charAt(left) != word.charAt(i)) {
                rs.add(i - left);
                left = i;
            }

            if (i == n - 1) {
                rs.add(i - left + 1);
            }
        }

        int count = 0;
        boolean first = true;
        for (int i = 0; i < rs.size(); i++) {
            if (rs.get(i) > 1) {
                if (first) {
                    count += rs.get(i);
                    first = false;
                } else {
                    count += rs.get(i) - 1;
                }
            }
        }

        if (first) {
            return 1;
        }

        return count;
    }

    public static void main(String[] args) {
        String word = "aaaa";
        int i = new Solution3330().possibleStringCount(word);
        System.out.println("i = " + i);
    }
}
