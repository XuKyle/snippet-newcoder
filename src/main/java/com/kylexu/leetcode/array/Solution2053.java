package com.kylexu.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 示例 1:
 * 输入：arr = ["d","b","c","b","c","a"], k = 2
 * 输出："a"
 * 解释：
 * arr 中独一无二字符串包括 "d" 和 "a" 。
 * "d" 首先出现，所以它是第 1 个独一无二字符串。
 * "a" 第二个出现，所以它是 2 个独一无二字符串。
 * 由于 k == 2 ，返回 "a" 。
 * 示例 2:
 * <p>
 * 输入：arr = ["aaa","aa","a"], k = 1
 * 输出："aaa"
 * 解释：
 * arr 中所有字符串都是独一无二的，所以返回第 1 个字符串 "aaa" 。
 * 示例 3：
 * <p>
 * 输入：arr = ["a","b","a"], k = 3
 * 输出：""
 * 解释：
 * 唯一一个独一无二字符串是 "b" 。由于少于 3 个独一无二字符串，我们返回空字符串 "" 。
 */
public class Solution2053 {
    public static void main(String[] args) {
        String[] arr = new String[]{"d", "b", "c", "b", "c", "a"};
        int k = 2;
        System.out.println(new Solution2053().kthDistinct(arr, k));
    }

    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> mark = new HashMap<>();

        for (String s : arr) {
            mark.merge(s, 1, Integer::sum);
        }

        int index = 0;
        for (String s : arr) {
            if (mark.get(s) == 1) {
                if (++index == k) {
                    return s;
                }
            }
        }

        return "";
    }
}
