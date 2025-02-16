package com.kylexu.leetcode.str;

public class Solution2042 {
    public static void main(String[] args) {
        String s = "1 box has 3 blue 4 red 6 green and 12 yellow marbles";
        boolean b = new Solution2042().areNumbersAscending(s);
        System.out.println("b = " + b);
    }

    public boolean areNumbersAscending(String s) {
        int pre = Integer.MIN_VALUE;

        for (String current : s.split(" ")) {
            if (Character.isDigit(current.charAt(0))) {
                if (Integer.parseInt(current) > pre) {
                    pre = Integer.parseInt(current);
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}

