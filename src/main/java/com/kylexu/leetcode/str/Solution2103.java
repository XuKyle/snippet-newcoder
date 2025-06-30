package com.kylexu.leetcode.str;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2103 {
    public static void main(String[] args) {
        String rings = "B0B6G0R6R0R6G9";
        int i = new Solution2103().countPoints(rings);
        System.out.println("i = " + i);
    }

    public int countPoints(String rings) {
        List<Set<Character>> rs = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            rs.add(new HashSet<>());
        }

        for (int i = 0; i < rings.length(); i += 2) {
            char c = rings.charAt(i);
            int index = rings.charAt(i + 1) - '0';
            rs.get(index).add(c);
        }

        return (int) rs.stream().filter(s -> s.size() == 3).count();
    }
}
