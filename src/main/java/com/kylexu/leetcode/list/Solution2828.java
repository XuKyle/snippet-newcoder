package com.kylexu.leetcode.list;

import java.util.List;

public class Solution2828 {
    public static void main(String[] args) {
        List<String> words = List.of("alice", "bob", "charlie");
        String s = "abc";
        System.out.println(new Solution2828().isAcronym(words, s));
    }

    public boolean isAcronym(List<String> words, String s) {
        StringBuilder rs = new StringBuilder();
        for (String word : words) {
            rs.append(word.charAt(0));
        }
        return s.contentEquals(rs);
    }
}
