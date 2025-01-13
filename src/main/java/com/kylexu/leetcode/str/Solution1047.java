package com.kylexu.leetcode.str;

import java.util.LinkedList;

public class Solution1047 {
    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(new Solution1047().removeDuplicates(s));
    }


    public String removeDuplicates(String s) {
        LinkedList<Character> rs = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!rs.isEmpty() && rs.getLast() == c) {
                rs.removeLast();
            } else {
                rs.add(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        rs.forEach(sb::append);
        return sb.toString();
    }
}
