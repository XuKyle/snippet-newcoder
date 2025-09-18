package com.kylexu.leetcode.str;

import java.util.HashMap;
import java.util.Map;

public class Solution3090 {
    public static void main(String[] args) {
        String s = "bcbbbcba";
        int i = new Solution3090().maximumLengthSubstring(s);
        System.out.println("i = " + i);
    }

    public int maximumLengthSubstring(String s) {
        Map<Character, Integer> counter = new HashMap<>();

        int l = 0;
        int r = l + 1;
        while (r < s.length()) {
//            if(counter.getOrDefault(s.charAt(r),0))

        }

        return 0;
    }
}
