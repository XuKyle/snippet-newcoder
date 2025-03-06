package com.kylexu.leetcode.str;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Solution1859 {
    public static void main(String[] args) {
        String s = "is2 sentence4 This1 a3";
        System.out.println(new Solution1859().sortSentence(s));
    }

    public String sortSentence(String s) {
        return Arrays.stream(s.split("\\s+"))
                .sorted(Comparator.comparingInt(value -> Integer.parseInt(value.substring(value.length() - 1))))
                .map(str -> str.substring(0, str.length() - 1))
                .collect(Collectors.joining(" "));
    }
}
