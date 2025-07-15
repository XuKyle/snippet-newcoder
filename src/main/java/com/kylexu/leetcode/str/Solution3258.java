package com.kylexu.leetcode.str;

public class Solution3258 {
    public static void main(String[] args) {
        String s = "10101";
        int k = 1;
        int i = new Solution3258().countKConstraintSubstrings(s, k);
        System.out.println("i = " + i);
    }

    public int countKConstraintSubstrings(String s, int k) {
        int rs = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length() + 1; j++) {
                String substring = s.substring(i, j);
                int countZero = countZero(substring);
                if (countZero <= k || substring.length() - countZero <= k) {
                    rs++;
                }
            }
        }

        return rs;
    }

    public int countZero(String s) {
        int rs = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                rs++;
            }
        }
        return rs;
    }
}
