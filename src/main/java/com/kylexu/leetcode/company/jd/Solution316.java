package com.kylexu.leetcode.company.jd;

import java.util.Arrays;

/**
 * 示例 1：
 * <p>
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 * <p>
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 */
public class Solution316 {
    public static void main(String[] args) {
        System.out.println(new Solution316().removeDuplicateLetters("cbacdcbc"));
        System.out.println(new Solution316().removeDuplicateLetters("bcabc"));
    }

    public String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        int[] count = new int[26];

        for (char aChar : chars) {
            count[aChar - 'a']++;
        }

        StringBuilder ans = new StringBuilder();
        boolean[] used = new boolean[26];

        for (char currentChar : chars) {
            int index = currentChar - 'a';
            count[index]--;
            if (used[index]) {
                continue;
            }

            while (!ans.isEmpty()
                    && currentChar < ans.charAt(ans.length() - 1)
                    && count[ans.charAt(ans.length() - 1) - 'a'] > 0) {
                used[ans.charAt(ans.length() - 1) - 'a'] = false;
                ans.deleteCharAt(ans.length() - 1);
            }

            ans.append(currentChar);
            used[index] = true;
        }

        return ans.toString();
    }
}
