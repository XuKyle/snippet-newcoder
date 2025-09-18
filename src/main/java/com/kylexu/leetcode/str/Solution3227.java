package com.kylexu.leetcode.str;

public class Solution3227 {
    public boolean doesAliceWin(String s) {
        return s.chars().anyMatch(c -> {return "aeiou".indexOf(c) != -1;});
    }
}
