package com.kylexu.leetcode.num;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution1796 {
    public static void main(String[] args) {
        String s = "xyz";
        System.out.println(new Solution1796().secondHighest(s));
    }

    public int secondHighest(String s) {
        List<Integer> rs = new ArrayList<>();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                rs.add(Character.getNumericValue(c));
            }
        }

        rs.sort(Comparator.reverseOrder());
        if (rs.isEmpty()) {
            return -1;
        }
        int max = rs.get(0);
        for (Integer r : rs) {
            if (max != r) {
                return r;
            }
        }

        return -1;
    }
}
