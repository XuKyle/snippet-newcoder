package com.kylexu.leetcode.str;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你长度相等的两个字符串 s1 和 s2 。一次 字符串交换 操作的步骤如下：选出某个字符串中的两个下标（不必不同），并交换这两个下标所对应的字符。
 * 如果对 其中一个字符串 执行 最多一次字符串交换 就可以使两个字符串相等，返回 true ；否则，返回 false 。
 * 示例 1：
 * 输入：s1 = "bank", s2 = "kanb"
 * 输出：true
 * 解释：例如，交换 s2 中的第一个和最后一个字符可以得到 "bank"
 * 示例 2：
 * <p>
 * 输入：s1 = "attack", s2 = "defend"
 * 输出：false
 * 解释：一次字符串交换无法使两个字符串相等
 * 示例 3：
 * <p>
 * 输入：s1 = "kelb", s2 = "kelb"
 * 输出：true
 * 解释：两个字符串已经相等，所以不需要进行字符串交换
 */
public class Solution1790 {
    public static void main(String[] args) {
        String s1 = "kelb";
        String s2 = "kelb";
        System.out.println(new Solution1790().areAlmostEqual(s1, s2));
    }

    public boolean areAlmostEqual(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }

        int n = s1.length();
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                index.add(i);
            }
        }

        if (index.size() != 2) {
            return false;
        }

        int left = index.get(0);
        int right = index.get(1);

        return s1.charAt(left) == s2.charAt(right) && s1.charAt(right) == s2.charAt(left);
    }
}
