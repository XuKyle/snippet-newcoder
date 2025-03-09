package com.kylexu.leetcode.str;

public class Solution1556 {
    public static void main(String[] args) {
        System.out.println(new Solution1556().thousandSeparator(123456789));
    }

    public String thousandSeparator(int n) {
        if (n < 1000) {
            return String.valueOf(n);
        }

        StringBuilder stringBuilder = new StringBuilder();

        String strN = String.valueOf(n);
        int first = strN.length() % 3;

        if (first != 0) {
            stringBuilder.append(strN, 0, first);
            stringBuilder.append(".");
        }

        for (int i = first; i < strN.length(); i += 3) {
            stringBuilder.append(strN, i, i + 3);
            stringBuilder.append(".");
        }


        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }
}
