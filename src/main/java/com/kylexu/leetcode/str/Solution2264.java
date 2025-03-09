package com.kylexu.leetcode.str;

public class Solution2264 {
    public static void main(String[] args) {
        String num = "6777133339";
        System.out.println(new Solution2264().largestGoodInteger(num));
    }

    public String largestGoodInteger(String num) {
        String[] arr = new String[]{
                "999", "888", "777", "666", "555",
                "444", "333", "222", "111", "000"
        };

        for (String s : arr) {
            if (num.contains(s)) {
                return s;
            }
        }

        return "";
    }
}
