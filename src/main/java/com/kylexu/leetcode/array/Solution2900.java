package com.kylexu.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class Solution2900 {
    public static void main(String[] args) {
//        输入：words = ["a","b","c","d"], groups = [1,0,1,1]
//        输出：["a","b","c"]
        String[] words = {"c", "w", "h", "s"};
        int[] groups = {0, 0, 0, 1};
        List<String> longestSubsequence = new Solution2900().getLongestSubsequence(words, groups);
        System.out.println("longestSubsequence = " + longestSubsequence);
    }

    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int oneIndex = 0;
        int zeroIndex = 0;
        int n = groups.length;

        while (oneIndex < n && groups[oneIndex] != 1) {
            oneIndex++;
        }
        while (zeroIndex < n && groups[zeroIndex] != 0) {
            zeroIndex++;
        }

        System.out.println("zeroIndex = " + zeroIndex);
        System.out.println("oneIndex = " + oneIndex);

        List<String> an1 = build(words, groups, oneIndex);
        List<String> an2 = build(words, groups, zeroIndex);

        return an1.size() > an2.size() ? an1 : an2;
    }

    private List<String> build(String[] words, int[] groups, int index) {
        List<String> rs = new ArrayList<>();
        if (index >= words.length) {
            return rs;
        }

        rs.add(words[index]);
        for (int i = index + 1; i < groups.length; i++) {
            if (groups[i - 1] != groups[i]) {
                rs.add(words[i]);
            }
        }
        return rs;
    }
}
