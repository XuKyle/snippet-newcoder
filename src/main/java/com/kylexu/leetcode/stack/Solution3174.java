package com.kylexu.leetcode.stack;

import java.util.LinkedList;

public class Solution3174 {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(new Solution3174().clearDigits(s));
    }

    public String clearDigits(String s) {
        LinkedList<Character> letters = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                if (!letters.isEmpty()) {
                    letters.removeLast();
                }
            } else {
                letters.add(c);
            }
        }


        StringBuilder rs = new StringBuilder();
        for (Character letter : letters) {
            rs.append(letter);
        }
        return rs.toString();
    }
}
