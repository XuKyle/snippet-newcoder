package com.kylexu.leetcode.str;

public class Solution1221 {
    public static void main(String[] args) {
        String s = "LLLLRRRR";
        int rs = new Solution1221().balancedStringSplit(s);
        System.out.println("rs = " + rs);
    }

    public int balancedStringSplit(String s) {
        int rs = 0;

        int lCount = 0;
        int rCount = 0;

        for (char c : s.toCharArray()) {
            if (c == 'L') {
                lCount++;
            } else if (c == 'R') {
                rCount++;
            }

            if (lCount != 0 && rCount != 0 && lCount == rCount) {
                rs++;
                lCount = 0;
                rCount = 0;
            }
        }
        return rs;
    }
}
